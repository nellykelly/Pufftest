package org.usfirst.frc.team5700.robot.subsystems;

import org.usfirst.frc.team5700.robot.RobotMap;
import org.usfirst.frc.team5700.robot.commands.ReleaseScalingArm;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Scaling extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController winch;
	private Servo releaseServo;
	
	public Scaling() {
		super();
		winch = new Spark(RobotMap.WINCH_MOTOR);
		releaseServo = new Servo(RobotMap.RELEASE_SERVO);
	}
	
	/**
	 * Moves servo to release scaling arm if both buttons are pressed
	 * @param button1 whether first button is pressed
	 * @param button2 whether second button is pressed
	**/
	public void releaseScalingArm(boolean button1, boolean button2) {
		if (button1 && button2) {
			releaseServo.set(1);
		} else {
			resetReleaseServo();
		}
	}
	
	public void resetReleaseServo() {
		releaseServo.set(0);
	}
	
	public void reel() {
		winch.set(-1);
	}
	
	public void stop() {
		winch.set(0);
	}
	
	public void slowUnreel() {
		winch.set(0.3);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ReleaseScalingArm());
    }
}

