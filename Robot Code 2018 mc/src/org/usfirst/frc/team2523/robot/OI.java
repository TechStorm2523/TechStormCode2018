/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2523.robot;

import org.usfirst.frc.team2523.robot.commands.FeedIn;
import org.usfirst.frc.team2523.robot.commands.FeedOut;
import org.usfirst.frc.team2523.robot.commands.LeftFeed;
import org.usfirst.frc.team2523.robot.commands.RightFeed;
//import org.usfirst.frc.team2523.robot.commands.FeedIn;
//import org.usfirst.frc.team2523.robot.commands.FeedOut;
//import org.usfirst.frc.team2523.robot.commands.LeftFeed;
//import org.usfirst.frc.team2523.robot.commands.RightFeed;
import org.usfirst.frc.team2523.robot.commands.liftDown;
import org.usfirst.frc.team2523.robot.commands.liftUp;
import org.usfirst.frc.team2523.robot.commands.toggleOverride;
import org.usfirst.frc.team2523.robot.commands.RFS;
//import org.usfirst.frc.team2523.robot.commands.FeedMe;
//import org.usfirst.frc.team2523.robot.commands.FeedOut;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	
	public boolean reversed = false;
	public Joystick driveStick = new Joystick(0);

	Button feedButton = new JoystickButton(driveStick, 2);
	Button revFeedButton = new JoystickButton(driveStick, 1);
	Button LeftFeedButton = new JoystickButton(driveStick, 3);
	Button RightFeedButton = new JoystickButton(driveStick, 5);
	Button LiftUpButt = new JoystickButton(driveStick, 6);
	Button LiftDownButt = new JoystickButton(driveStick, 4);
	Button RFSi = new JoystickButton(driveStick, 11);
	Button ovrT = new JoystickButton(driveStick, 8);
	
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	public OI() {
		ovrT.whenPressed(new toggleOverride());
		RFSi.whileHeld(new RFS());
		LiftUpButt.whileHeld(new liftUp());
		LiftDownButt.whileHeld(new liftDown());
		feedButton.whileHeld(new FeedIn());
		revFeedButton.whileHeld(new FeedOut());
		LeftFeedButton.whileHeld(new LeftFeed());
		RightFeedButton.whileHeld(new RightFeed());
	}
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
}
