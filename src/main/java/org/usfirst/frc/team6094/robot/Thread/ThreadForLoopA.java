package org.usfirst.frc.team6094.robot.Thread;

import org.usfirst.frc.team6094.robot.Robot;

public class ThreadForLoopA extends Thread {
   // variables for your Thread ...
   Double Speed;

   @Override
   public void run() {
      Speed = .3;

      // Robot drives forward 1 meter and corrects itself
      if (Robot.encoderLeft.get() < 4289) {
         Robot.drivetrain.leftMotor(-Speed);
      } else if (Robot.encoderLeft.get() > 4400) {
         Robot.drivetrain.leftMotor(Speed);
      } else {
         Robot.drivetrain.leftMotor(0.0);
      }
   }

}
