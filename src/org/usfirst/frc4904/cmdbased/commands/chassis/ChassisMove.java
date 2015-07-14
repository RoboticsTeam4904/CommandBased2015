package org.usfirst.frc4904.cmdbased.commands.chassis;


import org.usfirst.frc4904.cmdbased.commands.MotorSpin;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;
import org.usfirst.frc4904.cmdbased.subsystems.Motor;
import org.usfirst.frc4904.cmdbased.subsystems.chassis.Chassis;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ChassisMove extends CommandGroup {
	private final MotorSpin[] motorSpins;
	private double[] motorSpeeds;
	private final Chassis chassis;
	private final Controller controller;
	private final double xScale;
	private final double yScale;
	private final double turnScale;
	
	public ChassisMove(Motor[] motors, Chassis chassis, Controller controller, double xScale, double yScale, double turnScale) {
		this.motorSpins = new MotorSpin[motors.length];
		this.chassis = chassis;
		this.controller = controller;
		for (int i = 0; i < motors.length; i++) {
			motorSpins[i] = new MotorSpin(motors[i]);
			addParallel(motorSpins[i]);
		}
		this.xScale = xScale;
		this.yScale = yScale;
		this.turnScale = turnScale;
	}
	
	public ChassisMove(Motor[] motors, Chassis chassis, Controller controller) {
		this(motors, chassis, controller, 1.0, 1.0, 1.0);
	}
	
	protected void initialize() {
		requires(chassis);
	}
	
	protected void execute() {
		double[] desiredMovement = controller.readPipe();
		chassis.move2dc(desiredMovement[0] * xScale, desiredMovement[1] * yScale, desiredMovement[2] * turnScale);
		motorSpeeds = chassis.readPipe();
		for (int i = 0; i < motorSpins.length; i++) {
			motorSpins[i].writePipe(new double[] {motorSpeeds[i]});
		}
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false;
	}
}
