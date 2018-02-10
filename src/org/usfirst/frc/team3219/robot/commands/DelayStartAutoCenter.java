/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Tread Developer
 *
 */
public class DelayStartAutoCenter extends Command {

	@Override
	protected void initialize() {
		//SmartDashboard.putString("DelayStartAutoCenter", "started");
		Command cmd = new AutoCenter();
		cmd.start();
	}
	
	/* (non-Javadoc)
	 * @see edu.wpi.first.wpilibj.command.Command#isFinished()
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}
}
