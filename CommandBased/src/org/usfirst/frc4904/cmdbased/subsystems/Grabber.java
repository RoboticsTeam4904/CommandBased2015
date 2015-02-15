package org.usfirst.frc4904.cmdbased.subsystems;


import org.usfirst.frc4904.cmdbased.commands.GrabberIdle;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabber extends Subsystem {
	// Define locations of limit switches in array (for clarity)
	private final LimitSwitchSystem limitSwitches;
	private final Talon motor;
	
	public Grabber(Talon motor, LimitSwitchSystem limitSwitches) {
		super("Grabber");
		this.limitSwitches = limitSwitches;
		this.motor = motor;
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new GrabberIdle());
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