/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import java.lang.invoke.SwitchPoint;

import org.usfirst.frc.team3219.robot.Robot;
import org.usfirst.frc.team3219.robot.Robot.Strategy;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Tread Developer
 *
 */
public class AutoCommandSelector {

	Command[][][] commandSet = new Command[Robot.Strategy.values().length][2][2];

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
	
	public void setSpecificCommand(Command c, Strategy s, boolean switchSide , boolean scale) {
		int strategyIndex = s.ordinal();
		int switchIndex = switchSide == AutoManager.LEFT_SIDE ? 0:1;
		int scaleIndex = scale == AutoManager.LEFT_SIDE ? 0:1;
		commandSet[strategyIndex][switchIndex][scaleIndex] = c;
	}

	public Command selectAutoCommand(Strategy strategy) {
		Command selectedCommand = commandSet[strategy.ordinal()][Robot.allianceSwitch ? 0 : 1][Robot.scale ? 0 : 1];

		return selectedCommand;
	}

}
