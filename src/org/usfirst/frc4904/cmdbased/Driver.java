package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.custom.Named;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;

public abstract class Driver extends HumanInterface implements Named {
	public Driver(String name, Controller... controller) {
		super(name, controller);
	}
	
	public abstract void bindCommands();
}