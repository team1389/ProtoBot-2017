package org.usfirst.frc.team1389.robot;

import com.team1389.hardware.outputs.hardware.CANTalonGroup;
import com.team1389.hardware.outputs.hardware.CANTalonHardware;
import com.team1389.hardware.outputs.hardware.DoubleSolenoidHardware;
import com.team1389.hardware.registry.Registry;
import com.team1389.hardware.registry.port_types.CAN;

/**
 * responsible for initializing and storing hardware objects defined in {@link RobotLayout}
 * 
 * @author amind
 * @see RobotLayout
 * @see RobotMap
 */
public class RobotHardware extends RobotLayout {

	/**
	 * Initializes robot hardware by subsystem. <br>
	 * note: use this method as an index to show hardware initializations that occur, and to find
	 * the init code for a particular system's hardware
	 */
	protected RobotHardware() {
		registry = new Registry();
		initDriveTrain();
		initGripper();
	}

	public Registry getRegistry() {
		return registry;
	}

	private void initGripper() {
		gripperLeft = new DoubleSolenoidHardware(pcm_GRIPPER_LEFT_A, pcm_GRIPPER_LEFT_B, registry);
		gripperRight = new DoubleSolenoidHardware(pcm_GRIPPER_RIGHT_A, pcm_GRIPPER_RIGHT_B, registry);
	}

	private void initDriveTrain() {
		leftA = new CANTalonHardware(sinv_LEFT_ENCODER, inv_LEFT_MOTOR_A, new CAN(can_LEFT_MOTOR_A), registry);
		leftB = new CANTalonHardware(inv_LEFT_MOTOR_B, new CAN(can_LEFT_MOTOR_B), registry);
		rightA = new CANTalonHardware(sinv_RIGHT_ENCODER, inv_RIGHT_MOTOR_A, new CAN(can_RIGHT_MOTOR_A), registry);
		rightB = new CANTalonHardware(inv_RIGHT_MOTOR_B, new CAN(can_RIGHT_MOTOR_B), registry);
		leftDrive = new CANTalonGroup(leftA, leftB);
		rightDrive = new CANTalonGroup(rightA, rightB);
	}
}
