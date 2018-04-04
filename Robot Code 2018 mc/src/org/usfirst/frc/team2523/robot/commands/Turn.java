package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turn extends Command {
	private double dist;
    public Turn(double distDegrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	dist = distDegrees;
    	requires(Robot.kDriveTeleop);
        requires(Robot.KADL);
        requires(Robot.KADR);
    	
    }

    // Called just before this Command runs the first time
protected void initialize() {
    	
    	Robot.kDriveTeleop.driveSetup();
    	
  
    	
    	Robot.KADL.setSetpoint(-dist*50);
    	Robot.KADR.setSetpoint(dist*50);
    	
    	
      	Robot.KADL.setAbsoluteTolerance(20);
    	Robot.KADR.setAbsoluteTolerance(20);
    	
    	Robot.KADL.enable();
    	Robot.KADR.enable();
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	SmartDashboard.putNumber("ADLTurn", Robot.KADL.getPosition());
    	SmartDashboard.putNumber("ADRturn", Robot.KADR.getPosition());
    	SmartDashboard.putBoolean("OnTLTurn", Robot.KADL.onTarget());
    	SmartDashboard.putBoolean("OnTRTurn", Robot.KADR.onTarget());
    	
    	
    	SmartDashboard.putNumber("OutputTurn", Robot.KADL.getPIDController().get());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return Robot.KADR.onTarget() || Robot.KADL.onTarget();
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
