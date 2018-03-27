package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class toggleInverted extends InstantCommand {

    public toggleInverted() {
        super();
        // Use requires() here to declare subsystem dependencies
        
    }

    // Called once when the command executes
    protected void initialize() {// Inverts controls
    	Robot.m_oi.reversed = !Robot.m_oi.reversed;
    }

}
