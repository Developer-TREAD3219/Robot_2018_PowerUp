/**
 * 
 */
package org.usfirst.frc.team3219.robot.subsystems;

import org.usfirst.frc.team3219.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Tread Developer
 *
 */
public class Shooter extends Subsystem {
	private WPI_TalonSRX leftMotor = RobotMap.leftShooterMotor;
	private WPI_TalonSRX rightMotor = RobotMap.rightShooterMotor;
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	// Pnumatics
	
	// Shooter motors
	public void setPower(double input) {
		leftMotor.set(input);
		rightMotor.set(input);
	}
	
	public void stop() {
		leftMotor.set(0);
		rightMotor.set(0);
	}
	
	public void init() {
		
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop
	}
}
