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
public class ShooterInfeed extends Command {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {

		return Robot.shooter.hitlimit() || this.isTimedOut();
	}

	protected void initialize() {
		if (!Robot.shooter.hitlimit()) {
			Robot.shooter.startInfeed();
		}
		this.setTimeout(1);

	}

	protected void end() {
		Robot.shooter.stop();
	}
}
