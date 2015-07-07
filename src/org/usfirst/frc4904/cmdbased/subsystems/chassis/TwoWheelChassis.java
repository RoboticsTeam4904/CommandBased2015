package org.usfirst.frc4904.cmdbased.subsystems.chassis;


import org.usfirst.frc4904.cmdbased.subsystems.Motor;

public abstract class TwoWheelChassis extends Chassis {
	protected final Motor leftWheel;
	protected final Motor rightWheel;
	
	public TwoWheelChassis(String name, Motor leftWheel, Motor rightWheel) {
		super(name);
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
		this.numberWheels = 2;
	}
}
