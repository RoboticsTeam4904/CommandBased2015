package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.Robot;
import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.subsystems.Chassis;
import edu.wpi.first.wpilibj.command.Command;

public class XboxDrive extends Command {
	private final Robot robot;
	private final Chassis chassis;
	
	public XboxDrive(Robot robot, Chassis chassis) {
		super("XboxDrive");
		this.robot = robot;
		this.chassis = chassis;
	}
	
	protected void initialize() {}
	
	public void execute() {
		// Calculations
		double xMovement = RobotMap.oi.xbox.leftStick.getX() * RobotMap.X_SPEED_SCALE;
		double yMovement = RobotMap.oi.xbox.leftStick.getY() * RobotMap.Y_SPEED_SCALE;
		double[] data = MecanumHelper.cartesianToPolar(xMovement, yMovement);
		double speed = data[0];
		double angle = data[1];
		double turnSpeed = RobotMap.oi.xbox.rightStick.getX() * RobotMap.TURN_SPEED_SCALE;
		// Commands
		(new ChassisDrive(chassis, speed, angle, turnSpeed)).start();
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return robot.isEnabledOperatorControl(); // default command
	}
}