//package org.usfirst.frc.team2523.robot.commands;
//
//import org.usfirst.frc.team2523.robot.Robot;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class LeftSide extends Command {
//
//	public char getSwitchSide() {
//		String gameData;
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
//		return gameData.charAt(0);
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	public boolean switchIsLeft() {
//		return getSwitchSide() == 'L';
//	}
//	
//	public boolean switchIsRight() {
//		return getSwitchSide() == 'R';
//	}
//	
//    public LeftSide() {
//        // Use requires() here to declare subsystem dependencies
//        requires(Robot.kAutoDrive);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    	
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	Robot.kLift.adjLift(-.5);
//    	Robot.kAutoDrive.goDist(108);
//    	Robot.kAutoDrive.turnAngle(-90);
//    	Robot.kAutoDrive.Stop();
//    	if(switchIsLeft()) {
//    		Robot.kFeederSystem.expel();
//    	}
//    		
//    	
//    	
//    	
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return true;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}
