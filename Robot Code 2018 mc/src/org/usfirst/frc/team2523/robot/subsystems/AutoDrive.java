package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoDrive extends Subsystem {
	
	public boolean driveBusy = false;
	WPI_TalonSRX leftBack = new WPI_TalonSRX(RobotMap.leftMotorFront);
	WPI_TalonSRX leftFront = new WPI_TalonSRX(RobotMap.leftMotorRear);
	WPI_TalonSRX rightBack = new WPI_TalonSRX(RobotMap.rightMotorFront);
	WPI_TalonSRX rightFront = new WPI_TalonSRX(RobotMap.rightMotorRear);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void autoSetup() {
		
//		leftBack.follow(leftFront);
//		rightBack.follow(rightFront);
		
		leftFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		rightFront.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		
		leftFront.setSelectedSensorPosition(0, 0, 10);
		rightFront.setSelectedSensorPosition(0, 0, 10);
		
	}
	
	public void setTrain(double value) {
		
		leftFront.set(value);
		rightFront.set(value);
		
		
	}
	
	public void setLeft(double value) {
		
		leftFront.set(-value);
		leftBack.set(-value);
		
	}
	public void setRight(double value) {
		
		rightFront.set(value);
		rightBack.set(value);
		
	}
	
	public double getLeft() {
		
		return -leftFront.getSelectedSensorPosition(0);
		
	}
	
	public double getRight() {
		
		return rightFront.getSelectedSensorPosition(0);
		
		
		
	}
	
	double tickDist;
	public void goDistSetup(double distInch, double power) {
		System.out.println("Go");
		tickDist = distInch*(117);
		leftFront.setSelectedSensorPosition(0, 0, 10);
		rightFront.setSelectedSensorPosition(0, 0, 10);
		setLeft(power);
		setRight(power);
	}
	
	public boolean goDist() {
		
		if(getRight()>tickDist) {
			driveBusy = false;
			return true;
		}
		
		
		return false;
		
		
		
		
		
		
		
	}
	double turnDist;
	public void turnAngleSetup(double degrees, double power){
		System.out.println("Turn");
		turnDist = degrees*42.66;
		leftFront.setSelectedSensorPosition(0, 0, 10);
		rightFront.setSelectedSensorPosition(0, 0, 10);
		setLeft(-power);
		setRight(power);
	}
	public char getSwitchSide() {
		String gameData;
		
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData == null || gameData.length()==0) {
			
		}
		
		return gameData.charAt(0);
	}
	
	public boolean turnAngle() {
	
		
		
		if(getLeft()<turnDist) {
			
			return true;
		}
		return false;
		
		
		
		
	}
	
	public void Stop() {
		setLeft(0);
		setRight(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

