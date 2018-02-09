/**
 * 
 */
package org.usfirst.frc.team3219.robot.subsystems;

import org.usfirst.frc.team3219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Tread Developer
 *
 */
public class Shooter extends Subsystem {
	private static final double INFEED_MOTORPOWER = -0.5;
	private WPI_TalonSRX leftMotor = RobotMap.leftShooterMotor;
	private WPI_TalonSRX rightMotor = RobotMap.rightShooterMotor;
	private DoubleSolenoid liftsolenoid = RobotMap.liftsolenoid;
	private DigitalInput limitswitch = RobotMap.limitswitch;

	public Shooter() {
	}

	public void init() {
		liftsolenoid.set(Value.kForward);
		leftMotor.setInverted(false);
		rightMotor.setInverted(true);

		SmartDashboard.putBoolean("shooterposition", false);
		SmartDashboard.putBoolean("shootermotors", false);
	}

	@Override
	protected void initDefaultCommand() {
	}

	@Override
	public void periodic() {
	}

	// Shooter motors
	public void startInfeed() {
		leftMotor.set(INFEED_MOTORPOWER);
		rightMotor.set(INFEED_MOTORPOWER);
		SmartDashboard.putBoolean("shootermotors", true);
	}

	public void setPower(double input) {
		leftMotor.set(input);
		rightMotor.set(input);
		SmartDashboard.putBoolean("shootermotors", true);

	}

	public void stop() {
		leftMotor.set(0);
		rightMotor.set(0);
		SmartDashboard.putBoolean("shootermotors", false);
		System.out.println("stopped shooter motors");
	}

	public boolean hitlimit() {
		return limitswitch.get();
	}

	// Pneumatics

	public void raise(boolean up) {
		SmartDashboard.putBoolean("shooterposition", up);
		if (up) {
			liftsolenoid.set(Value.kForward);

		} else {
			liftsolenoid.set(Value.kReverse);
		}
	}
}
