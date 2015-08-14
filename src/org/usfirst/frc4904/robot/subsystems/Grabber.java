package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.cmdbased.commands.motor.MotorIdle;
import org.usfirst.frc4904.cmdbased.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.SpeedController;

public class Grabber extends Motor {
	// Define locations of limit switches in array (for clarity)
	private final LimitSwitchSystem limitSwitches;
	
	public Grabber(SpeedController motor, LimitSwitchSystem limitSwitches) {
		super("Grabber", motor);
		this.limitSwitches = limitSwitches;
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new MotorIdle(this));
	}
	
	public void set(double value) {
		if (value <= 1 && value >= -1) {
			motor.set(value);
		}
	}
	
	public boolean isInnerSwitchPressed() {
		return limitSwitches.isInnerSwitchPressed();
	}
	
	public boolean isOuterSwitchPressed() {
		return limitSwitches.isOuterSwitchPressed();
	}
}