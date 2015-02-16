package org.usfirst.frc4904.cmdbased.custom;


public class MPU9150 {
	public double[] data;
	public final int MPU9150_PWR_MGMT_1 = 0x6B; // R/W
	public final int MPU9150_PWR_MGMT_2 = 0x6C; // R/W
	// taken from http://playground.arduino.cc/Main/MPU-9150
	// modified to be Java syntax
	private final int[] cmps = new int[3];
	private final int[] accl = new int[3];
	private final int[] gyro = new int[3];
	private int temp; // Temperature, not temporary. Don't kill Erik.
	
	// I2C objects
	// private final MPUAccelGryo accelGryo;
	// private final MPUComp compass;
	public MPU9150() {
		// Initialize I2C
		/*
		 * accelGryo = new MPUAccelGryo(0x68); compass = new MPUComp(0x0C); accelGryo.write(MPU9150_PWR_MGMT_1, 0); // Data variable
		 */
		data = new double[10];
	}
	
	public void init() {
		// Extremely modified from http://playground.arduino.cc/Main/MPU-9150
		/*
		 * accelGryo.init(); compass.init();
		 */
	}
	
	public byte test() {
		// return accelGryo.test();
		return 0x00;
	}

	public double[] read() {
		return data;
	}
	
	public void readAcc() {}
	
	public void update() {}
}