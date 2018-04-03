package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftSwitchSWITCH extends CommandGroup {
	
    public AutoLeftSwitchSWITCH() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	
    	
    	
    	
    	
    		/**
    		 * Scale Auto: Drive forward 310 inches at 80%, turn right 90 degrees at 50%, drive back 10 inches at 50%, lift to max, expel at at max
    		 *
    		 */
    		
    		
    		addSequential(new GoDistance(168, .8));
    		addSequential(new RaiseLift(30));
    		addSequential(new TurnAngle(-90));
    		addSequential(new Expel());
    		
    	
    	
    	
    	
    	
    }
}
