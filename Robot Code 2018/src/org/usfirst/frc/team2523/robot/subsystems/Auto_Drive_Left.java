package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Auto_Drive_Left extends PIDSubsystem {

    // Initialize your subsystem here
    public Auto_Drive_Left() {
    	
    	super(0, 0, 0);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
    	
    	
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.kDriveTeleop.getL();
    }

    protected void usePIDOutput(double output) {
    	Robot.kDriveTeleop.setL(output);
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
