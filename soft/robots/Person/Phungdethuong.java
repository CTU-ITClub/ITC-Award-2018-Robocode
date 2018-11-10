package Person;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.*;

import robocode.HitRobotEvent;

public class Phungdethuong extends Robot {

	boolean seephungdethuong;
	double moveAmount;
	double fire;
	int turnDirection = 1;

	/**
	 * run: Move around the walls
	 */
	public void run() {
		// Set colors
		setBodyColor(Color.pink);
		setGunColor(Color.blue);
		setRadarColor(Color.black);
		setBulletColor(Color.white);
		setScanColor(Color.red);

		// Initialize moveAmount to the maximum possible for this battlefield.
		moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
		// Initialize peek to false
		seephungdethuong = false;

		// turnLeft to face a wall.
		// getHeading() % 90 means the remainder of
		// getHeading() divided by 90.
		//turnLeft(getHeading() % 90);
		//ahead(moveAmount);
		// Turn the gun to turn right 90 degrees.
		//seephungdethuong = true;
		//turnGunRight(90);
		//turnRight(90);

		while (true) {
			// Look before we turn when ahead() completes.
			seephungdethuong = true;
			// Move up the wall
			ahead(moveAmount);
			// Don't look now
			seephungdethuong = false;
			// Turn to the next wall
			//turnRight(90);
		//}
	//	while (true) {
			turnRight(45);
			ahead(200);
			turnLeft(45);
			ahead(200);
			turnRight(45);
			back(200);
			turnLeft(45);
			back(200);
			scan();
			
		}
	}

	/**
	 * onHitRobot:  Move away a bit.
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
			fire(3);
		} else if (e.getEnergy() > 10) {
			fire(2);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40);

	/**
	 * onScannedRobot:  Fire!
	 */
public void onScannedRobot(ScannedRobotEvent e) {
		
		if (e.getBearing() >= 0) {
			turnDirection = 1;
		} else if{
			turnDirection = -1;
		}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 5);
		scan();
	}	
	

}
