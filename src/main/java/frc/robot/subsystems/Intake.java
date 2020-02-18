/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

<<<<<<< HEAD
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  WPI_TalonSRX intake = new WPI_TalonSRX(Constants.INTAKE_PORT);
=======
import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

>>>>>>> 545e13aa2a884c5e8f77bbfdd4cc17d0f13d9c70
  /**
   * Creates a new Intake.
   */
  public Intake() {

  }

<<<<<<< HEAD
  public void intakeIn(double power) {
    intake.set(ControlMode.PercentOutput, power);
  }

  public void intakeOut(double power) {
    intake.set(ControlMode.PercentOutput, -power);
  }

  public void intakeStop() {
    intake.stopMotor();
  }

=======
>>>>>>> 545e13aa2a884c5e8f77bbfdd4cc17d0f13d9c70
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
