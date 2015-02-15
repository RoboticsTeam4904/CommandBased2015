package org.usfirst.frc4904.cmdbased.custom;


public class IMU {
	private final MPU9150 mpu9150;
	public double[] rawData = new double[10];
	private double startTime;
	private long updates = 0;
	private double currentSpeed;
	private double currentAngle;
	private double currentTurnSpeed;
	
	public IMU() {
		mpu9150 = new MPU9150();
		mpu9150.init();
		zero();
		currentSpeed = 0;
		currentAngle = 0;
		currentTurnSpeed = 0;
	}
	
	public int test() {
		return mpu9150.test();
	}
	
	public double getAngle() {
		// TODO return current robot angle relative to beginning of match (0 - 2pi)
		return 0D;
	}
	
	public void zero() {
		// TODO set current orientation as "forward"
		update();
		startTime = System.currentTimeMillis() / 1000;
		updates = 0;
	}
	
	public void update() {
		mpu9150.update();
		readData();
	}
	
	public double[] getMovement() {
		return new double[] {currentSpeed, currentAngle, currentTurnSpeed};
	}
	
	private void readData() {
		updates++;
		// TODO only read data if enough data is available, otherwise return so
		// that this function is always fast
		rawData = mpu9150.read();
	}
}