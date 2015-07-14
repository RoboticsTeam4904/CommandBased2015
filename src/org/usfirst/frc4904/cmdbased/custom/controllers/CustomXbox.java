package org.usfirst.frc4904.cmdbased.custom.controllers;


public class CustomXbox extends XboxController implements Controller {
	public CustomXbox(final int port) {
		super(port);
	}
	
	public double[] readPipe() {
		return new double[] {this.leftStick.getX(), this.rightStick.getY(), this.leftStick.getX()};
	}
}
