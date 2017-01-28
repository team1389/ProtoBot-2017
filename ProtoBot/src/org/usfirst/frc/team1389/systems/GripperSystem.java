package org.usfirst.frc.team1389.systems;

import com.team1389.hardware.inputs.software.DigitalIn;
import com.team1389.hardware.outputs.software.DigitalOut;
import com.team1389.system.Subsystem;
import com.team1389.util.AddList;
import com.team1389.watch.Watchable;

public class GripperSystem extends Subsystem {
	DigitalOut gripper;
	DigitalIn gripperTrigger;

	public GripperSystem(DigitalOut gripper, DigitalIn gripperTrigger) {
		this.gripper = gripper;
		this.gripperTrigger = gripperTrigger;
	}

	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> stem) {
		return stem.put(gripper.getWatchable("gripper output"), gripperTrigger.getWatchable("gripper button"));
	}

	@Override
	public String getName() {
		return "Gripper";
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		gripper.set(gripperTrigger.get());
	}

}
