package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class toggleOverride extends InstantCommand {

    public toggleOverride() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.OVR = !Robot.OVR;
//    	if(Robot.OVR = false) {
//    		Robot.kLift.liftSetup();
//    	}
    }

}
