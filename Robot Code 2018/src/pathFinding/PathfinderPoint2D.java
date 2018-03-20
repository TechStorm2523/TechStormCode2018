//package pathFinding;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.awt.geom.*;
//import java.awt.geom.Line2D.Double;
//public class PathfinderPoint2D{
//	// m= (y2-y1)/(x2-x1)
//	// y= mx + (y1-(m*x1)
//	//DeltaX = -rSin(theta - pi/2 + startAngle)
//	//DeltaY = rCos(theta - pi/2 + startAngle)
//	double y1a, y2a, x1a, x2a, y1b, y2b, x1b, x2b;
//	double mA, mB;
//	double bA, bB;
//	final double SAFE_DIST = 5;
//	boolean positiveLast = false;
//
//
//	
//	public Line2D.Double checkObsInts(Map<String, Obstacle> obs, Line2D.Double path){
//		Obstacle temp;
//		String key;
//		List<String> keysIntersect = new ArrayList<String>();
//		
//		for(Map.Entry<String, Obstacle> mapEntry : obs.entrySet()) {
//			temp = mapEntry.getValue();
//			key = mapEntry.getKey();
//			
//			if(path.intersectsLine(temp.getHB()) || path.intersectsLine(temp.getHT()) || path.intersectsLine(temp.getVL()) || path.intersectsLine(temp.getVR()))
//			
//			
//		}
//		/**
//		 * Procedure
//		 * 
//		 * run through array of obstacles, getting keys and storing in array, until no more intersections found
//		 *  
//		 * compare center distances to get closest one
//		 * 
//		 * return that one
//		 */
//		
//		return null;
//	}
//	
//	//Checks for an intersection with an obstacle and returns the index in the array of said obstacle. 
//	public Line2D.Double checkObsIntsOLD(Map<String, Double> obs, Line2D.Double path) {
//		for(Object line : obs.values()) {
//
//			if(path.intersectsLine((Line2D.Double) line)) {
//				return (Line2D.Double) line;
//			}
//
//		}
//
//		return null;
//	}
//
//	//Returns the X of the intersection of two lines.
//	/**
//	 * Works
//	 * @param l1
//	 * @param l2
//	 * @return
//	 */
//	public double getXofIntersect(Line2D.Double l1, Line2D.Double l2) {
//		y1a = l1.getY1();
//		System.out.println(y1a);
//		y2a = l1.getY2();
//		System.out.println(y2a);
//		x1a = l1.getX1();
//		System.out.println(x1a);
//		x2a = l1.getX2();
//		System.out.println(x2a);
//		y1b = l2.getY1();
//		System.out.println(y1b);
//		y2b = l2.getY2();
//		System.out.println(y2b);
//		x1b = l2.getX1();
//		System.out.println(x1b);
//		x2b = l2.getX2();
//		System.out.println(x2b);
//		mA = (y2a - y1a)/(x2a - x1a);
//		System.out.println(mA);
//		mB = (y2b - y1b)/(x2b - x1b);
//		System.out.println(mB);
//		
//		if(java.lang.Double.isInfinite(mA)) { //if line 1 is vertical
//			return l1.getX1();
//			
//		} else if(java.lang.Double.isInfinite(mB)) { //if line 2 is vertical
//			return l2.getX1();
//			
//			
//		} else { //if neither is vertical
//			bA = y1a - (mA*x1a);
//			bB = y1b - (mB*x1b);
//
//			return (bB-bA)*(mA-mB);
//			
//		}
//		
//		}
//
//
//	//Returns the Y of the intersection of two lines. 
//	
//	/**
//	 * Works
//	 * @param l1
//	 * @param l2
//	 * @return
//	 */
//	public double getYofIntersect(Line2D.Double l1, Line2D.Double l2) {
//		double xCoord = getXofIntersect(l1,l2);
//		
//		if(java.lang.Double.isInfinite(mA)) { //if equation A is undfined
//			return (mB*xCoord)+bB; // Use B
//		} else {
//		return mA*(xCoord) + bA; //Use A
//		}
//
//
//
//	}
//
//	//Returns the delta x to step along a circular arc given radius 1 and angle theta
//	/**
//	 * Verified to work
//	 * @param startAngle
//	 * @param theta
//	 * @return
//	 */
//	public double getDeltaXForArc(double startAngle, double theta) {
//		//DeltaX = -rSin(theta - pi/2 + startAngle)
//		return (Math.sin(Math.toRadians(theta - 90 + startAngle)));
//	}
//
//
//	//Returns the delta y to step along a circular arc given radius 1 and angle theta. Takes and returns degrees
//	/**
//	 * Verified to work
//	 * @param startAngle
//	 * @param theta
//	 * @return
//	 */
//	public double getDeltaYForArc(double startAngle, double theta) {
//		//DeltaY = rCos(theta - pi/2 + startAngle)
//		return -(1- ( Math.cos(Math.toRadians(theta - 90 + startAngle))));
//	}
//
//	//Returns a new line which is on the same slope as the given line, but with an adjusted distance.
//	/**
//	 * Verified
//	 * @param path
//	 * @param distance
//	 * @return
//	 */
//	public Line2D.Double lineOnSlopeForDistance(Line2D.Double path, double distance) {
//		double theta = angleFromLine(path, 0);
//		double xStep = distance*(Math.cos(theta));
//		double yStep = distance*(Math.sin(theta));
//
//		Line2D.Double newPath = new Line2D.Double(path.getP1(), new Point2D.Double(path.getX1() + xStep, path.getY1() + yStep));
//		return newPath;
//	}
//
//	//Returns a new Point2D in double precision which is a specified safe distance back from an obs intersect.
//	/**
//	 * Verified
//	 * @param path
//	 * @param obs
//	 * @return
//	 */
//	public Point2D.Double safePlace(Line2D.Double path, Line2D.Double obs){
//
//		double theta = angleFromLine(path, 0);
//		double xStepBack = SAFE_DIST*(Math.cos(theta));
//		double yStepBack = SAFE_DIST*(Math.sin(theta));
//
//		return new Point2D.Double(getXofIntersect(path, obs)-xStepBack, getYofIntersect(path, obs)-yStepBack);
//	}
//	public Line2D.Double safeLine(){
//		
//		/**
//		 * Procedure:
//		 * 
//		 * 
//		 */
//		
//		return null;
//	}
//
//	//Returns a new Line2D which is the line which most efficiently avoids an obstacle.
//	public Line2D.Double safeLineOLD(double OrigTheta, Point2D.Double origin, Point2D.Double goalCopy, Line2D.Double obs){
//		int thetaWorking = 0;
//		int polarization = 0;
//		int thetaBuildUp = 0;
//		Point2D.Double testPoint = new Point2D.Double();
//
//		Line2D.Double safeLineLong = new Line2D.Double(origin, goalCopy);
//		Line2D.Double safeLine = lineOnSlopeForDistance(new Line2D.Double(origin, goalCopy), 1);
//
//		Point2D.Double intersect = new Point2D.Double(getXofIntersect(safeLine, obs), getYofIntersect(safeLine, obs));
//
//		if(intersect.distance(obs.getP1())< intersect.distance(obs.getP2())) {
//
//			testPoint.setLocation(safeLine.getX2()+getDeltaXForArc(OrigTheta, 1), safeLine.getY2()+getDeltaYForArc(OrigTheta, 1));
//			double distAfterAnglePos = testPoint.distance(obs.getP1());
//			testPoint.setLocation(safeLine.getX2()+getDeltaXForArc(OrigTheta, -2), safeLine.getY2()+getDeltaYForArc(OrigTheta, -2));
//			double distAfterAngleNeg = testPoint.distance(obs.getP1());
//			if(distAfterAnglePos<distAfterAngleNeg) {
//				polarization = -1;
//			} else {
//				polarization = 1;
//			}
//			while(safeLineLong.intersectsLine(obs)) {
//
//				testPoint.setLocation(safeLine.getX2()+getDeltaXForArc(OrigTheta+thetaWorking, polarization), safeLine.getY2()+getDeltaYForArc(OrigTheta+thetaWorking, polarization) );
//				thetaWorking += polarization;
//				safeLine.setLine(origin, testPoint);
//				safeLineLong = lineOnSlopeForDistance(safeLine, Integer.MAX_VALUE);
//
//			}
//			return safeLineLong;
//
//		} else if(intersect.distance(obs.getP2())< intersect.distance(obs.getP1())) {
//			testPoint.setLocation(safeLine.getX2()+getDeltaXForArc(OrigTheta, 1), safeLine.getY2()+getDeltaYForArc(OrigTheta, 1));
//			double distAfterAnglePos = testPoint.distance(obs.getP2());
//			testPoint.setLocation(safeLine.getX2()+getDeltaXForArc(OrigTheta, -2), safeLine.getY2()+getDeltaYForArc(OrigTheta, -2));
//			double distAfterAngleNeg = testPoint.distance(obs.getP2());
//			if(distAfterAnglePos<distAfterAngleNeg) {
//				polarization = -1;
//			} else {
//				polarization = 1;
//			}
//			while(safeLineLong.intersectsLine(obs)) {
//
//				testPoint.setLocation(safeLine.getX2()+getDeltaXForArc(OrigTheta+thetaWorking, polarization), safeLine.getY2()+getDeltaYForArc(OrigTheta+thetaWorking, polarization) );
//				thetaWorking += polarization;
//				safeLine.setLine(origin, testPoint);
//				safeLineLong = lineOnSlopeForDistance(safeLine, Integer.MAX_VALUE);
//
//			}
//			return safeLineLong;
//
//
//		} else {
//
//			System.out.println("This'll only run if we get aggregiously unlucky.");
//
//		}
//
//
//
//
//		return null;
//
//
//
//	}
//
//
//	//Returns the angle of a line from the x axis or a specified original angle.
//	/**
//	 * Verified
//	 * @param origin
//	 * @param goal
//	 * @param a
//	 * @return
//	 */
//	public double angleFromOG(Point2D origin, Point2D goal, double a) {
//
//		double deltaY = goal.getY() - origin.getY();
//		double deltaX = goal.getX() - origin.getX();
//		double output = 0;
//
//		if(deltaX > 0) {
//			output = Math.atan(deltaY/deltaX)-a;
//		}
//
//		else if(deltaX < 0) {
//			output = 180+Math.atan(deltaY/deltaX)-a;
//		}
//
//		else if(deltaX == 0) {
//			if(deltaY > 0) {
//				output = 90-a;
//			} else if (deltaY < 0) {
//				output = 270-a;
//			}
//		}
//
//		return output;
//	}
//	//Alternate header for angleFromOG()
//	/**
//	 * Verified
//	 * @param line
//	 * @param a
//	 * @return
//	 */
//	public double angleFromLine(Line2D.Double line, double a) {
//		return angleFromOG(line.getP1(),line.getP2(),a);
//	}
//
//	//This method assumes the angle is already right. use the above method to accomplish that.
//	/**
//	 * Verified
//	 * @param origin
//	 * @param goal
//	 * @return
//	 */
//	public double distanceToGo(Point2D origin, Point2D goal ) {
//		return origin.distance(goal);
//	}
//
//}
