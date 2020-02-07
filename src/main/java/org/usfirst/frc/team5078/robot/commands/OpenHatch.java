package org.usfirst.frc.team5078.robot.commands;

import org.usfirst.frc.team5078.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenHatch extends Command {
    private static final Timer timer =new Timer() ;
    private double timercount;
    public OpenHatch() {
    	requires(Robot.hatch);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.hatch.open();  
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	timercount=timer.get();
        }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if(timercount<3)
	{
        Robot.hatch.close();
        return true;
        
	}
	else 
		return false;
  
    }

    // Called once after isFinished returns true


    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
