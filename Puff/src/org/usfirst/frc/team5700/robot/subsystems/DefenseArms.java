package org.usfirst.frc.team5700.robot.subsystems;

import org.usfirst.frc.team5700.robot.RobotMap;
import org.usfirst.frc.team5700.robot.commands.ControlDefenseArms;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DefenseArms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController leftArm;
	private SpeedController rightArm;
	
	public DefenseArms() {
		super();
		leftArm = new Spark(RobotMap.LEFT_ARM_MOTOR);
		rightArm = new Spark(RobotMap.RIGHT_ARM_MOTOR);
	}
	
	public void armControl(Joystick auxiliaryStick) {
		leftArm.set(-auxiliaryStick.getY());
		rightArm.set(auxiliaryStick.getY());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ControlDefenseArms());
    }
}

