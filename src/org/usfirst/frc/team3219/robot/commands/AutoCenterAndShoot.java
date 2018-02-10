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
public class AutoCenterAndShoot extends CommandGroup {
	
	public AutoCenterAndShoot() {
		
		Command cmd1 = new DelayStartAutoCenter();
		Command cmd2 = new ShooterShoot();
		
		this.addSequential(cmd1);
		this.addSequential(cmd2);
	}

}
