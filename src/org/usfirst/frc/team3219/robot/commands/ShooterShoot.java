/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tread Developer
 *
 */
public class ShooterShoot extends Command {
	private static final double SHOOTER_POWER = 1.0;
	private static final double MOTOR_SHUTDOWN_TIME = 1.5;

	public ShooterShoot() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {

		return this.isTimedOut();
	}

	protected void initialize() {
		this.setTimeout(MOTOR_SHUTDOWN_TIME);
		Robot.shooter.setPower(SHOOTER_POWER);

	}

	protected void end() {
		Robot.shooter.stop();
	}
}
