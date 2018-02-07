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

	protected void initialize () {
		Robot.driveTrain.autoDrive(this.forwardSpeed, this.turnRate);
		this.setTimeout(4);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		double angle = Math.abs( Sensors.heading());
		return this.isTimedOut() || (angle >= this.finalAngle );
	}
	
	protected void execute () {
		Robot.driveTrain.autoDrive(this.forwardSpeed, this.turnRate);
	}

	protected void end () {
		Robot.driveTrain.stop();
	}
}
