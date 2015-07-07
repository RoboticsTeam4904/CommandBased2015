package org.usfirst.frc4904.cmdbased.commands.chassis.mecanum;


import org.usfirst.frc4904.cmdbased.custom.MecanumHelper;
import org.usfirst.frc4904.cmdbased.custom.XboxController;
import org.usfirst.frc4904.cmdbased.subsystems.chassis.FourWheelChassis;
import edu.wpi.first.wpilibj.command.Command;

public class XboxMecanumDrive extends Command {
	private final FourWheelChassis chassis;
	private final XboxController xbox;
	private final double xScale;
	private final double yScale;
	private final double turnScale;
	
	public XboxMecanumDrive(FourWheelChassis chassis, XboxController xbox, double xScale, double yScale, double turnScale) {
		super("XboxDrive");
		this.chassis = chassis;
		this.xbox = xbox;
		this.xScale = xScale;
		this.yScale = yScale;
		this.turnScale = turnScale;
	}
	
	protected void initialize() {
		requires(chassis);
	}
	
	public void execute() {
		// Calculations
		double xMovement = xbox.leftStick.getX() * xScale;
		double yMovement = xbox.leftStick.getY() * yScale;
		double[] data = MecanumHelper.cartesianToPolar(xMovement, yMovement);
		double speed = data[0];
		double angle = data[1];
		double turnSpeed = xbox.rightStick.getX() * turnScale;
		// Commands
		(new MecanumDrive(chassis, speed, angle, turnSpeed)).start();
	}
	
	protected void end() {}
	
	protected void interrupted() {}
	
	protected boolean isFinished() {
		return false; // default command
	}
}