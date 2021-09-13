package org.usfirst.frc.team6094.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team6094.robot.commands.Teleop;

public class DriveTrain extends Subsystem {

	VictorSP frontLeft = new VictorSP(0);

	VictorSP frontRight = new VictorSP(1);

	DifferentialDrive driveTrainTest = new DifferentialDrive(frontLeft, frontRight);

	public void initDefaultCommand() {
		setDefaultCommand(new Teleop());
	}

	public void init() {
	}

	public void testDrive(Joystick Joy) {
		driveTrainTest.arcadeDrive(-Joy.getY(), Joy.getX());
	}

	public void rightMotor(Double Speed) {
		frontRight.set(Speed);
	}

	public void leftMotor(Double Speed) {
		frontLeft.set(Speed);
	}

	public void driveTraingForward() {
		frontLeft.set(-.3);
		frontRight.set(-.3);
	}

	public void driveTrainBack() {
		frontLeft.set(.3);
		frontRight.set(.3);
	}

	public void driveTrainStop() {
		frontLeft.set(0);
		frontRight.set(0);
	}

	public void driveTrainLeft() {
		frontLeft.set(-.3);
		frontRight.set(.3);
	}

	public void driveTrainRight() {
		frontLeft.set(.3);
		frontRight.set(-.3);
	}
}