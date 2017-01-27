package org.usfirst.frc.team1389.operation;

import org.usfirst.frc.team1389.robot.RobotSoftware;
import org.usfirst.frc.team1389.robot.controls.ControlBoard;
import org.usfirst.frc.team1389.watchers.DebugDash;

import com.team1389.system.Subsystem;
import com.team1389.system.SystemManager;
import com.team1389.system.drive.CheesyDriveSystem;

public class TeleopMain {
	SystemManager manager;
	ControlBoard controls;
	RobotSoftware robot;

	public TeleopMain(RobotSoftware robot) {
		this.robot = robot;
	}

	public void init() {
		controls = ControlBoard.getInstance();
		Subsystem drive = setupDrive();
		manager = new SystemManager(drive);
		manager.init();
		DebugDash.getInstance().watch(drive);
	}

	public Subsystem setupDrive() {
		return new CheesyDriveSystem(robot.drive, controls.throttle, controls.wheel, controls.quickTurn);
	}

	public void periodic() {
		manager.update();
	}
}
