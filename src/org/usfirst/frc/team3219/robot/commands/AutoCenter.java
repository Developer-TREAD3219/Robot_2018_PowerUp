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
public class AutoCenter extends CommandGroup {
	private static final double DISTANCE_TWO = 3.0;
	private static final double DISTANCE_ONE = 3.5;
	private static final int INCHES_PER_FOOT = 12;
	private static final double FINAL_ANGLE = 0.0;
	private static final double INTERMEDIATE_ANGLE = 30.0;
	private static final double TURN_RATE = -0.5;
	private static final double FORWARD_POWER = 0.5;

	public AutoCenter() {
		Command cmd1 = new AutoForwardTurn(0.8, TURN_RATE, INTERMEDIATE_ANGLE);
		Command cmd2 = new AutoForward(FORWARD_POWER, DISTANCE_ONE * INCHES_PER_FOOT);
		Command cmd3 = new AutoForwardTurn(0.8, -TURN_RATE, FINAL_ANGLE);
		Command cmd4 = new AutoForward(FORWARD_POWER, DISTANCE_TWO * INCHES_PER_FOOT);

		this.addSequential(cmd1);
		this.addSequential(cmd2);
		this.addSequential(cmd3);
		this.addSequential(cmd4);
	}
}
