/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

  WPI_VictorSPX climbMotor = new WPI_VictorSPX(Constants.CLIMBER_PORT);
  //CANSparkMax climbMotor = new CANSparkMax(Constants.CLIMBER_PORT, MotorType.kBrushless);
  /**
   * Creates a new Climber.
   */
  public Climber() {

  }

  public void climbUp(double power) {
    climbMotor.set(ControlMode.PercentOutput, power);
  }

  public void climbDown(double power) {
    climbMotor.set(ControlMode.PercentOutput, -power);
  }

  public void climbStop() {
    climbMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
