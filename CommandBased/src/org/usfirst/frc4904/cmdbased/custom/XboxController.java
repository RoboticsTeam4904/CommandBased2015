package org.usfirst.frc4904.cmdbased.custom;


import org.usfirst.frc4904.cmdbased.RobotMap;
import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick {
	public XboxController(int port) {
		super(port);
	}

	public double getValue(int axis) {
		double value = 0;
		if (axis == RobotMap.XBOX_X_STICK) {
			value = this.getX(); // What this is doing should make sense
		} else if (axis == RobotMap.XBOX_Y_STICK) {
			value = this.getY(); // Ditto above
		} else if (axis == RobotMap.XBOX_TWIST_STICK) {
			value = getRawAxis(RobotMap.XBOX_TWIST_RAW_AXIS);
		}
		if (Math.abs(value) < RobotMap.XBOX_MINIMUM_THRESHOLD) { // Xbox does not go perfectly to zero when released
			value = 0;
		}
		return value;
	}
}