package pathFinding;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class testRunner {
	public static void main(String[] args) {
	PathfinderPoint2D pf = new PathfinderPoint2D();
	Point2D.Double test1 = new Point2D.Double(10,12);
	Point2D.Double test2 = new Point2D.Double(10,12);
	
	Line2D.Double l2 = new Line2D.Double(0,0,1,0);
	Line2D.Double l1 = new Line2D.Double(0,2,1,23);
	
	System.out.println(pf.getXofIntersect(l1,l2));
	System.out.println(pf.getYofIntersect(l1,l2));
	
	Point2D.Double test = new Point2D.Double(pf.getXofIntersect(l1, l2), pf.getYofIntersect(l1, l2));
	System.out.println(test);
	
	}

}
