package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

   
    	public class FeederSystem extends Subsystem {
    		Spark FeedMotor = new Spark(RobotMap.FeedMotor);
    		
    		
    		
    		public void FeedIn(){
    			FeedMotor.set(1);
    			
    			
    		}
    		public void FeedOut(){
    			FeedMotor.set(-1);
    		}
    		
    		public void StopFeed() {
    			FeedMotor.set(0);
    		}
    		public void initDefaultCommand() {
    			// Set the default command for a subsystem here.
    			
    		}
    	}
    
    
    
    
   


