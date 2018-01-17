package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */


public class LiftSystem extends Subsystem {
	Spark liftMotor = new Spark(RobotMap.liftMotor);
	
	
	
	public void ReverseLift(){
		liftMotor.set(-1);
		
		
	}
	public void StopLift(){
		liftMotor.set(0);
	}
	
	public void LiftUp() {
		liftMotor.set(1);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		
	}
}