/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Tread Developer
 *
 */
public class AutolineAndShootFarSide extends CommandGroup {
	
	public AutolineAndShootFarSide() {
		
		Command cmd1 = new AutoForward(200);
	}

}
