package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class testAuto2 extends Command {

    public testAuto2() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kPIDL);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kPIDL.setSetpoint(36*1821);
    	Robot.kPIDL.setAbsoluteTolerance(20);
    	Robot.kPIDL.enable();
    
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.kPIDL.onTarget()) {
    		Robot.kPIDL.disable();
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kPIDL.disable();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.kPIDL.disable();
    }
}
