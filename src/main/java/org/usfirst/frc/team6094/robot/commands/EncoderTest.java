package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;
import org.usfirst.frc.team6094.robot.Thread.ThreadForLoopA;
import org.usfirst.frc.team6094.robot.Thread.ThreadForLoopB;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderTest extends Command {
	// Here is where you should write your variables
	// booleans will return as true or false
	boolean encoderResetRight;
	boolean encoderResetLeft;
	ThreadForLoopA threadA = new ThreadForLoopA();
	ThreadForLoopB threadB = new ThreadForLoopB();

	public EncoderTest() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		encoderResetRight = false;
		encoderResetLeft = false;
		threadB.start();
		threadA.start();

	}

	protected void execute() {
		if (encoderResetRight == false) {
			Robot.encoderRight.reset();
			encoderResetRight = true;
		}

		if (encoderResetLeft == false) {
			Robot.encoderLeft.reset();
			encoderResetLeft = true;
		}
		// 2048 counts per rotation
		// Circumference of Wheel: .152pi m
		// 1 meter = 4296... encoderRight.get(); = 4296
		Robot.encoderRight.setDistancePerPulse(1);
		Robot.encoderLeft.setDistancePerPulse(1);

		// https://stackoverflow.com/questions/8360099/how-to-run-two-for-loops-at-the-same-time

		// the threads allow us to run 2 different if/else statements in parallel
		threadA.run();
		threadB.run();

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.driveTrainStop();
		encoderResetRight = false;
		threadA.interrupt();
		threadB.interrupt();
	}

	protected void interrupted() {
		end();
	}
}