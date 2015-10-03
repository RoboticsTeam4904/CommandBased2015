package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.chassis.Chassis;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveForwardAuton extends CommandGroup {
	public DriveForwardAuton(Chassis chassis, double timeout, double speed) {
		super("DriveForwardAuton");
		requires(chassis);
		setInterruptible(true);
		setTimeout(timeout);
		Motor[] motors = chassis.getMotors();
		chassis.move2dc(0, speed, 0);
		double[] motorSpeeds = chassis.getMotorSpeeds();
		for (int i = 0; i < motors.length; i++) {
			addParallel(new MotorConstant(motors[i], motorSpeeds[i]));
		}
	}
	
	protected void initialize() {}
	
	protected void execute() {}
	
	protected void end() {}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return isTimedOut(); // Should die by itself on timeout
	}
}
