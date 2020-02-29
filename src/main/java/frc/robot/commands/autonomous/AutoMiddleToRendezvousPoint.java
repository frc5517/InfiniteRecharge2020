/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drive.CurvatureDrive;
import frc.robot.commands.shooter.ShooterOut;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoMiddleToRendezvousPoint extends SequentialCommandGroup {
  /**
   * Creates a new AutoMiddleToRendezvousPoint.
   */
  public AutoMiddleToRendezvousPoint(Drivetrain drivetrain, Shooter shooter, Indexer indexer) {
    super(
      new ShooterOut(shooter, indexer, () -> 0.75, () -> 0.40).withTimeout(3),
      new CurvatureDrive(drivetrain, () -> 0.5, () -> 0.0).withTimeout(3)
    );
  }
}
