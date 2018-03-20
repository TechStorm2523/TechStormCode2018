//package pathFinding;
//
//import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//import java.util.HashMap;
//import java.util.Map;
//
//public class FieldMap {
//	Map<String, Point2D.Double> goals;
//	Map<String, Obstacle> obs;
//	
//	public FieldMap() {
//		goals = new HashMap<>();
//		obs = new HashMap<>();
//		Point2D.Double value = null;//Placeholder TODO: replace
//		
//		/**
//		 * 
//		 * To use this, use 'goals.put("GOALNAME", new Point2D.Double(GOALX, GOALY);'
//		 * to put point into the goal map, and 'obs.put("OBSTACLENAME", new Line2D.Double(x1,y1,x2,y2);'
//		 * to add new obstacles. Goals are points, and obstacles are single lines, so you need 4 obstacle lines
//		 * for a rectangular obstacle. Try to avoid concave obstacles, as that can cause unintended behavior.
//		 *
//		 */
//		goals.put("ally 1", value);
//		goals.put("ally 2", value);
//		goals.put("ally 3", value);
//		goals.put("ally exchange", value);
//		goals.put("ally cube pile", value);
//		goals.put("ally switch L", value);
//		goals.put("ally switch R", value);
//		goals.put("ally cube line 1", value);
//		goals.put("ally cube line 2", value);
//		goals.put("ally cube line 3", value);
//		goals.put("ally cube line 4", value);
//		goals.put("ally cube line 5", value);
//		goals.put("ally cube line 6", value);
//		goals.put("scale L", value);
//		goals.put("scale R", value);
//		goals.put("opp 1", value);
//		goals.put("opp 2", value);
//		goals.put("opp 3", value);
//		goals.put("opp exchange", value);
//		goals.put("opp cube pile", value);
//		goals.put("opp switch L", value);
//		goals.put("opp switch R", value);
//		goals.put("opp cube line 1", value);
//		goals.put("opp cube line 2", value);
//		goals.put("opp cube line 3", value);
//		goals.put("opp cube line 4", value);
//		goals.put("opp cube line 5", value);
//		goals.put("opp cube line 6", value);
//		
//		goals.put("ally portal L", value);
//		goals.put("ally portal R", value);
//		goals.put("opp portal L", value);
//		goals.put("opp portal R", value);
//		
//		
//		obs.put("ally pile bottom", null);
//		obs.put("ally pile left", null);
//		obs.put("ally pile right", null);
//		obs.put("ally pile top", null);
//		
//		obs.put("ally switch bottom", null);
//		obs.put("ally switch left", null);
//		obs.put("ally switch right", null);
//		obs.put("ally switch top", null);
//		
//		obs.put("scale bottom", null);
//		obs.put("scale left", null);
//		obs.put("scale right", null);
//		obs.put("scale top", null);
//		
//		obs.put("opp switch bottom", null);
//		obs.put("opp switch left", null);
//		obs.put("opp switch right", null);
//		obs.put("opp switch top", null);
//		
//		obs.put("opp pile bottom", null);
//		obs.put("opp pile left", null);
//		obs.put("opp pile right", null);
//		obs.put("opp pile top", null);
//		
//		
//		
//		
//		
//		
//		
//	}
//	
//}
