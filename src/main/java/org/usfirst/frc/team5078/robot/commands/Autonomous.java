package org.usfirst.frc.team5078.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team5078.robot.Robot;


public class Autonomous extends CommandGroup {
	private double turnangle = 90;
    public Autonomous() {
 addSequential(new ShiftLowGear());	
addSequential(new DriveForward(111));
//addSequential(new DriveTurn(turnangle));
//addSequential(new ClawOpen());
// TODO test actual distance this is ten feet
//addSequential(new DriveTurn(turnangle));

//if(Robot.Gamedata.length() > 0)
//{
//if(Robot.Gamedata.charAt(0) == 'L')
// {
//  addParallel(new Elevator(1));
 //addSequential(new DriveForward(120));
 //addSequential(new DriveTurn(turnangle));
//addSequential(new DriveForward(10));


  //} else if(Robot.Gamedata.charAt(1) == 'L'){
  //addParallel(new Elevator(1));
//addSequential(new DriveForward(240));
//addSequential(new DriveTurn(turnangle));
//addSequential(new DriveForward(10));
//}
//else {
  //addSequential(new DriveForward(120));
//}
  // }
//	addSequential(new Elevator(1));
//addSequential(new Intake(-1));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
