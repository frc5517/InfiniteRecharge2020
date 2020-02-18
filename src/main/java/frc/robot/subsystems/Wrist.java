/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wrist extends SubsystemBase {
  CANSparkMax wristMotor = new CANSparkMax(Constants.WRIST_PORT, MotorType.kBrushless);

  /**
   * Creates a new Wrist.
   */
  public Wrist() {

  }

  public void wristUp(double power) {
    wristMotor.set(power);
  }

  public void wristDown(double power) {
    wristMotor.set(-power);
  }

  public void wristStop() {
    wristMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
