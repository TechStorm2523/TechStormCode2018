package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class testAutoDrive extends Command {

    public testAutoDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kAutoDrive);
        requires(Robot.KADL);
        requires(Robot.KADR);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kAutoDrive.autoSetup();
    	
    	Robot.KADL.setAbsoluteTolerance(10);
    	Robot.KADR.setAbsoluteTolerance(10);
    	
    	Robot.KADL.setSetpoint(72*217.3);
    	Robot.KADR.setSetpoint(72*217.3);
    	
    	Robot.KADL.enable();
    	Robot.KADR.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.KADR.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.KADL.disable();
    	Robot.KADR.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.KADL.disable();
    	Robot.KADR.disable();
    }
}
