package org.usfirst.frc.team1389.robot;

import com.team1389.hardware.outputs.software.DigitalOut;
import com.team1389.hardware.value_types.Percent;
import com.team1389.system.drive.DriveOut;

public class RobotSoftware extends RobotHardware {
	private static RobotSoftware INSTANCE = new RobotSoftware();
	public DriveOut<Percent> drive=new DriveOut<>(leftDrive.getVoltageOutput(),rightDrive.getVoltageOutput());
	public DigitalOut gripper=gripperLeft.getDigitalOut().addFollowers(gripperRight.getDigitalOut());
	public static RobotSoftware getInstance() {
		return INSTANCE;
	}

}
