package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.custom.IMU;
import org.usfirst.frc4904.cmdbased.custom.SuperEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// *** PHYSICAL COMPONENTS *** //
	// Joystick/controller ports (initialized in OI)
	public static final int JOYSTICK_PORT = 0;
	public static final int XBOX_CONTROLLER_PORT = 1;
	// VictorSP-controlled motors
	public static final VictorSP FRONT_LEFT_WHEEL_MOTOR = new VictorSP(0);
	public static final VictorSP FRONT_RIGHT_WHEEL_MOTOR = new VictorSP(1);
	public static final VictorSP BACK_LEFT_WHEEL_MOTOR = new VictorSP(2);
	public static final VictorSP BACK_RIGHT_WHEEL_MOTOR = new VictorSP(3);
	// Talon-controlled motors
	public static final Talon WINCH_MOTOR = new Talon(4);
	public static final Talon GRABBER_MOTOR = new Talon(5);
	// Limit switches
	public static final DigitalInput RIGHT_INNER_SWITCH = new DigitalInput(0);
	public static final DigitalInput LEFT_INNER_SWITCH = new DigitalInput(1);
	public static final DigitalInput RIGHT_OUTER_SWITCH = new DigitalInput(2);
	public static final DigitalInput LEFT_OUTER_SWITCH = new DigitalInput(3);
	// Encoders
	public static final SuperEncoder FRONT_LEFT_WHEEL_ENCODER = new SuperEncoder(10);
	public static final SuperEncoder FRONT_RIGHT_WHEEL_ENCODER = new SuperEncoder(11);
	public static final SuperEncoder BACK_LEFT_WHEEL_ENCODER = new SuperEncoder(12);
	public static final SuperEncoder BACK_RIGHT_WHEEL_ENCODER = new SuperEncoder(13);
	public static final SuperEncoder WINCH_ENCODER = new SuperEncoder(14); // TODO set to correct port
	// IMU
	public static final IMU IMU_SENSOR = new IMU();
	// *** CONSTANTS *** //
	// Size constants
	public static final double TOTE_GRAB_HEIGHT = 1; // TODO add actual value
	public static final double CAN_GRAB_HEIGHT = 1; // TODO add actual value
	// OI constants
	public static final double TURN_SPEED_SCALE = 0.5;
	public static final double XBOX_MINIMUM_THRESHOLD = 0.1;
	// Xbox button mapping constants
	public final static int XBOX_A_BUTTON = 1;
	public final static int XBOX_B_BUTTON = 2;
	public final static int XBOX_X_BUTTON = 3;
	public final static int XBOX_Y_BUTTON = 4;
	public final static int XBOX_LEFT_BUMPER = 5;
	public final static int XBOX_RIGHT_BUMPER = 6;
	public final static int XBOX_BACK_BUTTON = 7;
	public final static int XBOX_START_BUTTON = 8;
	public final static int XBOX_LEFT_STICK = 9;
	public final static int XBOX_RIGHT_STICK = 10;
	public final static int XBOX_X_STICK = 0; // Left x
	public final static int XBOX_Y_STICK = 1; // Left y
	public final static int XBOX_TWIST_STICK = 2; // Button pair on front. Left is twist, trying to determine right
	public static final int XBOX_TWIST_RAW_AXIS = 4; // Stick mappings here: http://www.chiefdelphi.com/forums/showpost.php?p=1003245&postcount=8
	// Winch constants
	public static final double WINCH_MAX_HEIGHT = 12; // each level is half a tote height
	public static final double WINCH_ERROR_MARGIN = 0.5; // in half-totes
	public static final double WINCH_P = 1;
	public static final double WINCH_I = 0.3;
	public static final double WINCH_D = 0.3;
	// Grabber constants
	public static final double GRABBER_OPEN_SPEED = 0.5;
	public static final double GRABBER_CLOSE_SPEED = 0.5;
	public static final double GRABBER_HOLD_SPEED = 0.5;
}
