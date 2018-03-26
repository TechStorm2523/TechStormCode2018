package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoDistance extends Command {
double inches;
boolean stopAfter;
double power;

public GoDistance(double inches) {
    // Use requires() here to declare subsystem dependencies
	stopAfter = false;
    requires(Robot.kAutoDrive);
    this.inches = inches;
    power=.5;
}	

    public GoDistance(double inches, double power) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kAutoDrive);
        this.inches = inches;
        this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kAutoDrive.goDistSetup(inches, power);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kAutoDrive.goDist();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    		Robot.kAutoDrive.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
