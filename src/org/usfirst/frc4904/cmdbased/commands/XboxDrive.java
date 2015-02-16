package org.usfirst.frc4904.cmdbased.commands;


import org.usfirst.frc4904.cmdbased.RobotMap;
import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import edu.wpi.first.wpilibj.command.Scheduler;

public class XboxDrive extends CommandBase {
	public XboxDrive() {
		super("XboxDrive");
	}
	
	protected void initialize() {}
	
	public void execute() {
		// Calculations
		double xMovement = oi.xbox.getValue(RobotMap.XBOX_Y_STICK) * RobotMap.X_SPEED_SCALE;
		double yMovement = oi.xbox.getValue(RobotMap.XBOX_X_STICK) * RobotMap.Y_SPEED_SCALE;
		double[] data = MecanumHelper.cartesianToPolar(xMovement, yMovement);
		double speed = data[0];
		double angle = data[1];
		double turnSpeed = oi.xbox.getValue(RobotMap.XBOX_TWIST_STICK) * RobotMap.TURN_SPEED_SCALE;
		// Commands
		Scheduler.getInstance().add(new ChassisDrive(speed, angle, turnSpeed));
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}