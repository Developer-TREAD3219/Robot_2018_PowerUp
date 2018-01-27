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
public class AutoForward extends Command {
	private static final double AUTO_POWER_SETTING = 0.6;
	private double distance;

	/**
	 * 
	 */

	public AutoForward(double distance) {
		this.distance = distance;
	}

	protected void initialize() {
		Robot.driveTrain.setSafety(false);
		Robot.driveTrain.resetDistance();
		this.setTimeout(5);
		Robot.driveTrain.drive(AUTO_POWER_SETTING, AUTO_POWER_SETTING);
	}

	protected void execute() {
		Robot.driveTrain.drive(AUTO_POWER_SETTING, AUTO_POWER_SETTING);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		boolean timedOut = this.isTimedOut();
		double d = Robot.driveTrain.averageDistance();
		return timedOut || (d >= this.distance);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrain.stop();
		Robot.driveTrain.setSafety(true);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
