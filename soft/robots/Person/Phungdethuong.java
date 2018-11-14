/**
 * Copyright (c) 2001-2018 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */
package Person;


import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.*;


/**
 * Walls - a sample robot by Mathew Nelson, and maintained by Flemming N. Larsen
 * <p>
 * Moves around the outer edge with the gun facing in.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public class Phungdethuong extends Robot {

	boolean mlp; // Don't turn if there's a robot there
	double moveAmount; // How much to move

	/**
	 * run: Move around the walls
	 */
	public void run() {
		// Set colors
		setBodyColor(Color.blue);
		setGunColor(Color.blue);
		setRadarColor(Color.pink);
		setBulletColor(Color.pink);
		setScanColor(Color.pink);

		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		// Initialize mlp to false
		mlp = false;
		// turnLeft to face a wall.
		// getHeading() % 90 means the remainder of
		// getHeading() divided by 90.
		///turnLeft(getHeading() % 90);
		turnRight(getHeading() % 90);
		back(moveAmount);
		// Turn the gun to turn right 90 degrees.
		mlp = true;
		///turnGunRight(90);
		///turnRight(90);
		turnGunLeft(90);
		turnLeft(90);

		while (true) {
			// Look before we turn when ahead() completes.
			mlp = true;
			///mlp = false;
			// Move up the wall
			///ahead(moveAmount);
			back(moveAmount);
			// Don't look now
			mlp = false;
			///mlp = true;
			// Turn to the next wall
			///turnRight(90);
			turnLeft(90);
			
		}
	}

	/**
	 * onHitRobot:  Move away a bit.
	 */
	public void onHitRobot(HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			///back(100);
			ahead(100);
		} // else he's in back of us, so set ahead a bit.
		else {
			///ahead(100);
			back(100);
		}
		double turnGunAmt = normalRelativeAngleDegrees(e.getBearing() + getHeading() - getGunHeading());

		turnGunRight(turnGunAmt);
		fire(3);
	

	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(5);
		// Note that scan is called automatically when the robot is moving.
		// By calling it manually here, we make sure we generate another scan event if there's a robot on the next
		// wall, so that we do not start moving up it until it's gone.
		if (mlp) {
			scan();
		}
	}
}
