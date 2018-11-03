package Person;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Phungdethuong - a robot by (your name here)
 */
public class Phungdethuong extends Robot
{
	/**
	 * run: Phungdethuong's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		setBodyColor(Color.blue);
		setgunColor(Color.white);
		setradarColor(Color.prink);
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(15);
			turnGunRight(360);
			back(15);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		//fire(5);
		if (e.getDistance() < 50 && getEnergy() > 50) {
			fire(3);
		} 
		else {
			fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));

		ahead(dist);
		back(dist)
		dist *= -2;
		scan();
	}
	
	/**
	 * onHitWall: khi dam vao tuong thi lam gi
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}	
}
