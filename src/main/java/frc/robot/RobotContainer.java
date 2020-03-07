/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.drive.CurvatureDrive;
import frc.robot.commands.indexer.IndexerBottomIn;
import frc.robot.commands.indexer.IndexerBottomOut;
import frc.robot.commands.indexer.IndexerTopIn;
import frc.robot.commands.indexer.IndexerTopOut;
import frc.robot.commands.intake.IntakeIn;
import frc.robot.commands.intake.IntakeOut;
import frc.robot.commands.shooter.Shoot;
import frc.robot.commands.shooter.ShooterIn;
import frc.robot.commands.autonomous.AutoMiddleToRendezvousPoint;
//import frc.robot.commands.shooter.ShooterOut;
import frc.robot.commands.climber.ClimbDown;
import frc.robot.commands.climber.ClimbUp;
import frc.robot.commands.wrist.WristDown;
import frc.robot.commands.wrist.WristUp;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Wrist;
import frc.robot.utilities.Gamepad;
import frc.robot.utilities.LogitechJoystick;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Indexer indexer = new Indexer();
  private final Wrist wrist = new Wrist();
  private final Shooter shooter = new Shooter();
  private final Climber climber = new Climber();

  LogitechJoystick driverJoystickLeft = new LogitechJoystick(Constants.DRIVER_JOYSTICK_L_PORT);
  LogitechJoystick driverJoystickRight = new LogitechJoystick(Constants.DRIVER_JOYSTICK_R_PORT);
  Gamepad operatorGamepad = new Gamepad(Constants.OPERATOR_CONTROLLER_PORT);

  private final Command autoCommand = new AutoMiddleToRendezvousPoint(drivetrain, shooter, indexer);

  SendableChooser<Command> autoChooser = new SendableChooser<>();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();

    // add auto commands to Shuffleboard
    autoChooser.addOption("Shoot to Rendezvous Point", autoCommand);
    Shuffleboard.getTab("SmartDashboard").add(autoChooser);

    drivetrain.setDefaultCommand(
      new CurvatureDrive(
        drivetrain, 
        () -> getLeftDriverJoystickY(),   
        () -> getRightDriverJoystickX()
      )
    );
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Driver Controls 
    driverJoystickRight.getJoystickTrigger().whileHeld(new IntakeOut(intake, indexer, () -> 0.50, () -> 0.50));
    driverJoystickLeft.getJoystickTrigger().whileHeld(new IntakeIn(intake, indexer, () -> 0.50, () -> 0.50));
    driverJoystickRight.getJoystickButton(8).whileHeld(new ClimbDown(climber, () -> 0.75));
    //Operator Controls
    operatorGamepad.getStartButton().whileHeld(new ClimbUp(climber, () -> 0.75));
    operatorGamepad.getButtonB().whileHeld(new IndexerBottomIn(indexer, () -> 0.75));
    operatorGamepad.getButtonA().whileHeld(new IndexerBottomOut(indexer, () -> 0.50));
    operatorGamepad.getLeftShoulder().whileHeld(new ShooterIn(shooter, () -> 0.35));
    operatorGamepad.getRightShoulder().whileHeld(new Shoot(shooter, () -> 0.85, indexer, () -> 0.45));
    operatorGamepad.getButtonX().whileHeld(new WristDown(wrist, () -> 0.30));
    operatorGamepad.getButtonY().whileHeld(new WristUp(wrist, () -> 0.30));
  }

  private double getLeftDriverJoystickY() {
    double y = driverJoystickLeft.getY();
    return y;
  }

  private double getRightDriverJoystickX() {
    double x = driverJoystickRight.getX();
    return x;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoCommand;
  }
}
