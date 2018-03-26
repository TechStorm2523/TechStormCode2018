package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Center extends Command {

	public char getSwitchSide() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		return gameData.charAt(0);
	}
	
	
	public boolean switchIsLeft() {
		return getSwitchSide() == 'L';
	}
	
	public boolean switchIsRight() {
		return getSwitchSide() == 'R';
	}
	
    public Center() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kAutoDrive);
        requires(Robot.kFeederSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.kLift.adjLift(0);
    	Robot.kAutoDrive.goDistSetup(90);
    	
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
    	Timer.delay(.5);
    	Robot.kAutoDrive.setLeft(1);
    	Robot.kAutoDrive.setRight(1);
    	Timer.delay(.5);
    	Robot.kAutoDrive.Stop();
    	if(getSwitchSide() == 'R') {
    		Robot.kFeederSystem.expel();
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
