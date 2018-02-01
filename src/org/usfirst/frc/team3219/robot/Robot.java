// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team3219.robot;

import org.usfirst.frc.team3219.robot.commands.AutoForward;
import org.usfirst.frc.team3219.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3219.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3219.robot.subsystems.PowerManagment;
import org.usfirst.frc.team3219.robot.subsystems.Sensors;
import org.usfirst.frc.team3219.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	private static final int DISTANCE_TO_AUTOLINE = 120;
	static final boolean RIGHT_SIDE = false;
	static final boolean LEFT_SIDE = true;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	SendableChooser<String> startPositionChooser = new SendableChooser<>();

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static DriveTrain driveTrain;
	public static Shooter shooter;
	public static PowerManagment powerManagment;
	public static boolean allianceSwitch;
	public static boolean scale;
	public static boolean opposingSwitch;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveTrain = new DriveTrain();
		driveTrain.init();

		shooter = new Shooter();
		shooter.init();

		powerManagment = new PowerManagment();
		powerManagment.init();
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// Add commands to Autonomous Sendable Chooser
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		chooser.addDefault("Autonomous Command", new AutonomousCommand());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
		SmartDashboard.putData("Auto mode", chooser);
		autonomousCommand = new AutoForward(DISTANCE_TO_AUTOLINE);
		
		startPositionChooser.addDefault("Left", "Left");
		startPositionChooser.addObject("Center", "Center");
		startPositionChooser.addObject("Right", "Right");
		SmartDashboard.putData("Start Position", startPositionChooser);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it to
	 * reset subsystems before shutting down.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		Sensors.heading();
	}

	@Override
	public void autonomousInit() {
		if (autonomousCommand == null) {
			autonomousCommand = chooser.getSelected();
		}
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		setSideOwnership(gameData);
		String start = startPositionChooser.getSelected();
		SmartDashboard.putString("Chosen Start", start);
	}

	static void setSideOwnership(String gameData) {
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

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Sensors.heading();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.leftDistance());
		SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.rightDistance());
	}
}
