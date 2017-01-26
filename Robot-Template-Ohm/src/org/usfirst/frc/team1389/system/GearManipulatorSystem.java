package org.usfirst.frc.team1389.system;

import com.team1389.hardware.inputs.software.DigitalIn;
import com.team1389.hardware.outputs.software.DigitalOut;
import com.team1389.system.Subsystem;
import com.team1389.util.AddList;
import com.team1389.watch.Watchable;

public class GearManipulatorSystem extends Subsystem{
	DigitalIn clawButton, jointButton;
	DigitalOut claw, joint;
	public GearManipulatorSystem(DigitalIn clawButton, DigitalIn jointButton, DigitalOut claw, DigitalOut joint){
		this.clawButton = clawButton;
		this.jointButton = jointButton;
		this.claw = claw;
		this.joint = joint;
	}

	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> stem) {
		return stem.put(clawButton.getWatchable("Claw Button"), jointButton.getWatchable("Joint Button"), claw.getWatchable("Claw"), joint.getWatchable("joint"));
	}

	@Override
	public String getName() {
		return "Gear Manipulator";
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		claw.set(clawButton.getToggled().get());
		joint.set(jointButton.getToggled().get());
	}

}
