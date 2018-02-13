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
public class Climber extends Subsystem {
	private WPI_TalonSRX climberMotor;

	public Climber() {
		climberMotor = RobotMap.climberDriver;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
	 */
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void climb(boolean onOff) {
		if (onOff) {
			climberMotor.set(1.0);
		} else {
			climberMotor.set(0.0);
		}
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
}
