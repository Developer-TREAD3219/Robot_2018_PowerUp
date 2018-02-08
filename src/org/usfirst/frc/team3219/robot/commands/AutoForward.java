/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;
import org.usfirst.frc.team3219.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tread Developer
 *
 */
public class AutoForward extends Command {
	private static final double AUTO_POWER_SETTING = 0.6;
	private double power = AUTO_POWER_SETTING;
	private double distance;
	private double heading;

	/**
	 * 
	 */

	public AutoForward(double distance) {
		this.distance = distance;
	}

	public AutoForward(double p, double d) {
		this.power = p;
		this.distance = d;
	}

	protected void initialize() {
		Robot.driveTrain.setSafety(false);
		Robot.driveTrain.resetDistance();
		this.setTimeout(5);
		Robot.driveTrain.autoDrive(AUTO_POWER_SETTING, 0);
		heading = Sensors.heading();
	}

	protected void execute() {
		double angle = Sensors.heading() - this.heading;
		double turnRate = angle / 10.0;
		Robot.driveTrain.autoDrive(AUTO_POWER_SETTING, turnRate);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		boolean timedOut = this.isTimedOut();
		double d = Robot.driveTrain.robotCenterDistance();
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
