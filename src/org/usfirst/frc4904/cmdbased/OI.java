package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.commands.Kill;
import org.usfirst.frc4904.cmdbased.custom.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// Driver
	public final XboxController xbox;
	// Operator
	public final Joystick stick;
	public final Button button1;
	public final Button button2;
	public final Button button3;
	public final Button button4;
	public final Button button5;
	public final Button button6;
	public final Button button7;
	public final Button button8;
	public final Button button9;
	public final Button button10;
	public final Button button11;
	public final Button button12;
	
	public OI() {
		// Initialize driver Xbox controller and buttons
		xbox = new XboxController(RobotMap.XBOX_CONTROLLER_PORT);
		xbox.rightStick.setXDeadZone(RobotMap.XBOX_MINIMUM_THRESHOLD);
		xbox.leftStick.setYDeadZone(RobotMap.XBOX_MINIMUM_THRESHOLD);
		xbox.rightStick.setXDeadZone(RobotMap.XBOX_MINIMUM_THRESHOLD);
		xbox.leftStick.setYDeadZone(RobotMap.XBOX_MINIMUM_THRESHOLD);
		// Initialize operator joystick and buttons
		stick = new Joystick(RobotMap.JOYSTICK_PORT);
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
		// Bind driver buttons to commands
		xbox.back.whenPressed(new Kill());
		// Operators should extend this class
	}
}
