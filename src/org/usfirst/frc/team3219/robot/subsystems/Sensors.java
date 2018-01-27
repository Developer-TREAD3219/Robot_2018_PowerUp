/**
 * 
 */
package org.usfirst.frc.team3219.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Tread Developer
 *
 */


public class Sensors {
	private static AHRS navX = new AHRS(SPI.Port.kMXP);
	
	public static double heading() {
		double head1 = navX.getYaw();
		SmartDashboard.putNumber("getYaw", head1);
		return head1;
	}
	
	public static void zeroHeading() {
		navX.reset();
	}
}
