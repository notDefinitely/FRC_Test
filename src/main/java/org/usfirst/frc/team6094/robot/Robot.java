/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6094.robot;

import org.usfirst.frc.team6094.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6094.robot.commands.Auton;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import com.kauailabs.navx.frc.AHRS;

@SuppressWarnings("unused")
public class Robot extends TimedRobot {
	
	/*
	 *******************************************************************************
	 *
	 * This is the Test Workspace. Combined with code from previous years, this will
	 * be very informative as this is most of the combined knowledge of the past 4
	 * years I've been coding for M.M. (Class of 2021).
	 * 
	 * The comments explain how/why I used certain methods or how they work and the
	 * best practices for multifile coding or just unused things that still have
	 * the potential to be a good learning opportunity.
	 * 
	 *******************************************************************************
	 * -Definitely, Knappkin
	 */

	// public static AHRS ahrs;
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Robot robot;
	public static Encoder encoderRight;
	public static Encoder encoderLeft;

	Command Autonomous;

	@Override
	public void robotInit() {
		drivetrain = new DriveTrain();
		oi = new OI();
		// ahrs = new AHRS(SerialPort.Port.kUSB1);

		// Blue is A channel
		// Yellow is B channel
		encoderLeft = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		encoderRight = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	}

	@Override
	public void autonomousInit() {
		// autonomous choosing code
		String autoPostition = SmartDashboard.getString("DB/String 0", "nothing").toUpperCase();
		String gameData = DriverStation.getInstance().getGameSpecificMessage().toUpperCase();
		System.out.printf("BD/String 5", "You Picked: " + autoPostition);

		// case statements are almost excatly like if/else statements
		switch (autoPostition) {
			// this empty case is for if no position is chosen
			case " ":
				break;
			// This case "M" was chosen to represt a middle position
			case "M":
				// this gets the first charactor of the game data
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'L') {
						// these refer specifically to a Command Group
						// Autonomous = new CenterLeftTurn();
						System.out.println("Center, Left Turn is choosen");
					} else {
						// Autonomous = new CenterRightTurn();
						System.out.println("Center, Right Turn is choosen");
					}
				}
				break;
			case "R":
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'L') {
						// Autonomous = new DriveForward();
					} else {
						// Autonomous = new LeftTurn();
						System.out.println("Right Side, Left Turn is choosen");
					}
				}
				break;
			case "L":
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'L') {
						// Autonomous = new RightTurn();
						System.out.println("Left Side, Right Turn is choosen");
					} else {
						// Autonomous = new DriveForward();
					}
				}
				break;
			case "TEST":
				if (gameData.length() > 0) {
					if (gameData.charAt(0) == 'L') {
						// Autonomous = new TestTurn();
					} else {
						// Autonomous = new TestForward();
					}
				}
				break;
		}

		// do not have this in since it will always choose the cammand group that has
		// its name
		Autonomous = new Auton();
		// starts the chosen autononous command group
		Autonomous.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void teleopInit() {
		if (Autonomous != null) {
			Autonomous.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}