package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.RobotMap;
import org.usfirst.frc.team2523.robot.commands.runDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class driveTeleop extends Subsystem {
	WPI_TalonSRX leftF = new WPI_TalonSRX(RobotMap.leftMotorFront);
	WPI_TalonSRX rightF = new WPI_TalonSRX(RobotMap.rightMotorFront);
	
	DifferentialDrive d = new DifferentialDrive(leftF,rightF);
	
    public void drive() {
    	d.arcadeDrive(Robot.m_oi.REEEEE.getY()*(1-Robot.m_oi.REEEEE.getThrottle()), Robot.m_oi.REEEEE.getTwist()*(1-Robot.m_oi.REEEEE.getThrottle()));
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	
        setDefaultCommand(new runDrive());
    }
}

