package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.custom.Named;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;

public abstract class Operator extends HumanInterface implements Named {
	public Operator(String name, Controller... controller) {
		super(name, controller);
	}
	
	public abstract void bindCommands();
}
