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
	private static final int FINAL_PITCH_ANGLE = 85;
	private static final double kCollisionThreshold_DeltaG = 0.5f;
	private AHRS navX;
	private double last_world_linear_accel_x = 0;
	private double last_world_linear_accel_y = 0;

	public Sensors() {
		navX = new AHRS(SPI.Port.kMXP);
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

	public boolean bonked() {
		boolean collisionDetected = false;

		double curr_world_linear_accel_x = navX.getWorldLinearAccelX();
		double currentJerkX = curr_world_linear_accel_x - last_world_linear_accel_x;
		last_world_linear_accel_x = curr_world_linear_accel_x;
		double curr_world_linear_accel_y = navX.getWorldLinearAccelY();
		double currentJerkY = curr_world_linear_accel_y - last_world_linear_accel_y;
		last_world_linear_accel_y = curr_world_linear_accel_y;

		if ((Math.abs(currentJerkX) > kCollisionThreshold_DeltaG)
				|| (Math.abs(currentJerkY) > kCollisionThreshold_DeltaG)) {
			collisionDetected = true;
		}
		SmartDashboard.putBoolean("CollisionDetected", collisionDetected);
		return collisionDetected;
	}
	
	public boolean climbed() {
		return Math.abs(this.navX.getPitch()) >= FINAL_PITCH_ANGLE;
		
		
	}
	
	
}

