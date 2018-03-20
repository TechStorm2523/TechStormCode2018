//package pathFinding;
//
//import java.awt.geom.Line2D;
//import java.awt.geom.Point2D;
//
//public class testRunner {
//	public static void main(String[] args) {
//	PathfinderPoint2D pf = new PathfinderPoint2D();
//	Point2D.Double test1 = new Point2D.Double(10,12);
//	Point2D.Double test2 = new Point2D.Double(10,12);
//	
//	Line2D.Double l1 = new Line2D.Double(0,0,2,2);
//	Line2D.Double l2 = new Line2D.Double(1,0,1,3);
//	Line2D.Double l4 = new Line2D.Double(0,0,100,0);
//	Line2D.Double l5 = new Line2D.Double(90, -10, 90, 10);
//	
//	Point2D.Double inter = new Point2D.Double(pf.getXofIntersect(l1, l2), pf.getYofIntersect(l1, l2));
//	
//	System.out.println(inter);
//	Line2D.Double l3 = pf.lineOnSlopeForDistance(l1, 3*Math.sqrt(2));
//	System.out.println(pf.getDeltaXForArc(90, 45));
//	System.out.println(pf.getDeltaYForArc(90, 45));
//	System.out.println(l3.getP1());
//	System.out.println(l3.getP2());
//	Point2D.Double p1 = pf.safePlace(l4, l5);
//	System.out.println(p1);
//	Line2D.Double l6 = pf.safeLine(0, new Point2D.Double(0, 0), new Point2D.Double(100, 0), l5);
//	System.out.println(l6.getP1());
//	System.out.println(l6.getP2());
//	
//	}
//
//}
