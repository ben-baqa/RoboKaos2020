
package org.usfirst.frc.team5078.robot;

//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5078.robot.commands.Autonomous;
import org.usfirst.frc.team5078.robot.subsystems.AirPump;
import org.usfirst.frc.team5078.robot.subsystems.Lift;
import org.usfirst.frc.team5078.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5078.robot.subsystems.ElevatorWinch;
import org.usfirst.frc.team5078.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team5078.robot.subsystems.IntakeDriveTrain;
//import org.usfirst.frc.team5078.robot.subsystems.PigeonControl;
import org.usfirst.frc.team5078.robot.subsystems.Shifter;
import org.usfirst.frc.team5078.robot.subsystems.Hatch;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain drivetrain = new DriveTrain();
	public static AirPump airpump = new AirPump();
	public static Lift lift = new Lift();
	public static Shifter shifter = new Shifter();
	public static ElevatorWinch elevatorwinch = new ElevatorWinch();
	public static IntakeDriveTrain intakedrivetrain = new IntakeDriveTrain();
	public static Hatch hatch = new Hatch();
	//public static PigeonControl pigeoncontrol = new PigeonControl();
	
	public static String Gamedata;
	
	//CameraServer server;
	Command autonomousCommand;
	//SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		///chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);
		//server = CameraServer.getInstance();
        //server.startAutomaticCapture("cam0",0);
       
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		//gameData = DriverStation.getInstance().getGameSpecificMessage();
		Gamedata = DriverStation.getInstance().getGameSpecificMessage();
		autonomousCommand = new Autonomous();
		autonomousCommand.start();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//todo check this
		LiveWindow.updateValues();
	}
}
