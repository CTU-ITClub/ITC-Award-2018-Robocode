package Person;
import robocode.*;
import java.awt.Color;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.*;


// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

// Resend robot because of bugs

/**
 * Phungdethuong - a robot by (your name here)
 */
public class Phungdethuong extends Robot
{
	/**
	 * run: Phungdethuong's default behavior
	 */
	public void run() {
		
	while (true) {
			turnGunRight(360);
			scan();
		//	turnGunRight(e.getBearing());
			
			//ahead(50);
			//back(50);
		}
	}

	/**
	 * onScannedRobot:  We have a target.  Go get it.
	 */
	public void onScannedRobot(ScannedRobotEvent e) {

	//	if (e.getBearing() >= 0) {
		//	ahead(50);
	//	} else {
		//	back(50);
		//}

		turnRight(e.getBearing());
		ahead(e.getDistance() + 50);
		scan(); // Might want to move ahead again!
	}

	/**
	 * onHitRobot:  Turn to face robot, fire hard, and ram him again!
	 */
	public void onHitRobot(HitRobotEvent e) {
	//	if (e.getBearing() >= 0) {
		//	ahead(10);
		//} else {
		//	back(10);
		//}
		turnRight(e.getBearing());

		// Determine a shot that won't kill the robot...
		// We want to ram him instead for bonus points
		if (e.getEnergy() > 16) {
			fire(10);
		} else if (e.getEnergy() > 10) {
			fire(2);
		} else if (e.getEnergy() > 4) {
			fire(1);
		} else if (e.getEnergy() > 2) {
			fire(.5);
		} else if (e.getEnergy() > .4) {
			fire(.1);
		}
		ahead(40); // Ram him again!
	}
}