package deprecated;
import java.io.*;
public class Pathfinder {
	//This method takes two cartesean coordinate points, the robot and the goal, and the original heading of the robot.
	//the output of this method is the change in angle from the original heading to the goal heading.
	
        
    
        public double angleGivenXYa(double xo, double yo, double xg, double yg, double a) {
		
		double deltaY = xg - xo;
		double deltaX = yg - yo;
		double output = 0;
		
		if(deltaX > 0) {
			output = Math.atan(deltaY/deltaX)-a;
		}
		
		else if(deltaX < 0) {
			output = 180+Math.atan(deltaY/deltaX)-a;
		}
		
		else if(deltaX == 0) {
			if(deltaY > 0) {
				output = 90-a;
			} else if (deltaY < 0) {
				output = 270-a;
			}
		}
		
		return output;
	}
	//This method assumes the angle is already right. use the above method to accomplish that.
	public double distanceGivenXY(double xo, double yo, double xg, double yg ) {
		double deltaY = xg - xo;
		double deltaX = yg - yo;
		
		return Math.sqrt(deltaY*deltaY + deltaX*deltaX);
		
	}
	
}
