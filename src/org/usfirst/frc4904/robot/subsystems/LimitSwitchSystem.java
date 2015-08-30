package org.usfirst.frc4904.robot.subsystems;


import org.usfirst.frc4904.cmdbased.custom.sensors.CustomLimitSwitch;
import edu.wpi.first.wpilibj.buttons.Button;

public class LimitSwitchSystem extends Button {
	private final CustomLimitSwitch rightInnerSwitch;
	private final CustomLimitSwitch leftInnerSwitch;
	private final CustomLimitSwitch rightOuterSwitch;
	private final CustomLimitSwitch leftOuterSwitch;
	
	public LimitSwitchSystem(CustomLimitSwitch rightInnerSwitch, CustomLimitSwitch leftInnerSwitch, CustomLimitSwitch rightOuterSwitch, CustomLimitSwitch leftOuterSwitch) {
		this.rightInnerSwitch = rightInnerSwitch;
		this.leftInnerSwitch = leftInnerSwitch;
		this.rightOuterSwitch = rightOuterSwitch;
		this.leftOuterSwitch = leftOuterSwitch;
	}
	
	public boolean get() {
		return rightInnerSwitch.get() || leftInnerSwitch.get() || rightOuterSwitch.get() || leftOuterSwitch.get();
	}
}
