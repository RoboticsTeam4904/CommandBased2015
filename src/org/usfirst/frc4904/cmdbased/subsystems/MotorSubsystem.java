package org.usfirst.frc4904.cmdbased.subsystems;


import edu.wpi.first.wpilibj.SpeedController;

public interface MotorSubsystem extends SpeedController {
	public void set(double speed);
	
	public void set(double speed, byte arg0);
}
