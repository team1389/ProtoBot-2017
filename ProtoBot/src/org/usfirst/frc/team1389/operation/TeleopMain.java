package org.usfirst.frc.team1389.operation;

import org.usfirst.frc.team1389.robot.RobotSoftware;
import org.usfirst.frc.team1389.robot.controls.ControlBoard;
import org.usfirst.frc.team1389.systems.GripperSystem;
import org.usfirst.frc.team1389.watchers.DebugDash;

import com.team1389.hardware.inputs.software.AngleIn;
import com.team1389.hardware.value_types.Position;
import com.team1389.system.Subsystem;
import com.team1389.system.SystemManager;
import com.team1389.system.drive.CurvatureDriveSystem;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class TeleopMain {
	SystemManager manager;
	ControlBoard controls;
	RobotSoftware robot;
	ADXRS450_Gyro gyro;

	public TeleopMain(RobotSoftware robot) {
		this.robot = robot;
		this.gyro = new ADXRS450_Gyro();
	}

	public void init() {
		controls = ControlBoard.getInstance();
		Subsystem drive = setupDrive();
		Subsystem gripper = setupGripper();
		manager = new SystemManager(drive, gripper);
		manager.init();
		DebugDash.getInstance().watch(drive, gripper,
				new AngleIn<Position>(Position.class, gyro::getAngle).getWatchable("gyro"));
	}

	public Subsystem setupGripper() {
		return new GripperSystem(robot.gripper, controls.grip);
	}

	public Subsystem setupDrive() {
		return new CurvatureDriveSystem(robot.drive, controls.throttle, controls.wheel, controls.quickTurn);
	}

	public void periodic() {
		manager.update();
	}
}
