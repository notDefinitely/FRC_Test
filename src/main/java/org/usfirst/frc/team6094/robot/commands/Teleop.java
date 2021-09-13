package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Teleop extends Command {

	public Teleop() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		// System safety check
		Robot.drivetrain.driveTrainStop();
		Robot.drivetrain.init();
	}

	@Override
	protected void execute() {
		Robot.drivetrain.testDrive(Robot.oi.getJoystick());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.drivetrain.driveTrainStop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}