package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.custom.sensors.IMU;
import org.usfirst.frc4904.cmdbased.custom.sensors.LIDAR;
import org.usfirst.frc4904.cmdbased.custom.sensors.PDP;
import org.usfirst.frc4904.cmdbased.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.subsystems.Chassis2015;
import org.usfirst.frc4904.robot.subsystems.Grabber;
import org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem;
import org.usfirst.frc4904.robot.subsystems.Winch;
import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// *** CONSTANTS *** //
	// Size constants
	public static final double TOTE_GRAB_HEIGHT = 1; // 1 half-tote (lowest grabber can go)
	public static final double CAN_GRAB_HEIGHT = 1; // TODO add actual value
	// Winch constants
	public static final double WINCH_MIN_HEIGHT = 0;
	public static final double WINCH_MAX_HEIGHT = 9; // each level is half a tote height
	public static final double WINCH_ERROR_MARGIN = 0.5; // in half-totes
	public static final double WINCH_P = -1;
	public static final double WINCH_I = -0.3;
	public static final double WINCH_D = -0.3;
	public static final double WINCH_MAX_TICKS = 355.00;
	public static final double TICK_PER_HALFTOTE = WINCH_MAX_TICKS / WINCH_MAX_HEIGHT;
	// Grabber constants
	public static final double GRABBER_OPEN_SPEED = 0.5;
	public static final double GRABBER_CLOSE_SPEED = -0.25;
	public static final double GRABBER_HOLD_SPEED = -0.1;
	public static final double GRABBER_IDLE_SPEED = 0;
	public static final int GRABBER_PDP_PORT = 1; // TODO: check that this is true
	public static final double GRABBER_MAX_AMPS = 8;
	public static final double GRABBER_EMERGENCY_AMPS = 25;
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
	// VictorSP-controlled motors
	public static VictorSP FRONT_LEFT_WHEEL_MOTOR;
	public static VictorSP FRONT_RIGHT_WHEEL_MOTOR;
	public static VictorSP BACK_LEFT_WHEEL_MOTOR;
	public static VictorSP BACK_RIGHT_WHEEL_MOTOR;
	// Talon-controlled motors
	public static Talon WINCH_MOTOR;
	public static Talon GRABBER_MOTOR;
	// Limit switches
	public static DigitalInput RIGHT_INNER_SWITCH;
	public static DigitalInput LEFT_INNER_SWITCH;
	public static DigitalInput RIGHT_OUTER_SWITCH;
	public static DigitalInput LEFT_OUTER_SWITCH;
	// Encoders
	public static Encoder FRONT_LEFT_WHEEL_ENCODER;
	public static Encoder FRONT_RIGHT_WHEEL_ENCODER;
	public static Encoder BACK_LEFT_WHEEL_ENCODER;
	public static Encoder BACK_RIGHT_WHEEL_ENCODER;
	public static Encoder WINCH_ENCODER;
	// IMU
	public static IMU IMU_SENSOR;
	// *** SUBSYSTEMS *** //
	// Initialize wheels and chassis
	// public static final EncodedMotor frontLeftWheel = new EncodedMotor("frontLeftWheel", 1.0, 0.3, 0.3, RobotMap.FRONT_LEFT_WHEEL_MOTOR, RobotMap.FRONT_LEFT_WHEEL_ENCODER);
	// public static final EncodedMotor frontRightWheel = new EncodedMotor("frontRightWheel", 1.0, 0.3, 0.3, RobotMap.FRONT_RIGHT_WHEEL_MOTOR, RobotMap.FRONT_RIGHT_WHEEL_ENCODER);
	// public static final EncodedMotor backLeftWheel = new EncodedMotor("backLeftWheel", 1.0, 0.3, 0.3, RobotMap.BACK_LEFT_WHEEL_MOTOR, RobotMap.BACK_LEFT_WHEEL_ENCODER);
	// public static final EncodedMotor backRightWheel = new EncodedMotor("backRightWheel", 1.0, 0.3, 0.3, RobotMap.BACK_RIGHT_WHEEL_MOTOR, RobotMap.BACK_RIGHT_WHEEL_ENCODER);
	public static Motor frontLeftWheel;
	public static Motor frontRightWheel;
	public static Motor backLeftWheel;
	public static Motor backRightWheel;
	public static Chassis2015 chassis;
	// Initialize winch
	public static Winch winch;
	// Initialize grabber and its limit switches
	public static org.usfirst.frc4904.robot.subsystems.LimitSwitchSystem limitSwitches;
	public static Grabber grabber;
	// Initialize LIDAR
	public static LIDAR lidar;
	// Initializer PDP
	public static PDP pdp;
	
	public RobotMap() {
		FRONT_LEFT_WHEEL_MOTOR = new VictorSP(0);
		FRONT_RIGHT_WHEEL_MOTOR = new VictorSP(1);
		BACK_LEFT_WHEEL_MOTOR = new VictorSP(2);
		BACK_RIGHT_WHEEL_MOTOR = new VictorSP(3);
		WINCH_MOTOR = new Talon(4);
		GRABBER_MOTOR = new Talon(5);
		RIGHT_INNER_SWITCH = new DigitalInput(6);
		LEFT_INNER_SWITCH = new DigitalInput(7);
		RIGHT_OUTER_SWITCH = new DigitalInput(8);
		LEFT_OUTER_SWITCH = new DigitalInput(9);
		FRONT_LEFT_WHEEL_ENCODER = new Encoder(1, 10);
		FRONT_RIGHT_WHEEL_ENCODER = new Encoder(2, 11);
		BACK_LEFT_WHEEL_ENCODER = new Encoder(3, 12);
		BACK_RIGHT_WHEEL_ENCODER = new Encoder(4, 13);
		WINCH_ENCODER = new Encoder(0, 5);
		IMU_SENSOR = new IMU();
		frontLeftWheel = new Motor("frontLeftWheel", RobotMap.FRONT_LEFT_WHEEL_MOTOR);
		frontRightWheel = new Motor("frontRightWheel", RobotMap.FRONT_RIGHT_WHEEL_MOTOR);
		backLeftWheel = new Motor("backLeftWheel", RobotMap.BACK_LEFT_WHEEL_MOTOR);
		backRightWheel = new Motor("backRightWheel", RobotMap.BACK_RIGHT_WHEEL_MOTOR);
		chassis = new Chassis2015(frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
		winch = new Winch(RobotMap.WINCH_MOTOR, RobotMap.WINCH_ENCODER);
		limitSwitches = new LimitSwitchSystem(RobotMap.RIGHT_INNER_SWITCH, RobotMap.LEFT_INNER_SWITCH, RobotMap.RIGHT_OUTER_SWITCH, RobotMap.LEFT_OUTER_SWITCH);
		grabber = new Grabber(RobotMap.GRABBER_MOTOR, limitSwitches);
		lidar = new LIDAR();
		pdp = new PDP();
	}
}
