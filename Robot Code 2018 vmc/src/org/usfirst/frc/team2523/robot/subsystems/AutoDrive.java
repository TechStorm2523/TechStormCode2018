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
	WPI_TalonSRX leftFront = new WPI_TalonSRX(RobotMap.leftMotorFront);
	WPI_TalonSRX leftBack = new WPI_TalonSRX(RobotMap.leftMotorRear);
	WPI_TalonSRX rightFront = new WPI_TalonSRX(RobotMap.rightMotorFront);
	WPI_TalonSRX rightBack = new WPI_TalonSRX(RobotMap.rightMotorRear);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void autoSetup() {
		
//		leftFront.follow(leftBack);
//		rightFront.follow(rightBack);
		
		leftBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		rightBack.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		
		leftBack.setSelectedSensorPosition(0, 0, 10);
		rightBack.setSelectedSensorPosition(0, 0, 10);
		
	}
	
	public void setTrain(double value) {
		
		leftBack.set(value);
		rightBack.set(value);
		
		
	}
	
	public void setLeft(double value) {
		
		leftBack.set(-value);
		leftFront.set(-value);
		
	}
	public void setRight(double value) {
		
		rightBack.set(value);
		rightFront.set(value);
		
	}
	
	public double getLeft() {
		
		return -leftBack.getSelectedSensorPosition(0);
		
	}
	
	public double getRight() {
		
		return rightBack.getSelectedSensorPosition(0);
		
		
		
	}
	
	double tickDist;
	public void goDistSetup(double distInch, double power) {
		driveBusy = true;
		tickDist = distInch*(217.4);
		leftBack.setSelectedSensorPosition(0, 0, 10);
		rightBack.setSelectedSensorPosition(0, 0, 10);
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
		turnDist = degrees*55;
		leftBack.setSelectedSensorPosition(0, 0, 10);
		rightBack.setSelectedSensorPosition(0, 0, 10);
		setLeft(power);
		setRight(-power);
	}
	public char getSwitchSide() {
		String gameData;
		
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData == null || gameData.length()==0) {
			
		}
		
		return gameData.charAt(0);
	}
	
	public boolean turnAngle() {
	
		System.out.println(turnDist);
		
		if(getLeft()>turnDist) {
			
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

