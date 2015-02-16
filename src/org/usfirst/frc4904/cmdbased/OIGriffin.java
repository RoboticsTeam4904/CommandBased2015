package org.usfirst.frc4904.cmdbased;


import org.usfirst.frc4904.cmdbased.commands.GrabCan;
import org.usfirst.frc4904.cmdbased.commands.GrabTote;
import org.usfirst.frc4904.cmdbased.commands.WinchChangeHeight;
import org.usfirst.frc4904.cmdbased.commands.WinchSetHeight;

public class OIGriffin extends OI {
	public OIGriffin() {
		super();
		// Bind operator buttons to commands
		button10.toggleWhenPressed(new GrabTote());
		button8.toggleWhenPressed(new GrabCan());
		button3.whenPressed(new WinchChangeHeight(-2)); // Lower winch two half-totes
		button4.whenPressed(new WinchChangeHeight(2)); // Raise winch two half-totes
		button5.whenPressed(new WinchSetHeight(1)); // Lower winch all the way (1 half-totes)
		button6.whenPressed(new WinchSetHeight(12)); // Raise winch all the way (12 half-totes)
	}
}
