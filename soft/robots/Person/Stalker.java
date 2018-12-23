package Person;
import robocode.*;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.*;

public class Stalker extends Robot {
int turnDirection = 1; // Clockwise or counterclockwise
double Move;

public void run() {
	// Set colors
	setBodyColor(Color.white);
	Move=Math.max(getBattleFieldWidth(), getBattleFieldHeight());
	while (true) {
		double Smove=Math.random()*Move;
		double Dmove=Math.random()*Move;
		ahead(Smove);
			 turnRight(Dmove);
			 	turnGunRight(360);
		back(Smove);
			 turnLeft(Dmove);
			 turnGunRight(360);
		//set color base on HP
			getEnergy();
    	if(getEnergy()>=90)
	    {
	        setBodyColor(Color.white);
	    }else if(getEnergy()>=40){
	        setBodyColor(Color.gray); 
	    }else if(getEnergy()<40){
	        setBodyColor(Color.black); 
	    }
		turnRight(5 * turnDirection);
		getEnergy();
		if(getEnergy()>=90)
	    {
	        setBodyColor(Color.white);
	    }else if(getEnergy()>=40){
	        setBodyColor(Color.gray); 
	    }else if(getEnergy()<40){
	        setBodyColor(Color.black); 
	    }
	}
}

/**
 * onScannedRobot:  Let's rock !
 */
public void onScannedRobot(ScannedRobotEvent e) {
double distance = e.getDistance();
double Smove=Math.random()*Move;
double Dmove=Math.random()*Move;
	 //get the distance of the scanned robot
	 if(distance > 800) 
    	fire(1);
	 else if(distance > 600 && distance <= 800)
   		 fire(2);
	 else if(distance > 400 && distance <= 600)
  		  fire(2);
	 else if(distance > 200 && distance <= 400)
   		 fire(2);
	 else if(distance < 200)
     	 fire(4);
	 else if(distance <100)
		 fire(5);
     else if(distance <50)
		fire(10);

	//target too close;
		ahead(e.getDistance() + 5);
			if (e.getDistance() < 100) {
		if (e.getBearing() > -90 && e.getBearing() <= 90) {
			back(Smove);
			turnRight(Dmove);
		} else {
			ahead(Smove);
			turnLeft(Dmove);
		}
	}
	scan(); // Might want to move ahead again!
}

public void onHitRobot(HitRobotEvent e) {
	if (e.getBearing() >= 0) {
		turnDirection = 1;
	} else {
		turnDirection = -1;
	}
	turnRight(e.getBearing());
	}
	
 public void onHitWall(HitWallEvent e){
	 double bearing = e.getBearing();
		turnRight(-bearing);
			ahead(100); //The robot goes away from the wall.
}
}