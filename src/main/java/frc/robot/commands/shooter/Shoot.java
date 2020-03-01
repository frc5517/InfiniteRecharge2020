/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.indexer.IndexerTopOut;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Shoot extends SequentialCommandGroup {

  Shooter shooter; 
  Indexer indexer;

  /**
   * Creates a new Shoot.
   */
  public Shoot(Shooter shooter, DoubleSupplier shooterPower, Indexer indexer, DoubleSupplier indexerPower) {
    super(
      new ShooterOut(shooter, shooterPower), 
      new WaitCommand(1),
      new IndexerTopOut(indexer, indexerPower)
    );
    this.shooter = shooter;
    this.indexer = indexer;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.shooterStop();
    indexer.indexerStop();
  }
}
