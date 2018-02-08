/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import org.usfirst.frc.team3219.robot.Robot;
import org.usfirst.frc.team3219.robot.Robot.Strategy;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tread Developer
 *
 */
public class AutoCommandSelector {
	public enum Side {
		leftside,
		rightside,
		dont_care
	}
	
	private Command[][][] commandSet = new Command[Robot.Strategy.values().length][2][2];

	public AutoCommandSelector() {
		
	}
	
	public void setDefaultCommand(Command c) {
		for(int ii = 0; ii < commandSet.length; ++ii) {
			for(int jj = 0; jj < commandSet[0].length; ++jj) {
				for(int kk = 0; kk < commandSet[0][0].length; ++kk) {
					commandSet[ii][jj][kk] = c;
				}
			}
		}
	}
	
	public void setSpecificCommand(Command c, Strategy s, Side switchSide , Side scale) {
		int strategyIndex = s.ordinal();
		int switchIndex = switchSide == Side.leftside ? 0:1;
		int scaleIndex = scale == Side.leftside ? 0:1;
		if (scale == Side.dont_care) {
			commandSet[strategyIndex][switchIndex][0] = c;
			commandSet[strategyIndex][switchIndex][1] = c;
			if (switchSide == Side.dont_care) {
				// switchIndex will be 1, so fill in 0 side
				commandSet[strategyIndex][0][0] = c;
				commandSet[strategyIndex][0][1] = c;
			}
		} else if (switchSide == Side.dont_care) {
			commandSet[strategyIndex][0][scaleIndex] = c;
			commandSet[strategyIndex][1][scaleIndex] = c;			
		} else {
			commandSet[strategyIndex][switchIndex][scaleIndex] = c;
		}
	}

	public Command selectAutoCommand(Strategy strategy) {
		Command selectedCommand = commandSet[strategy.ordinal()][Robot.allianceSwitch ? 0 : 1][Robot.scale ? 0 : 1];

		return selectedCommand;
	}

}
