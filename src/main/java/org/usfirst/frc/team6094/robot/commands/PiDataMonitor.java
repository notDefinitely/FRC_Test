package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PiDataMonitor extends Command {
	boolean autonRunning;
	boolean resetYaw;
	boolean displacementZeroed;

	public PiDataMonitor() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		resetYaw = false;
		displacementZeroed = false;
	}

	protected void execute() {
		/*
		// This fixs the problems with double prints,
		// not properly closing auton programs
		// and make sure we dont move while reseting yaw
		autonRunning = true;

		if (resetYaw == false) {
			Robot.ahrs.zeroYaw();
			resetYaw = true;
		}

		if (autonRunning == true && Robot.ahrs.isCalibrating() == false) {
			boolean motionDetected = Robot.ahrs.isRotating();
			System.out.println(motionDetected);
			System.out.printf("Angle, " + Robot.ahrs.getYaw());		
				if (Robot.ahrs.getYaw() < 88) {
					Robot.drivetrain.driveTrainLeft();
				} else if (Robot.ahrs.getYaw() > 92 || Robot.ahrs.getYaw() < -5) {
					Robot.drivetrain.driveTrainRight();
				} else {
					Robot.drivetrain.driveTrainStop();
				}
			}
			*/
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		autonRunning = false;
		resetYaw = false;
		Robot.drivetrain.driveTrainStop();
	}

	protected void interrupted() {
		end();
	}
	
}