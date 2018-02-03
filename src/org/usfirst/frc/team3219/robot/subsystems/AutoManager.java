package org.usfirst.frc.team3219.robot.subsystems;

import org.usfirst.frc.team3219.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoManager extends Command{
	// Class Constants
	static final boolean RIGHT_SIDE = false;
	static final boolean LEFT_SIDE = true;
	
	@Override
	protected void initialize() {
		this.setTimeout(15);
		autoCommandDecide();
	}
	
	public void autoCommandDecide() {
		String strategy = Robot.strategyChooser.getSelected();
		String startPosition = Robot.startPositionChooser.getSelected();
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		Robot.autoManager.setSideOwnership(gameData);
		
		if(startPosition == "Left") {
			if(strategy == "AutoLine") {
				Robot.autoForward.start();
			} else if(strategy == "AutoLine & Switch") {
				if(Robot.allianceSwitch == RIGHT_SIDE) {
					Robot.autoForward.start();
				} else if(Robot.allianceSwitch == LEFT_SIDE) {
					Robot.autoForward.start();
				}
			} else if(strategy == "AutoLine & Scale") {
				if(Robot.scale == RIGHT_SIDE) {
					
				} else if(Robot.scale == LEFT_SIDE) {
					
				}
			}
		} else if(startPosition == "Center") {
			if(strategy == "AutoLine") {

			} else if(strategy == "AutoLine & Switch") {
				if(Robot.allianceSwitch == RIGHT_SIDE) {

				} else if(Robot.allianceSwitch == LEFT_SIDE) {

				}
			} else if(strategy == "AutoLine & Scale") {
				if(Robot.scale == RIGHT_SIDE) {
					
				} else if(Robot.scale == LEFT_SIDE) {
					
				}
			}
		} else if(startPosition == "Right") {
			if(strategy == "AutoLine") {
				Robot.autoForward.start();
			} else if(strategy == "AutoLine & Switch") {
				if(Robot.allianceSwitch == RIGHT_SIDE) {
					Robot.autoForward.start();
				} else if(Robot.allianceSwitch == LEFT_SIDE) {
					Robot.autoForward.start();
				}
			} else if(strategy == "AutoLine & Scale") {
				if(Robot.scale == RIGHT_SIDE) {
					
				} else if(Robot.scale == LEFT_SIDE) {
					
				}
			}
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
