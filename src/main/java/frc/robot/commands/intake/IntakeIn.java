/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

public class IntakeIn extends CommandBase {
  private final Intake intake;
  private final Indexer indexer;
  private final DoubleSupplier intakePower, indexerPower;


  /**
   * Creates a new IntakeIn.
   */
  public IntakeIn(Intake intake, Indexer indexer, DoubleSupplier intakePower, DoubleSupplier indexerPower) {
    this.intake = intake;
    this.indexer = indexer;
    this.intakePower = intakePower;
    this.indexerPower = indexerPower;
    addRequirements(intake, indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.intakeIn(intakePower.getAsDouble());
    // indexer.indexerBottomIn(indexerPower.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.intakeStop();
    //indexer.indexerStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
