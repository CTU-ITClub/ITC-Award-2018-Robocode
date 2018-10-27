package Person; // goi Person: moi robot chung package duoc xem la mot doi nhung chua cai dat phan biet dich - ta nen van la ke thu cua nhau
import robocode.*; // thu vien mac dinh cua robot
import java.awt.Color; // nhap thu vien mau cho robot

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Thuc - robot cua Nguyen Thuc
 */
public class ThucDynamic extends Robot
{
	/**
	 * run: hanh vi mac dinh
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.black,Color.black,Color.white); // body,gun,radar - mau cho than robot, thap sung, thap radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100); // tien 100px
			turnGunRight(720); // xoay thap sung 720 do
			back(100); // lui 100px
			turnGunRight(720); // xoay thap sung 720 do
		}
	}

	/**
	 * onScannedRobot: hanh vi thuc hien khi do radar trung ke dich
	 */
	public void onScannedRobot(ScannedRobotEvent e) { 
		// Replace the next line with any behavior you would like
		fire(50); // ra lenh cho thap sung khai hoa voi suc manh la 1 (1 power)
	}

	/**
	 * onHitByBullet: hanh vi thuc hien khi robot trung dan tu ke dich
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(50); // lui 20px
		turnLeft(90); // xoay robot 90 do;
	}
	
	/**
	 * onHitWall: hanh vi thuc hien khi robot cham vao tuong (wall)
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(50); // lui 20px
		turnLeft(90); // xoay robot 90 do;
		ahead(40); // tien 40px
	}
	
	/**
	 * onBulletMissed: hanh vi thuc hien khi robot ban truot
	 */
	public void onBulletMissed(BulletMissedEvent e) {
		// Replace the next line with any behavior you would like		
		turnLeft(90); // xoay robot 90 do;
		ahead(30); // tien 30px
	}	
	
	/**
	 * onHitRobot: hanh vi thuc hien khi robot cham vao mot robot khac (bao gom ke dich hoac dong doi)
	 */
	public void onHitRobot(HitRobotEvent e) {
		// Replace the next line with any behavior you would like
		turnGunRight(360); // xoay thap sung 360 do
		back(20); // lui 20px
		turnLeft(90); // xoay robot 90 do;
		ahead(50); // tien 50px
	}	
	
	/**
	 * onBulletHit: hanh vi thuc hien khi ban trung ke dich
	 */
	public void onBulletHit(BulletHitEvent e) {
		// Replace the next line with any behavior you would like		
		turnLeft(90); // xoay robot 90 do;
		back(20); // lui 20px
	}	
}
