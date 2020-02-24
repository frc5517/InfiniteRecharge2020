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

public class Indexer extends SubsystemBase {
  WPI_TalonSRX indexerTop = new WPI_TalonSRX(Constants.INDEXER_L_PORT);
  WPI_TalonSRX indexerBottom = new WPI_TalonSRX(Constants.INDEXER_R_PORT);

  /**
   * Creates a new Indexer.
   */
  public Indexer() {
  }

  public void indexerTopIn(double power) {
    indexerTop.set(ControlMode.PercentOutput, power);
  }

  public void indexerTopOut(double power) {
    indexerTop.set(ControlMode.PercentOutput, -power);
  }

  public void indexerBottomIn(double power) {
    indexerBottom.set(ControlMode.PercentOutput, power);
  }

  public void indexerBottomOut(double power) {
    indexerBottom.set(ControlMode.PercentOutput, -power);
  }

  public void indexerStop() {
    indexerTop.stopMotor();
    indexerBottom.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
