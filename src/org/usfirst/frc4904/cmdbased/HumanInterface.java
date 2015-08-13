package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.custom.Named;
import org.usfirst.frc4904.cmdbased.custom.controllers.Controller;

public abstract class HumanInterface implements Named {
	protected final String name;
	protected final Controller[] controller;
	
	public HumanInterface(String name, Controller[] controller) {
		this.name = name;
		this.controller = controller;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void bindCommands();
}
