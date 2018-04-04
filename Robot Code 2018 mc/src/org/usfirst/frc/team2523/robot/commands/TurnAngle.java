package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAngle extends Command {
double ang;
double power;

    public TurnAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kAutoDrive);
        ang = angle;
        power = .5;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kAutoDrive.turnAngleSetup(ang, power);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kAutoDrive.turnAngle();
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
