package org.usfirst.frc.team5700.robot;

import org.usfirst.frc.team5700.robot.commands.DriveStraightSlowly;
import org.usfirst.frc.team5700.robot.commands.IntakeBoulder;
import org.usfirst.frc.team5700.robot.commands.ReelWinch;
import org.usfirst.frc.team5700.robot.commands.ShootBoulder;
import org.usfirst.frc.team5700.robot.commands.SlowUnreel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	//create Joysticks and squared inputs for driving tankDrive
	private Joystick rightStick = new Joystick(1);
	private Joystick leftStick = new Joystick(0);
    private Joystick auxiliaryStick = new Joystick(2);
    
    // Setting squaredInput to true decreases the sensitivity for tankdrive at lower speeds
    private boolean squaredInput = true;
    
	//sets buttons for scaling arm release
	JoystickButton scalingRelease1 = new JoystickButton(auxiliaryStick, 11);
	JoystickButton scalingRelease2 = new JoystickButton(auxiliaryStick, 12);
	
	public OI() {
		//sets button for driving straight
		JoystickButton r1 = new JoystickButton(rightStick, 1);
		
		//sets buttons for intake 
		JoystickButton auxTrigger = new JoystickButton(auxiliaryStick, 1);
		JoystickButton auxThumb = new JoystickButton(auxiliaryStick, 2);
		
		//sets buttons for reeling and unreeling winch
		JoystickButton reelWinch = new JoystickButton(auxiliaryStick, 10);
		JoystickButton unreelWinch = new JoystickButton(auxiliaryStick, 8);
		
		//setting buttons to commands
		r1.whileHeld(new DriveStraightSlowly());
		auxTrigger.whileHeld(new ShootBoulder()); 
		auxThumb.whileHeld(new IntakeBoulder());
		reelWinch.whileHeld(new ReelWinch());
		unreelWinch.whileHeld(new SlowUnreel());
	}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	

    
    
    // Adds two Attack Joysticks for tankdrive
    public Joystick getLeftStick() {
    	return leftStick;	
    }
    
    public Joystick getRightStick() {
    	return rightStick;
    }
    
    // Adds joystick for arm, intake, and scaling controls
    public Joystick getAuxiliaryStick() {
    	return auxiliaryStick;
    }
    
    public boolean getSquaredInput() {
    	return squaredInput;
    }
    
    public boolean getScalingRelease1() {
    	return scalingRelease1.get();
    }
    
    public boolean getScalingRelease2() {
    	return scalingRelease2.get();
    }
}

