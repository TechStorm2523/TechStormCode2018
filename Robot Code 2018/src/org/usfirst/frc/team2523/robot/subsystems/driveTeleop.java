package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.RobotMap;
import org.usfirst.frc.team2523.robot.commands.runDrive;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class driveTeleop extends Subsystem {
	WPI_TalonSRX leftF = new WPI_TalonSRX(RobotMap.leftMotorFront);
	WPI_TalonSRX rightF = new WPI_TalonSRX(RobotMap.rightMotorFront);
	public WPI_TalonSRX leftR = new WPI_TalonSRX(RobotMap.leftMotorRear);
	public WPI_TalonSRX rightR = new WPI_TalonSRX(RobotMap.rightMotorRear);
	double exY;
	double exT;
	double a = .5;
	double y;
	double t;
	
	
	
	DifferentialDrive d = new DifferentialDrive(leftR,rightR);
	
	public void driveSetup() {// Config motors and reset sensors
		leftF.follow(leftR);
		rightF.follow(rightR);
		leftR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		rightR.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 10);
		leftR.setSelectedSensorPosition(0, 0, 10);
		rightR.setSelectedSensorPosition(0, 0, 10);
		
	}
    public void drive() {
    	y = Robot.m_oi.driveStick.getY();
    	t = Robot.m_oi.driveStick.getTwist();
    	
    	exY = (a*Math.pow(y, 3))+ (1-a)*y;
    	exT = (a*Math.pow(t, 3))+ (1-a)*t;
    	d.arcadeDrive(exY, -exT);
    	
    	SmartDashboard.putNumber("Left Encoder", getLPos());
    	SmartDashboard.putNumber("Right Encoder", getRPos());
    	
    }
    
    public void setL(double value) {
    	leftR.set(value);
    	
    }
    public void setR(double value) {
    	rightR.set(value);
    	
    }
    
    public double getLPos() {
    	return -leftR.getSelectedSensorPosition(0);
    }
    public double getL() {
    	return leftR.getSelectedSensorVelocity(0);
    }
    public double getRPos() {
    	return rightR.getSelectedSensorPosition(0);
    }
    public double getR() {
    	return rightR.getSelectedSensorVelocity(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
        setDefaultCommand(new runDrive());
    }
}

