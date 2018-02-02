package org.usfirst.frc.team3219.robot.subsystems;

import org.usfirst.frc.team3219.robot.Robot;

public class AutoManager {
	// Class Constants
	static final boolean RIGHT_SIDE = false;
	static final boolean LEFT_SIDE = true;
	
	public void autoCommandDecide() {
		String strategy = Robot.strategyChooser.getSelected();
		String startPosition = Robot.startPositionChooser.getSelected();
		if(startPosition == "Left") {
			if(strategy == "AutoLine") {
				Robot.autonomousCommand.start();
			} else if(strategy == "AutoLine & Switch") {
				
			} else if(strategy == "AutoLine & Scale") {
				
			}
		} else if(startPosition == "Center") {
			if(strategy == "AutoLine") {
				
			} else if(strategy == "AutoLine & Switch") {
				
			} else if(strategy == "AutoLine & Scale") {
				
			}
		} else if(startPosition == "Right") {
			if(strategy == "AutoLine") {
				
			} else if(strategy == "AutoLine & Switch") {
				
			} else if(strategy == "AutoLine & Scale") {
				
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
}
