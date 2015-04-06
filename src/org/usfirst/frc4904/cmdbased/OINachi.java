package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.commands.GrabCan;
import org.usfirst.frc4904.cmdbased.commands.GrabTote;
import org.usfirst.frc4904.cmdbased.commands.WinchChangeHeight;
import org.usfirst.frc4904.cmdbased.commands.WinchSetHeight;

public class OINachi extends OI {
	public OINachi() {
		super();
		// Bind operator buttons to commands
		button1.toggleWhenPressed(new GrabTote(RobotMap.chassis, RobotMap.grabber, RobotMap.lidar, RobotMap.winch));
		button2.toggleWhenPressed(new GrabCan(RobotMap.chassis, RobotMap.grabber, RobotMap.lidar, RobotMap.winch));
		button3.whenPressed(new WinchChangeHeight(RobotMap.winch, -1)); // Lower winch two half-totes
		button4.whenPressed(new WinchChangeHeight(RobotMap.winch, 1)); // Raise winch two half-totes
		button5.whenPressed(new WinchSetHeight(RobotMap.winch, 0)); // Lower winch all the way (1 half-totes)
		button6.whenPressed(new WinchSetHeight(RobotMap.winch, 12)); // Raise winch all the way (12 half-totes)
	}
	
	public String getName() {
		return "Griffin";
	}
}
