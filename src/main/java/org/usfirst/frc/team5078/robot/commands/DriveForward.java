/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5078.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5078.robot.Robot;

/**
 * This command drives the robot over a given distance with simple proportional
 * control This command will drive a given distance limiting to a maximum speed.
 */
public class DriveForward extends Command {
	private double m_driveForwardSpeed;
	private double m_distance;
	//private double adjusted_distance;
	private double m_error;
	private final double TOLERANCE = 5;
	private final double kP =1;
	private double stepsperrotation=4096;

	public DriveForward() {
		this(10, 0.5);
	}

	public DriveForward(double dist) {
		this(dist, 0.75);
		requires(Robot.drivetrain);
	}

	public DriveForward(double dist, double maxSpeed) {
		requires(Robot.drivetrain);
		m_distance = dist;
		m_driveForwardSpeed = maxSpeed;
	}

	@Override
	protected void initialize() {
		Robot.drivetrain.reset();	
		setTimeout(8);
	}

	@Override
	protected void execute() {
		m_error = m_distance - Robot.drivetrain.position()/stepsperrotation;
		if (m_driveForwardSpeed * kP * m_error >= m_driveForwardSpeed) {
			Robot.drivetrain.tankDrive(m_driveForwardSpeed, m_driveForwardSpeed);
		} else {
			Robot.drivetrain.tankDrive(m_driveForwardSpeed * kP * m_error,
					m_driveForwardSpeed * kP * m_error);
		}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(m_error) <= TOLERANCE || isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drivetrain.stop();
	}
}
