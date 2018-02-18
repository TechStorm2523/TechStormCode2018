package org.usfirst.frc.team2523.robot.subsystems;

import java.awt.geom.Path2D;

import org.usfirst.frc.team2523.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */

   
    	public class FeederSystem extends Subsystem {
    		Spark FeedMotorLeft = new Spark(RobotMap.feedL);
    		Spark FeedMotorRight = new Spark(RobotMap.feedR);
    		
    		
    		public void Tenderness() {
    			
    			FeedMotorLeft.set(.5);
    			FeedMotorRight.set(-.5);
    			
    		}
    		
    		public void FeedInL(){
    			FeedMotorLeft.set(-1);
    			
    			
    			
    		}
    		public void FeedInR(){
    			
    			FeedMotorRight.set(1);
    			
    			
    		}
    		
    		public void FeedIn(){
    			FeedMotorLeft.set(1);
    			FeedMotorRight.set(-1);
    			
    		}
    		public void FeedOut(){
    			FeedMotorLeft.set(-1);
    			FeedMotorRight.set(1);
    		}
    		
    		public void StopFeed() {
    			FeedMotorLeft.set(0);
    			FeedMotorRight.set(0);
    		}
    		public void initDefaultCommand() {
    			// Set the default command for a subsystem here.
    			
    		}
    	}
    
    
    
    
   


