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
public class DriveTurn extends Command {
	private double turnSpeed;
	private double angle;
	private double m_error;
	private static final double kTolerance = 3;
	private static final double kP = 0.2;

	public DriveTurn() {
		this(10, 0.5);
	}

	public DriveTurn(double angle) {
		this(angle, 0.5);
	}

	public DriveTurn(double ang, double maxSpeed) {
		requires(Robot.drivetrain);
		angle = ang;
		turnSpeed = maxSpeed;
	}

	@Override
	protected void initialize() {
		Robot.drivetrain.resetyaw();
		setTimeout(5);
	}

	@Override
	protected void execute() {
		m_error = angle - Robot.drivetrain.getYaw();
		if (turnSpeed * kP * m_error >= turnSpeed) {
			Robot.drivetrain.tankDrive(turnSpeed, -turnSpeed);
		} else {
			Robot.drivetrain.tankDrive(turnSpeed * kP * m_error,
					-turnSpeed * kP * m_error);
		}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(m_error) <= kTolerance || isTimedOut();
	}

	@Override
	protected void end() {
		Robot.drivetrain.stop();
	}
}
