package org.usfirst.frc4904.cmdbased.commands.chassis;


import org.usfirst.frc4904.cmdbased.commands.MotorIdle;
import org.usfirst.frc4904.cmdbased.subsystems.Motor;
import org.usfirst.frc4904.cmdbased.subsystems.chassis.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisIdle extends CommandGroup {
	private final Chassis chassis;
	
	public ChassisIdle(Chassis chassis) {
		super("ChassisIdle");
		this.chassis = chassis;
		setInterruptible(true); // default command
	}
	
	protected void initialize() {
		requires(chassis);
	}
	
	protected void execute() {
		Motor[] motors = chassis.getMotors();
		for (Motor motor : motors) {
			addParallel(new MotorIdle(motor));
		}
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}
