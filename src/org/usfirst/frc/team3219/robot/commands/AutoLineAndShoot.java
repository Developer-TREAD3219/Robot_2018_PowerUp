/**
 * 
 */
package org.usfirst.frc.team3219.robot.commands;
import org.usfirst.frc.team3219.robot.Robot;
import org.usfirst.frc.team3219.robot.subsystems.Sensors;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	private static final double LEG_TWO_DISTANCE = 24.0;
	private static final double LEG_TWO_POWER = 0.4;
	private static final double FINAL_ANGLE = 90.0;
	private static final double TURN_RATE = -.80;
	private static final double TURN_POWER = 0.5;
	private static final int FIRST_LEG_DISTANCE = 180;
	private static final double FORWARD_POWER = 0.8;

	public AutoLineAndShoot(boolean isLeft){
		double turnLeftRight = -1.0;
		SmartDashboard.putBoolean("autocenter", Robot.allianceSwitch);
		if (isLeft == Robot.LEFT_SIDE) {
			turnLeftRight = 1.0;
			
		}
		Command cmd1 = new AutoForward(FORWARD_POWER, FIRST_LEG_DISTANCE);
		Command cmd2 = new AutoForwardTurn(TURN_POWER, turnLeftRight * TURN_RATE, turnLeftRight * FINAL_ANGLE);
		Command cmd3 = new AutoBonk();
		Command cmd4 = new ShooterShoot();
	
		this.addSequential(cmd1);
		this.addSequential(cmd2);
		this.addSequential(cmd3);
		this.addSequential(cmd4);
	}

}
