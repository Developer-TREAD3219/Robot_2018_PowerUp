/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;
import org.usfirst.frc.team3219.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * @author Tread Developer
 * Drive straight 15 feet.
 * 
 * Turn 90 degrees.
 * 
 * Drive up to the switch.
 * 
 * Activate the shoot.
 * 
 */
public class AutoLineAndShoot extends CommandGroup {
	public AutoLineAndShoot() {
		
		Sensors.zeroHeading();
		Command cmd1 = new AutoForward(0.8, 180);
		Command cmd2 = new AutoForwardTurn(0.5, -1.0, 90.0);
		Command cmd3 = new AutoForward(0.4, 24.0);
		Command cmd4 = new ShooterShoot();
		
		this.addSequential(cmd1);
		this.addSequential(cmd2);
		this.addSequential(cmd3);
		this.addSequential(cmd4);
	}

}
