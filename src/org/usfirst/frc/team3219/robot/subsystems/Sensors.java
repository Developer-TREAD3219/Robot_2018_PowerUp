/**
 * 
 */
package org.usfirst.frc.team3219.robot.subsystems;

import org.usfirst.frc.team3219.robot.Robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Tread Developer
 *
 */


public class Sensors extends Subsystem {
	private AHRS navX;
	
	public Sensors () {
		navX  = new AHRS(SPI.Port.kMXP);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
	
	@Override
	public void periodic() {
		SmartDashboard.putNumber("Yaw", heading());
	}

	public void init() {
		this.zeroHeading();
	}
	
	public double heading() {
		double head1 = navX.getYaw();
		return head1;
	}
	
	public void zeroHeading() {
		navX.reset();
	}	
}
