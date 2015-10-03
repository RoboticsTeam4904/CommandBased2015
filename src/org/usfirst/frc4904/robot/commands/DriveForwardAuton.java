package org.usfirst.frc4904.robot.commands;


import java.util.ArrayList;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.chassis.Chassis;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardAuton extends Command {
	private final Chassis chassis;
	private final double speed;
	private final ArrayList<MotorConstant> commands;
	
	public DriveForwardAuton(Chassis chassis, double timeout, double speed) {
		super("DriveForwardAuton", timeout);
		requires(chassis);
		setInterruptible(false);
		this.chassis = chassis;
		this.speed = speed;
		this.commands = new ArrayList<MotorConstant>();
	}
	
	protected void initialize() {
		for (Motor motor : chassis.getMotors()) {
			MotorConstant temp = new MotorConstant(motor, speed);
			temp.start();
			commands.add(temp);
		}
	}
	
	protected void execute() {}
	
	protected void end() {
		for (MotorConstant command : commands) {
			command.cancel();
		}
	}
	
	protected void interrupted() {
		end();
	}
	
	protected boolean isFinished() {
		return false; // Should die by itself on timeout
	}
}
