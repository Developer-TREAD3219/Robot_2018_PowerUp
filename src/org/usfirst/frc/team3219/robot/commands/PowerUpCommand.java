package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PowerUpCommand extends Command {
	boolean powerUp = false;

	public PowerUpCommand(boolean more) {
		powerUp = more;

	}

	@Override
	protected void initialize() {
		Robot.driveTrain.morePowerScotty(powerUp);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
