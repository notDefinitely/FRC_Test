package org.usfirst.frc.team6094.robot.Thread;

import org.usfirst.frc.team6094.robot.Robot;

public class ThreadForLoopB extends Thread {
   // variables for your Thread ...
   Double Speed;

   @Override
   public void run() {
      Speed = .3;
      if (Robot.encoderRight.get() < 4289) {
         Robot.drivetrain.rightMotor(-Speed);
      } else if (Robot.encoderRight.get() > 4400) {
         Robot.drivetrain.rightMotor(Speed);
      } else {
         Robot.drivetrain.rightMotor(0.0);
      }
   }
}