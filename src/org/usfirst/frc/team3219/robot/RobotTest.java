/**
 * 
 */
package org.usfirst.frc.team3219.robot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author riggijon000
 *
 */
class RobotTest {

	@Test
	void testSwitchRight() {
		Robot.setSideOwnership("RLL");
		assertEquals(Robot.RIGHT_SIDE, Robot.allianceSwitch);
	}
	@Test
	void testSwitchLeft() {
		Robot.setSideOwnership("LRR");
		assertEquals(Robot.LEFT_SIDE, Robot.allianceSwitch);
	}
	@Test
	void testScaleRight() {
		Robot.setSideOwnership("LRL");
		assertEquals(Robot.RIGHT_SIDE, Robot.scale);
	}
	@Test
	void testScaleLeft() {
		Robot.setSideOwnership("RLR");
		assertEquals(Robot.LEFT_SIDE, Robot.scale);
	}
	@Test
	void testOSwitchRight() {
		Robot.setSideOwnership("LLR");
		assertEquals(Robot.RIGHT_SIDE, Robot.opposingSwitch);
	}
	@Test
	void testOSwitchLeft() {
		Robot.setSideOwnership("RRL");
		assertEquals(Robot.LEFT_SIDE, Robot.opposingSwitch);
	}
}
