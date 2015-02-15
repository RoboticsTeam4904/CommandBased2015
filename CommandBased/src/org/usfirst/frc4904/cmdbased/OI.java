package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.commands.WinchChangeHeight;
import org.usfirst.frc4904.cmdbased.commands.GrabCan;
import org.usfirst.frc4904.cmdbased.commands.GrabTote;
import org.usfirst.frc4904.cmdbased.commands.WinchSetHeight;
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
	
	public OI() {
		// Initialize driver Xbox controller
		xbox = new XboxController(RobotMap.XBOX_CONTROLLER_PORT);
		// Initialize operator joystick and buttons
		stick = new Joystick(RobotMap.JOYSTICK_PORT);
		button1 = new JoystickButton(stick, 1);
		button2 = new JoystickButton(stick, 2);
		button3 = new JoystickButton(stick, 3);
		button4 = new JoystickButton(stick, 4);
		button5 = new JoystickButton(stick, 5);
		button6 = new JoystickButton(stick, 6);
		// Bind operator buttons to commands
		button1.toggleWhenPressed(new GrabTote());
		button2.toggleWhenPressed(new GrabCan());
		button3.whenPressed(new WinchChangeHeight(-2)); // Lower winch two half-totes
		button4.whenPressed(new WinchChangeHeight(2)); // Raise winch two half-totes
		button5.whenPressed(new WinchSetHeight(1)); // Lower winch all the way (1 half-totes)
		button6.whenPressed(new WinchSetHeight(12)); // Raise winch all the way (12 half-totes)
	}
}
