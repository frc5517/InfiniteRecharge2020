/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // drivetrain constants - Spark
    public static final int DRIVE_FL_PORT = 0; //Front Left
    public static final int DRIVE_ML_PORT = 1; //Middle Left
    public static final int DRIVE_RL_PORT = 2; //Rear Left
    public static final int DRIVE_FR_PORT = 3; //Front Right
    public static final int DRIVE_MR_PORT = 4; //Middle Right
    public static final int DRIVE_RR_PORT = 5; //Rear Right

    // intake constants - SRX
    public static final int INTAKE_PORT = 0;

    // conveyor constants - SRX
    public static final int CONVEYOR_L_PORT = 1;
    public static final int CONVEYOR_R_PORT = 2;

    // shooter constants - SRX
    public static final int SHOOTER_L_PORT = 3;
    public static final int SHOOTER_R_PORT = 4;

    // climber constants - Spark MAX
    public static final int CLIMBER_PORT = 0;
    
    // wrist constants - Spark MAX
    public static final int WRIST_PORT = 1;

    // controller constants
    public static final int DRIVER_JOYSTICK_L_PORT = 0;
    public static final int DRIVER_JOYSTICK_R_PORT = 1;
    public static final int OPERATOR_CONTROLLER_PORT = 2;
}
