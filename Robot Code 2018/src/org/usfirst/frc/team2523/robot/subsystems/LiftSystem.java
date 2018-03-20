package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;
import org.usfirst.frc.team2523.robot.commands.DefaultLift;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */


public class LiftSystem extends Subsystem {
	public final double MAX_HEIGHT = 127000.0;
	//1821 per inch
	WPI_TalonSRX L = new WPI_TalonSRX(RobotMap.liftMotorL);
	WPI_TalonSRX R = new WPI_TalonSRX(RobotMap.liftMotorR);
	
	public void liftSetup() {
		L.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		R.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		L.setSelectedSensorPosition(0, 0, 10);
		R.setSelectedSensorPosition(0, 0, 10);
		
		
		
	}
	public double getLiftPos() {
		return  R.getSelectedSensorPosition(0);
		
		
	}
	public void setLift(double v) {
		
		L.set(-v);
		R.set(-v);
		
	}
	public void ReverseLift(){
		L.set(1);
		R.set(1);
		
		
	}
	public void StopLift(){
		L.set(0);
		R.set(0);
	}
	
	public void LiftUp() {
		L.set(-1);
		R.set(-1);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DefaultLift());
	}
}