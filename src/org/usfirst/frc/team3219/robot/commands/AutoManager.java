package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;
import org.usfirst.frc.team3219.robot.Robot.StartPosition;
import org.usfirst.frc.team3219.robot.Robot.Strategy;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoManager extends Command {
	// Class Constants
	static final boolean RIGHT_SIDE = false;
	static final boolean LEFT_SIDE = true;

	private AutoCommandSelector leftSelector;
	private AutoCommandSelector centerSelector;
	private AutoCommandSelector rightSelector;

	public AutoManager() {
		leftSelector = new AutoCommandSelector();
		centerSelector = new AutoCommandSelector();
		rightSelector = new AutoCommandSelector();
		leftSelector.setDefaultCommand(new AutoForward(Robot.DISTANCE_TO_AUTOLINE));
		rightSelector.setDefaultCommand(new AutoForward(Robot.DISTANCE_TO_AUTOLINE));
		centerSelector.setDefaultCommand(new AutoCenter());
		// centerSelector.setSpecificCommand(new AutonomousCommand(), Robot.Strategy.line, LEFT_SIDE, LEFT_SIDE);
	}

	@Override
	protected void initialize() {
		this.setTimeout(15);
		autoCommandDecide();
	}

	public void autoCommandDecide() {
		Strategy strategy = Robot.strategyChooser.getSelected();
		StartPosition startPosition = Robot.startPositionChooser.getSelected();
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		Robot.autoManager.setSideOwnership(gameData);
		Command startCommand = null;

		switch (startPosition) {
		case left:
			startCommand = leftSelector.selectAutoCommand(strategy);
			break;

		case center:
			startCommand = centerSelector.selectAutoCommand(strategy);
			break;

		case right:
			startCommand = rightSelector.selectAutoCommand(strategy);
			break;
		}
		if (startCommand != null) {
			startCommand.start();
		}
	}

	public void setSideOwnership(String gameData) {
		char allianceSwitch = gameData.charAt(0);
		char scale = gameData.charAt(1);
		char opposingSwitch = gameData.charAt(2);

		if (allianceSwitch == 'R') {
			Robot.allianceSwitch = RIGHT_SIDE;
		} else {
			Robot.allianceSwitch = LEFT_SIDE;
		}

		if (scale == 'R') {
			Robot.scale = RIGHT_SIDE;
		} else {
			Robot.scale = LEFT_SIDE;
		}

		if (opposingSwitch == 'R') {
			Robot.opposingSwitch = RIGHT_SIDE;
		} else {
			Robot.opposingSwitch = LEFT_SIDE;
		}
	}

	@Override
	protected boolean isFinished() {
		boolean timedOut = this.isTimedOut();
		return timedOut;
	}
}
