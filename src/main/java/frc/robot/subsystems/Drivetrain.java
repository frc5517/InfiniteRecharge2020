/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  
  Spark driveFrontLeft = new Spark(Constants.DRIVE_FL_PORT);
  Spark driveMiddleLeft = new Spark(Constants.DRIVE_ML_PORT);
  Spark driveRearLeft = new Spark(Constants.DRIVE_RL_PORT);
  Spark driveFrontRight = new Spark(Constants.DRIVE_FR_PORT);
  Spark driveMiddleRight = new Spark(Constants.DRIVE_MR_PORT);
  Spark driveRearRight = new Spark(Constants.DRIVE_RR_PORT);

  SpeedControllerGroup driveLeft = new SpeedControllerGroup(driveFrontLeft, driveMiddleLeft, driveRearLeft);
  SpeedControllerGroup driveRight = new SpeedControllerGroup(driveFrontRight, driveMiddleRight, driveRearRight);

  DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);
  
  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {

  }

  public void curvatureDrive(double throttle, double rotation, Boolean quickTurn) {
    drive.curvatureDrive(throttle, rotation, quickTurn);
  }

  public void tankDrive(double left, double right) {
    drive.tankDrive(left, right);
  }

  public void arcadeDrive(double throttle, double rotation) {
    drive.arcadeDrive(throttle, rotation);
  }

  public void stopDrive() {
    drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
