package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenterSL extends CommandGroup {

    public AutoCenterSL() {
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
    	
    	
    	
    	
    		addSequential(new RaiseLift(30));
    		
    		addSequential(new GoDistance(10, .5));
    		
    		
    		addSequential(new TurnAngle(45));
    		
    		
    		addSequential(new GoDistance(72, .5));
    		
    	
    		addSequential(new TurnAngle(-45));
    		
    		
    		addSequential(new GoDistance(57, .5));
    		
    		
    		addSequential(new Approach());
    		
    		System.out.println("Approach");
    		addSequential(new Expel());
    		
    		
    	
    }
}
