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

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3219.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3219.robot.commands.ClimberClimb;
import org.usfirst.frc.team3219.robot.commands.PowerUpCommand;
import org.usfirst.frc.team3219.robot.commands.ShiftCommand;
import org.usfirst.frc.team3219.robot.commands.ShooterInfeed;
import org.usfirst.frc.team3219.robot.commands.ShooterLower;
import org.usfirst.frc.team3219.robot.commands.ShooterRaise;
import org.usfirst.frc.team3219.robot.commands.ShooterShoot;
import org.usfirst.frc.team3219.robot.commands.StickDrive;
import org.usfirst.frc.team3219.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Joystick leftJoystick;
	public Joystick rightJoystick;
	public Button leftJoystickShiftButton;
	public Button rightJoystickShiftButton;
	public Joystick controller;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public Button leftPowerUp;
	public Button rightPowerUp;
	public Button xboxLeftTrigger;
	public Button xboxRightTrigger;
	public Button infeed;
	public Button shoot;
	public Button climb;
	
	public OI() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		rightJoystick = new Joystick(1);

		leftJoystick = new Joystick(0);

		leftJoystickShiftButton = new JoystickButton(leftJoystick, 1);

		rightJoystickShiftButton = new JoystickButton(rightJoystick, 1);
		leftPowerUp = new JoystickButton(leftJoystick, 2);

		rightPowerUp = new JoystickButton(rightJoystick, 2);

		// SmartDashboard Buttons
		SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
		SmartDashboard.putData("StickDrive", new StickDrive());

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		leftJoystickShiftButton.whenPressed(new ShiftCommand(DriveTrain.HIGH_GEAR));
		rightJoystickShiftButton.whenPressed(new ShiftCommand(DriveTrain.LOW_GEAR));// TODO
		leftPowerUp.whenPressed(new PowerUpCommand(true));
		rightPowerUp.whenPressed(new PowerUpCommand(false));

		controller = new Joystick(2);
		xboxLeftTrigger = new JoystickButton(controller, 7);
		xboxRightTrigger = new JoystickButton(controller, 8);
		xboxLeftTrigger.whenPressed(new ShooterRaise());
		xboxRightTrigger.whenPressed(new ShooterLower());
		infeed = new JoystickButton(controller, 1);
		shoot = new JoystickButton(controller, 3);
		infeed.whenPressed(new ShooterInfeed());
		shoot.whenPressed(new ShooterShoot());
		
		climb = new JoystickButton(controller,2);
		climb.whenPressed(new ClimberClimb());
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getRightJoystick() {
		return rightJoystick;
	}
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
