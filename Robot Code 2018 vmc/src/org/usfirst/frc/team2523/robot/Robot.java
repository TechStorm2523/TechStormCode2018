/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2523.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2523.robot.commands.Auto1;
import org.usfirst.frc.team2523.robot.commands.AutoCenter;
import org.usfirst.frc.team2523.robot.commands.AutoLeftScale;
import org.usfirst.frc.team2523.robot.commands.AutoLeftSwitch;
import org.usfirst.frc.team2523.robot.commands.AutoRightScale;
import org.usfirst.frc.team2523.robot.commands.ExampleCommand;
//import org.usfirst.frc.team2523.robot.commands.DeluxeChooser;
import org.usfirst.frc.team2523.robot.commands.driveTest;
import org.usfirst.frc.team2523.robot.commands.testAutoDrive;
import org.usfirst.frc.team2523.robot.subsystems.ADL;
import org.usfirst.frc.team2523.robot.subsystems.ADR;
import org.usfirst.frc.team2523.robot.subsystems.AutoDrive;
import org.usfirst.frc.team2523.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2523.robot.subsystems.FeederSystem;
import org.usfirst.frc.team2523.robot.subsystems.LiftSystem;
import org.usfirst.frc.team2523.robot.subsystems.PID_LiftSystem;
import org.usfirst.frc.team2523.robot.subsystems.driveTeleop;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	
	
	public static String gameData;
	public static boolean OVR = false;
	public static final ExampleSubsystem kExampleSubsystem
			= new ExampleSubsystem();
	public static final driveTeleop kDriveTeleop
			= new driveTeleop();
	public static final LiftSystem kLift
			= new LiftSystem();
	public static final ADR KADR
			= new ADR();
	
	public static final ADL KADL
			= new ADL();
	
	public static final PID_LiftSystem kPIDL
			= new PID_LiftSystem();
	
	
	
	public static final FeederSystem kFeederSystem
			= new FeederSystem();
	
	public static final AutoDrive kAutoDrive = new AutoDrive();
	public static OI m_oi;
	

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		System.out.println("Test RobotInit");
		kLift.liftSetup();
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new testAutoDrive());
		// chooser.addObject("My Auto", new MyAutoCommand());
		
		
		m_chooser.addObject("Left Scale - use with 100% center auto", new AutoLeftScale());
		m_chooser.addObject("Left Switch - use with 50/50 center auto", new AutoLeftSwitch());
		m_chooser.addObject("Center - use with baseline or scale bots", new AutoCenter());
		m_chooser.addObject("Right Scale - use when center is covered", new AutoRightScale());
		
		//m_chooser.addObject("left Side", new LeftSide());
		//m_chooser.addObject("right Side", new RightSide());
		//m_chooser.addObject("deluxe Chooser", new DeluxeChooser()); //From dead center
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//kLift.liftSetup();
		System.out.println("Test AutoInit");
		m_autonomousCommand = m_chooser.getSelected();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {
		System.out.println("Test TeleopInit");
		kDriveTeleop.driveSetup();
		//kLift.liftSetup();
		//kLift.liftSetup();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		System.out.print("Test TeleopPeriodic");
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Override", this.OVR);
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
