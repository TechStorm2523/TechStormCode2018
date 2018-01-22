package classes;
import java.io.*;
import java.util.ArrayList;
import java.awt.geom.*;
public class PathfinderPoint2D{
	// m= (y2-y1)/(x2-x1)
	// y= mx + (y1-(m*x1)
	//DeltaX = -rSin(theta - pi/2 + startAngle)
	//DeltaY = rCos(theta - pi/2 + startAngle)
	double y1a, y2a, x1a, x2a, y1b, y2b, x1b, x2b;
	double mA, mB;
	double bA, bB;
	final double SAFE_DIST = 5;
	boolean positiveLast = false;
	
	
	//Checks for an intersection with an obstacle and returns the index in the array of said obstacle. 
        public int checkObsInts(ArrayList<Line2D.Double> a, Line2D.Double path) {
        	for(Line2D.Double line : a) {
        		if(path.intersectsLine(line)) {
        			return a.indexOf(line);
        		}
        		
        	}
        		
        	return 0;
        }
        
    //Returns the X of the intersection of two lines.
        public double getXofIntersect(Line2D.Double l1, Line2D.Double l2) {
        	y1a = l1.getY1();
        	y2a = l1.getY2();
        	x1a = l1.getX1();
        	x2a = l1.getX2();
        	y1b = l2.getY1();
        	y2b = l2.getY2();
        	x1b = l2.getX1();
        	x2b = l2.getX2();
        	mA = (y2a - y1a)/(x2a - x1a);
        	mB = (y2b - y1b)/(x2b - x1b);
        	bA = y1a - (mA*x1a);
        	bB = y1b - (mB*x1b);
        	
        	return (bB-bA)*(mA-mB);
        	
        }
        
     //Returns the Y of the intersection of two lines. 
        public double getYofIntersect(Line2D.Double l1, Line2D.Double l2) {
        	double xCoord = getXofIntersect(l1,l2);
        	
        	return mA*(xCoord) + bA;
        	
        	
        	
        }
        
     //Returns the delta x to step along a circular arc given radius 1 and angle theta
        public double getDeltaXForArc(double startAngle, double theta) {
        	//DeltaX = -rSin(theta - pi/2 + startAngle)
        	return -Math.toDegrees(Math.sin(Math.toRadians(theta - 90 + startAngle)));
        }
        
        
     //Returns the delta y to step along a circular arc given radius 1 and angle theta
        public double getDeltaYForArc(double startAngle, double theta) {
        	//DeltaY = rCos(theta - pi/2 + startAngle)
        	return Math.toDegrees(Math.cos(Math.toRadians(theta - 90 + startAngle)));
        }
        
     //Returns a new line which is on the same slope as the given line, but with an adjusted distance.
        public Line2D.Double lineOnSlopeForDistance(Line2D.Double path, double distance) {
        	double theta = angleFromLine(path, 0);
        	double xStep = distance*(Math.cos(theta));
        	double yStep = distance*(Math.sin(theta));
        	
        	Line2D.Double newPath = new Line2D.Double(path.getP1(), new Point2D.Double(path.getX1() + xStep, path.getY1() + yStep));
        	return newPath;
        }
        
     //Returns a new Point2D in double precision which is a specified safe distance back from an obs intersect.
        public Point2D.Double safePlace(Line2D.Double path, Line2D.Double obs){
        	
        	double theta = angleFromLine(path, 0);
        	double xStepBack = SAFE_DIST*(Math.cos(theta));
        	double yStepBack = SAFE_DIST*(Math.sin(theta));
        	
        	return new Point2D.Double(getXofIntersect(path, obs)-xStepBack, getYofIntersect(path, obs)-yStepBack);
        }
        
        
     //Returns a new Line2D which is the line which most efficiently avoids an obstacle.
        public Line2D.Double safeLine(double OrigTheta, Point2D.Double origin, Point2D.Double goalCopy, Line2D.Double obs){
			int thetaWorking = 0;
			
        	
        	Line2D.Double safeLineLong = new Line2D.Double(origin, goalCopy);
        	Line2D.Double safeLine = lineOnSlopeForDistance(new Line2D.Double(origin, goalCopy), 1);
			
        	Point2D.Double intersect = new Point2D.Double(getXofIntersect(safeLine, obs), getYofIntersect(safeLine, obs));
        	
        	safeLine.setLine(origin, new Point2D.Double(safeLine.getX2() + getDeltaXForArc(OrigTheta, 1), safeLine.getY2() + getDeltaYForArc(OrigTheta, 1)) );
			safeLineLong.setLine(lineOnSlopeForDistance(safeLine, Double.MAX_VALUE));
			//DeltaX = -rSin(theta - pi/2 + OrigTheta)
			//DeltaY = rCos(theta - pi/2 + startAngle)
			
        	
        	return null;
			
        	
        	
        }
        
        
    //Returns the angle of a line from the x axis or a specified original angle.
        public double angleFromOG(Point2D origin, Point2D goal, double a) {
		
        	double deltaY = goal.getY() - origin.getY();
        	double deltaX = goal.getX() - origin.getX();
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
    //Alternate header for angleFromOG()
        public double angleFromLine(Line2D.Double line, double a) {
        	return angleFromOG(line.getP1(),line.getP2(),a);
        }
	
   //This method assumes the angle is already right. use the above method to accomplish that.
        public double distanceToGo(Point2D origin, Point2D goal ) {
        	return origin.distance(goal);
        }
	
}
