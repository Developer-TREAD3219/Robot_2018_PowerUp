/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Tread Developer
 *
 */
public class AutoBonk extends Command {
	private static final double MOTOR_THRESH_AMPS = 20.0;
	private static final double AUTO_POWER_SETTING = 0.6;
	private double heading;
	private long startTime;

	@Override
	protected void initialize() {
		Robot.driveTrain.setSafety(false);
		this.setTimeout(5);
		Robot.driveTrain.stop();
		heading = Robot.sensors.heading();
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		if (System.currentTimeMillis() - startTime > 250) {
			double angle = Robot.sensors.heading() - this.heading;
			double turnRate = angle / 10.0;
			Robot.driveTrain.autoDrive(AUTO_POWER_SETTING, turnRate);
		}
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
		Robot.driveTrain.setSafety(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		double motorCurrent = Robot.powerManagment.driveMotorCurrent();
		boolean currentThreshold = motorCurrent > MOTOR_THRESH_AMPS;
		boolean timePassed = System.currentTimeMillis() - startTime > 250;
		SmartDashboard.putBoolean("CurrentThreshhold", currentThreshold);
		SmartDashboard.putBoolean("Bonked", Robot.sensors.bonked());
		return this.isTimedOut() || (timePassed && currentThreshold) || Robot.sensors.bonked();

	}

}
