package org.usfirst.frc4904.robot;


import org.usfirst.frc4904.cmdbased.custom.controllers.CustomXbox;
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
	public static CustomXbox xbox;
	// *** OPERATOR *** //
	// Initialize operator joystick
	public static Joystick stick;
	// Initialize operator buttons
	public static Button button1;
	public static Button button2;
	public static Button button3;
	public static Button button4;
	public static Button button5;
	public static Button button6;
	public static Button button7;
	public static Button button8;
	public static Button button9;
	public static Button button10;
	public static Button button11;
	public static Button button12;
	
	public DriverStationMap() {
		xbox = new CustomXbox(XBOX_CONTROLLER_PORT);
		stick = new Joystick(JOYSTICK_PORT);
		button1 = new JoystickButton(stick, 1);
		button2 = new JoystickButton(stick, 2);
		button3 = new JoystickButton(stick, 3);
		button4 = new JoystickButton(stick, 4);
		button5 = new JoystickButton(stick, 5);
		button6 = new JoystickButton(stick, 6);
		button7 = new JoystickButton(stick, 7);
		button8 = new JoystickButton(stick, 8);
		button9 = new JoystickButton(stick, 9);
		button10 = new JoystickButton(stick, 10);
		button11 = new JoystickButton(stick, 11);
		button12 = new JoystickButton(stick, 12);
		// Initialize driver Xbox controller and buttons
		DriverStationMap.xbox.rightStick.setXDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
		DriverStationMap.xbox.rightStick.setYDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
		DriverStationMap.xbox.leftStick.setXDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
		DriverStationMap.xbox.leftStick.setYDeadZone(DriverStationMap.XBOX_MINIMUM_THRESHOLD);
	}
}