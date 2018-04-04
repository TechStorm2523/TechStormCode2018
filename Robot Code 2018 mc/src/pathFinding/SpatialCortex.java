//package pathFinding;
//
//import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//
//public class SpatialCortex {
//	/**
//	 * The heart and soul of the pathfinding system, this class is the one that uses the others.
//	 * General Overview:
//	 * 	-Setup
//	 * 		-Instantiate things
//	 * 		-Read in goal list from smartDash
//	 * 	-Per Goal Loop
//	 * 		-Draw birds-eye line
//	 * 		-Get first obstacle intersect
//	 * 		-Dodge by swinging out towards shortest side
//	 * 		-Find closest point along that line that can "see" goal
//	 * 		-Repeat for each obstacle, committing each line to an arrayList
//	 *  -Repeat Per Goal In List
//	 *  
//	 *  -Processing steps
//	 *  	-Shorten lines at intersects to account for circular turns.
//	 *  	-Transform into proprietary line types designed for use with robot motors.
//	 *  	-Add arc turns
//	 *  	-Add actions
//	 *  
//	 *  -Feed completed map into drive system, and use encoders and things to follow it.
//	 *  
//	 *  -Notes:
//	 *  	If enabled, distance sensors mounted on the front of the robot can register the presence
//	 *  	of an UnPlAnNeD ObStAcLe such as ally or enemy robots, add it to the map with an
//	 *  	estimated size and position, and run the above processes again from the new start point.
//	 *  	
//	 *  	Also, this system works best with convex obstacles. Concavity can lead to infinite back-and-forth
//	 *  	motion when the system pathfinds around them. This should be fixed in a later version, but for
//	 *  	now just define all obstacles in the math with a convex bounding box.
//	 *  
//	 *  	Also Also, most of the code here is in the constructor for this class, which might seem a little
//	 *  	odd, but this is so you 
//	 * 		
//	 */
//	
//		
//		public SpatialCortex(String[] goalList, String StartPos, boolean usingDistanceSensors) {
//			
//			//Setup
//			PathMap pm = new PathMap(goalList);
//			FieldMap fm = new FieldMap();
//			PathfinderPoint2D pf2d = new PathfinderPoint2D();
//			int goalCount = 0;
//			boolean clear = false;
//			Point2D.Double initPoint = fm.goals.get(StartPos);
//			Point2D.Double frontier = initPoint;
//			Point2D.Double goalPoint;
//			Line2D.Double current;
//			Line2D.Double problem;
//			
//			
//			
//			
//			//Outer loop (per goal)
//			while(pm.goalsLeft >0) {
//				goalPoint = fm.goals.get(goalList[goalCount]);
//				
//				if(pf2d.checkObsInts(fm.obs, new Line2D.Double(initPoint, goalPoint)).equals(null)) {
//					clear = true;
//				}
//				//Inner loop (per obstacle)
//				while(!clear) {//While a line cannot be drawn from origin to goal without hitting an obstacle
//					
//					current = new Line2D.Double(frontier,goalPoint); //set current
//					
//					if(pf2d.checkObsInts(fm.obs, current).equals(null)) { //If there is no obstacle
//						clear = true; //update clear
//					} else {
//						problem = pf2d.checkObsInts(fm.obs, current); /// get the offending line
//						
//						current = new Line2D.Double(frontier, pf2d.safePlace(current,problem)); //step back
//						
//						pm.putLine(current); //Commit line
//						
//						current = new Line2D.Double(pf2d.safeLine(0, origin, goalCopy, obs));
//						
//					}
//					
//				}
//				//Add action at goal
//				pm.goalsLeft--;
//				goalCount++;
//			}
//			
//			
//			//Shorten lines at intersects, excluding beginning and end of path
//			
//			
//			
//			//Process lines to proprietary types
//			
//			
//			
//			//Add arc turns to proprietary line array			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//		}
//		
//		
//	}
//	
//
//
