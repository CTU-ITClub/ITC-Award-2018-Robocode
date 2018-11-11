package Boss;


import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

import java.awt.*;


/**
 * RamFire - a sample robot by Mathew Nelson.
 * <p>
 * Drives at robots trying to ram them.
 * Fires when it hits them.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public class SUPERBOSS extends Robot {
	int turnDirection = 1; // Clockwise or counterclockwise
	double moveAmount; // How much to move

	/**
	 * run: Spin around looking for a target
	 */
	public void run() {
		// Set colors
		setColors(Color.orange, Color.blue, Color.white, Color.yellow, Color.black);

		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());

		while (true) {
			turnRight(5 * turnDirection);
		}
	}

	/**
	 * onScannedRobot:  We have a target.  Go get it.
	 */
	public void onScannedRobot(ScannedRobotEvent e) {

		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 20);
		scan(); // Might want to move ahead again!
	}

	/**
	 * onHitRobot:  Turn to face robot, fire hard, and ram him again!
	 */
	public void onHitRobot(HitRobotEvent e) {
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else {
			turnDirection = -1;
		}
		turnRight(e.getBearing());

		// Determine a shot that won't kill the robot...
		// We want to ram him instead for bonus points
		if (e.getEnergy() > 16) {
			fire(5);
		} else if (e.getEnergy() > 10) {
			fire(5);
		} else if (e.getEnergy() > 4) {
			fire(5);
		} else if (e.getEnergy() > 2) {
			fire(5);
		} else if (e.getEnergy() > .4) {
			fire(3);
		}
		ahead(moveAmount); // Ram him again!
	}
}
