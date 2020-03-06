/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drive.CurvatureDrive;
import frc.robot.commands.shooter.Shoot;
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
      new Shoot(shooter, () -> 0.75, indexer, () -> 0.5).withTimeout(5),
      new CurvatureDrive(drivetrain, () -> -0.5, () -> 0.0).withTimeout(1.5)
    );
  }
}
