package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseLift extends Command {
double inches;
    public RaiseLift(double inches) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kLift);
        this.inches = inches;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kLift.adjLiftSetup(inches);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kLift.adjLift();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kLift.StopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
