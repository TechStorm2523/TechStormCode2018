package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.subsystems.LiftSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class liftDown extends Command {
	
    public liftDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kLift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kLift.ReverseLift();
    
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(-1*(Robot.kLift.getLiftPos())>1000) {
    		Robot.kLift.ReverseLift();
    	} else {
    		Robot.kLift.StopLift();
    	}
    	SmartDashboard.putNumber("LiftEncoder", Robot.kLift.getLiftPos());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kLift.StopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.kLift.StopLift();
    }
}
