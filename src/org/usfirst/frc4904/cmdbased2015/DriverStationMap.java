package org.usfirst.frc4904.cmdbased2015;


import org.usfirst.frc4904.cmdbased.custom.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStationMap {
	// *** CONSTANTS *** //
	// Joystick/controller ports
	public static final int JOYSTICK_PORT = 0;
	public static final int XBOX_CONTROLLER_PORT = 1;
	// OI constants
	public static final double X_SPEED_SCALE = -0.66; // negative because axis is flipped
	public static final double Y_SPEED_SCALE = 0.66;
	public static final double TURN_SPEED_SCALE = 0.5;
	public static final double XBOX_MINIMUM_THRESHOLD = 0.1;
	// *** DRIVER *** //
	// Initialize driver Xbox controller
	public static final XboxController xbox = new XboxController(XBOX_CONTROLLER_PORT);;
	// *** OPERATOR *** //
	// Initialize operator joystick
	public static final Joystick stick = new Joystick(JOYSTICK_PORT);;
	// Initialize operator buttons
	public static final Button button1 = new JoystickButton(stick, 1);
	public static final Button button2 = new JoystickButton(stick, 2);
	public static final Button button3 = new JoystickButton(stick, 3);
	public static final Button button4 = new JoystickButton(stick, 4);
	public static final Button button5 = new JoystickButton(stick, 5);
	public static final Button button6 = new JoystickButton(stick, 6);
	public static final Button button7 = new JoystickButton(stick, 7);
	public static final Button button8 = new JoystickButton(stick, 8);
	public static final Button button9 = new JoystickButton(stick, 9);
	public static final Button button10 = new JoystickButton(stick, 10);
	public static final Button button11 = new JoystickButton(stick, 11);
	public static final Button button12 = new JoystickButton(stick, 12);
	static {
		// Initialize driver Xbox controller and buttons
		DriverStationMap.xbox.rightStick.setXDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
		DriverStationMap.xbox.rightStick.setYDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
		DriverStationMap.xbox.leftStick.setXDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
		DriverStationMap.xbox.leftStick.setYDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
	}
}