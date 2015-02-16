package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.OI;
import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.custom.LIDAR;
import org.usfirst.frc4904.cmdbased.subsystems.Camera;
import org.usfirst.frc4904.cmdbased.subsystems.EncodedMotor;
import org.usfirst.frc4904.cmdbased.subsystems.Grabber;
import org.usfirst.frc4904.cmdbased.subsystems.LimitSwitchSystem;
import org.usfirst.frc4904.cmdbased.subsystems.MecanumChassis;
import org.usfirst.frc4904.cmdbased.subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {
	public static OI oi;
	// *** Create a single static instance of all subsystems ***
	// Initialize wheels and chassis
	public static final EncodedMotor frontLeftWheel = new EncodedMotor("frontLeftWheel", 1.0, 0.3, 0.3, RobotMap.FRONT_LEFT_WHEEL_MOTOR, RobotMap.FRONT_LEFT_WHEEL_ENCODER);
	public static final EncodedMotor frontRightWheel = new EncodedMotor("frontRightWheel", 1.0, 0.3, 0.3, RobotMap.FRONT_RIGHT_WHEEL_MOTOR, RobotMap.FRONT_RIGHT_WHEEL_ENCODER);
	public static final EncodedMotor backLeftWheel = new EncodedMotor("backLeftWheel", 1.0, 0.3, 0.3, RobotMap.BACK_LEFT_WHEEL_MOTOR, RobotMap.BACK_LEFT_WHEEL_ENCODER);
	public static final EncodedMotor backRightWheel = new EncodedMotor("backRightWheel", 1.0, 0.3, 0.3, RobotMap.BACK_RIGHT_WHEEL_MOTOR, RobotMap.BACK_RIGHT_WHEEL_ENCODER);
	public static final MecanumChassis chassis = new MecanumChassis(frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
	// Initialize winch
	public static final Winch winch = new Winch(RobotMap.WINCH_MOTOR, RobotMap.WINCH_ENCODER);
	// Initialize grabber and its limit switches
	public static final LimitSwitchSystem limitSwitches = new LimitSwitchSystem(RobotMap.RIGHT_INNER_SWITCH, RobotMap.LEFT_INNER_SWITCH, RobotMap.RIGHT_OUTER_SWITCH, RobotMap.LEFT_OUTER_SWITCH);
	public static final Grabber grabber = new Grabber(RobotMap.GRABBER_MOTOR, limitSwitches);
	// Initialize LIDAR
	public static final LIDAR lidar = new LIDAR();
	// Initialize camera
	public static final Camera camera = new Camera();
	
	public static void init() {
		// This MUST be here. If the OI creates Commands (which it very likely
		// will), constructing it during the construction of CommandBase (from
		// which commands extend), subsystems are not guaranteed to be
		// yet. Thus, their requires() statements may grab null pointers. Bad
		// news. Don't move it.
		oi = new OI();
		// Show what command your subsystem is running on the SmartDashboard
		SmartDashboard.putData(chassis);
		SmartDashboard.putData(winch);
		SmartDashboard.putData(grabber);
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	public CommandBase() {
		super();
	}
}
