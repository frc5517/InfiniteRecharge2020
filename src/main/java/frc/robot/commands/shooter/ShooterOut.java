/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class ShooterOut extends CommandBase {
  private final Shooter shooter;
  private final Indexer indexer;
  private final DoubleSupplier power, indexerPower;


  /**
   * Creates a new ShooterOut.
   */
  public ShooterOut(Shooter shoot, Indexer ind, DoubleSupplier dPower, DoubleSupplier indPower) {
    shooter = shoot;
    indexer = ind;
    power = dPower;
    indexerPower = indPower;
    addRequirements(shooter, indexer);
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shooterOut(power.getAsDouble());
    indexer.indexerTopIn(indexerPower.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.shooterStop();
    indexer.indexerStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
