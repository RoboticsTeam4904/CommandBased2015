package org.usfirst.frc4904.cmdbased.subsystems.chassis;


import org.usfirst.frc4904.cmdbased.subsystems.Motor;

public class MecanumChassis extends FourWheelChassis {
	public MecanumChassis(String name, Motor frontLeftWheel, Motor frontRightWheel, Motor backLeftWheel, Motor backRightWheel) {
		super(name, frontLeftWheel, frontRightWheel, backLeftWheel, backRightWheel);
	}
	
	/**
	 * @param speed
	 *        (0 to 1)
	 *        : speed in all directions
	 * @param angle
	 *        (0 to 2pi)
	 *        : angle of movement
	 * @param turnSpeed
	 *        (0 to 1)
	 *        : rate of rotation around center
	 */
	public void move2dp(double speed, double angle, double turnSpeed) {
		double frontLeft = speed * Math.sin(angle + Math.PI / 4) + turnSpeed;
		double frontRight = speed * Math.cos(angle + Math.PI / 4) - turnSpeed;
		double backLeft = speed * Math.cos(angle + Math.PI / 4) + turnSpeed;
		double backRight = speed * Math.sin(angle + Math.PI / 4) - turnSpeed;
		double scaleFactor = Math.max(Math.max(Math.max(Math.abs(frontLeft), Math.abs(frontRight)), Math.abs(backLeft)), Math.abs(backRight));
		if (scaleFactor < 1) {
			scaleFactor = 1;
		}
		motorSpeeds[0] = frontLeft / scaleFactor;
		motorSpeeds[1] = -frontRight / scaleFactor; // Negated because of motors being of the inside of chassis
		motorSpeeds[2] = backLeft / scaleFactor;
		motorSpeeds[3] = -backRight / scaleFactor; // Negated because of motors being of the inside of chassis
	}
	
	/**
	 * @param xSpeed
	 *        : speed in x direction
	 * @param ySpeed
	 *        : speed in y direction
	 */
	public void move2dc(double xSpeed, double ySpeed, double turnSpeed) {
		double speed = Math.sqrt(xSpeed * xSpeed + ySpeed * ySpeed);
		double angle = Math.atan2(ySpeed, xSpeed);
		move2dp(speed, angle, turnSpeed);
	}
}
