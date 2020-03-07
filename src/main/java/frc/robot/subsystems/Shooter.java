/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  WPI_TalonSRX shooterLeft = new WPI_TalonSRX(Constants.SHOOTER_L_PORT);
  WPI_TalonSRX shooterRight = new WPI_TalonSRX(Constants.SHOOTER_R_PORT);

  /**
   * Creates a new Shooter.
   */
  public Shooter() {
  }

  public void shooterIn(double power) {
    shooterLeft.set(ControlMode.PercentOutput, -power);
    shooterRight.set(ControlMode.PercentOutput, power);
  }

  public void shooterOut(double power) {
    shooterLeft.set(ControlMode.PercentOutput, power);
    shooterRight.set(ControlMode.PercentOutput, -power);
  }

  public void shooterStop() {
    shooterLeft.stopMotor();
    shooterRight.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
