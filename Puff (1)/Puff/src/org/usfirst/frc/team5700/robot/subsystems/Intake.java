package org.usfirst.frc.team5700.robot.subsystems;

import org.usfirst.frc.team5700.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController intakeMotor;
	
	public Intake() {
		super();
		intakeMotor = new Spark(RobotMap.INTAKE_MOTOR);
	}
	
	// sets motor for intaking boulder
	public void intake() {
		intakeMotor.set(0.5);
	}
	
	// sets motor for scoring low goals
	public void shoot() {
		intakeMotor.set(-1);
	}
	
	public void stop() {
		intakeMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

