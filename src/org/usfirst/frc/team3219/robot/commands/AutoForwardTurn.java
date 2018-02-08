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
public class AutoForwardTurn extends Command {
	double forwardSpeed;
	double turnRate;
	double finalAngle;

	public AutoForwardTurn(double forward, double turn, double angle) {
		forwardSpeed = forward;
		turnRate = turn;
		finalAngle = angle;
	}

	protected void initialize() {
		Robot.driveTrain.autoDrive(this.forwardSpeed, this.turnRate);
		this.setTimeout(4);
		System.out.println("AutoForwardTurn(" + forwardSpeed + ", " + turnRate + ", " + finalAngle + ")");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		double angle = Sensors.heading();
		boolean isLeft = turnRate > 0;
		boolean farEnoughLeft = angle <= finalAngle;
		boolean farEnoughRight = angle >= finalAngle;

		return this.isTimedOut() || (isLeft ? farEnoughLeft : farEnoughRight);
	}

	protected void execute() {
		Robot.driveTrain.autoDrive(this.forwardSpeed, this.turnRate);
	}

	protected void end() {
		Robot.driveTrain.stop();
	}
}
