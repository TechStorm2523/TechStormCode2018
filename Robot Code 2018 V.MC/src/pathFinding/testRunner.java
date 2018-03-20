package pathFinding;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class testRunner {
	public static void main(String[] args) {
		Point2D.Double test1 = new Point2D.Double(10, 12);
		PathfinderPoint2D pf = new PathfinderPoint2D();
		
		Line2D.Double l1 = new Line2D.Double(0, 0, 0, 20);
		Line2D.Double l2 = new Line2D.Double(-1, 10, 1, 10);
		Point2D.Double l3 = pf.safePlace(l1, l2);
		System.out.println(pf.angleFromLine(l1, 0));
		System.out.println(l3);
		
		
	}
}
