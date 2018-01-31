package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftCommand extends Command {
	private boolean highGear;
	
	public ShiftCommand(boolean in) {
		highGear = in;
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.shift(highGear);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
