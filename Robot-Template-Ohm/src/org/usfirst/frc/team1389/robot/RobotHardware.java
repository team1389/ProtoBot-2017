package org.usfirst.frc.team1389.robot;

import com.team1389.hardware.inputs.hardware.JoystickHardware;
import com.team1389.hardware.inputs.hardware.NavXHardware;
import com.team1389.hardware.outputs.hardware.CANTalonGroup;
import com.team1389.hardware.outputs.hardware.CANTalonHardware;
import com.team1389.hardware.outputs.hardware.DoubleSolenoidHardware;
import com.team1389.hardware.registry.Registry;
import com.team1389.hardware.registry.port_types.CAN;
import com.team1389.hardware.registry.port_types.PCM;

import edu.wpi.first.wpilibj.SPI;

/**
 * responsible for initializing and storing hardware objects defined in
 * {@link RobotLayout}
 * 
 * @author amind
 * @see RobotLayout
 * @see RobotMap
 */
public class RobotHardware extends RobotLayout {

	/**
	 * Initializes robot hardware by subsystem. <br>
	 * note: use this method as an index to show hardware initializations that
	 * occur, and to find the init code for a particular system's hardware
	 */
	protected RobotHardware() {
		registry = new Registry();
		navX = new NavXHardware(SPI.Port.kMXP, registry);
		gripper = new DoubleSolenoidHardware(new PCM(pcm_grippers1),new PCM(pcm_grippers2), registry);
		joy = new JoystickHardware(0);
		initDriveTrain();
		
	}


	private void initDriveTrain() {
		leftA = new CANTalonHardware(false, false, new CAN(can_LEFT_MOTOR_A), registry);
		rightA = new CANTalonHardware(true, false, new CAN(can_RIGHT_MOTOR_A), registry);
		leftB = new CANTalonHardware(false, false, new CAN(can_LEFT_MOTOR_B), registry);
		rightB = new CANTalonHardware(true, false, new CAN(can_RIGHT_MOTOR_B), registry);
		leftGroup = new CANTalonGroup(leftA, leftB);
		rightGroup = new CANTalonGroup(rightA, rightB);
	}

	public Registry getRegistry() {
		return registry;
	}

}