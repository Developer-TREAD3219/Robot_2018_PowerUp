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
public class ClimberClimb extends Command {
	double startTime;

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return Robot.sensors.climbed();

	}

	@Override
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Robot.shooter.raise(false);
		Robot.climber.climb(true);
		Robot.driveTrain.shift(false);
		Robot.driveTrain.autoDrive(0.2, 0);
	}

	@Override
	protected void execute() {
		if (System.currentTimeMillis() - startTime >= 250) {
			Robot.driveTrain.stop();

		}
	}

	@Override
	protected void end() {
		Robot.climber.climb(false);
		Robot.driveTrain.stop();
	}
}
