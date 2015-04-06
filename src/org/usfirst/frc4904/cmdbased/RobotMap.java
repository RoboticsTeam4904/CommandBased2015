package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.custom.IMU;
import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.custom.SuperEncoder;
import org.usfirst.frc4904.cmdbased.subsystems.Camera;
import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;
import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import org.usfirst.frc4904.cmdbased.subsystems.LimitSwitchSystem;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import com.ni.vision.NIVision;
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
	public static OI oi = new OI();;
	// *** CONSTANTS *** //
	// Size constants
	public static final double TOTE_GRAB_HEIGHT = 1; // TODO add actual value
	public static final double CAN_GRAB_HEIGHT = 1; // TODO add actual value
	// OI constants
	public static final double X_SPEED_SCALE = -0.66; // negative because axis is flipped
	public static final double Y_SPEED_SCALE = 0.66;
	public static final double TURN_SPEED_SCALE = 0.5;
	public static final double XBOX_MINIMUM_THRESHOLD = 0.1;
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
	// Camera constants
	public static final NIVision.Range CAMERA_TOTE_HUE_RANGE = new NIVision.Range(101, 64); // Default hue range for yellow tote
	public static final NIVision.Range CAMERA_TOTE_SAT_RANGE = new NIVision.Range(88, 255); // Default saturation range for yellow tote
	public static final NIVision.Range CAMERA_TOTE_VAL_RANGE = new NIVision.Range(134, 255); // Default value range for yellow tote
	public static final double CAMERA_AREA_MINIMUM = 0.5;
	public static final double CAMERA_LONG_RATIO = 2.22; // Tote long side = 26.9 / Tote height = 12.1 = 2.22
	public static final double CAMERA_SHORT_RATIO = 1.4; // Tote short side = 16.9 / Tote height = 12.1 = 1.4
	public static final double CAMERA_SCORE_MIN = 75.0; // Minimum score to be considered a tote
	public static final String CAMERA_NAME = "cam1";
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
	// *** SUBSYSTEMS *** //
	// Initialize wheels and chassis
	public static final EncodedMotor frontLeftWheel = new EncodedMotor("frontLeftWheel", 1.0, 0.3, 0.3, RobotMap.FRONT_LEFT_WHEEL_MOTOR, RobotMap.FRONT_LEFT_WHEEL_ENCODER);
	public static final EncodedMotor frontRightWheel = new EncodedMotor("frontRightWheel", 1.0, 0.3, 0.3, RobotMap.FRONT_RIGHT_WHEEL_MOTOR, RobotMap.FRONT_RIGHT_WHEEL_ENCODER);
	public static final EncodedMotor backLeftWheel = new EncodedMotor("backLeftWheel", 1.0, 0.3, 0.3, RobotMap.BACK_LEFT_WHEEL_MOTOR, RobotMap.BACK_LEFT_WHEEL_ENCODER);
	public static final EncodedMotor backRightWheel = new EncodedMotor("backRightWheel", 1.0, 0.3, 0.3, RobotMap.BACK_RIGHT_WHEEL_MOTOR, RobotMap.BACK_RIGHT_WHEEL_ENCODER);
	public static final Chassis chassis = new Chassis(frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
	// Initialize winch
	public static final Winch winch = new Winch(RobotMap.WINCH_MOTOR, RobotMap.WINCH_ENCODER);
	// Initialize grabber and its limit switches
	public static final LimitSwitchSystem limitSwitches = new LimitSwitchSystem(RobotMap.RIGHT_INNER_SWITCH, RobotMap.LEFT_INNER_SWITCH, RobotMap.RIGHT_OUTER_SWITCH, RobotMap.LEFT_OUTER_SWITCH);
	public static final Grabber grabber = new Grabber(RobotMap.GRABBER_MOTOR, limitSwitches);
	// Initialize LIDAR
	public static final LIDAR lidar = new LIDAR();
	// Initialize camera
	public static final Camera camera = new Camera();
}
