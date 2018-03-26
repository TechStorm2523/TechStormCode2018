package pathFinding;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Obstacle {
		Point2D.Double[] points;
		Line2D.Double[] lines;
	public Obstacle(Point2D.Double bl, Point2D.Double br, Point2D.Double tl, Point2D.Double tr) {
		
		//Key: 0 = bottom left, 1 = bottom right, 2 = top right, 3 = top left
		//Basically counter-clockwise starting at bottom left
		points = new Point2D.Double[4];
		lines = new Line2D.Double[4];
		//Key: 0 = horizBot, 1 = vertRight, 2 = horizTop, 3 = vertLeft
		//Basically counter-clockwise starting at bottom left.
		
		
		pf = new PathfinderPoint2D();
		
		botLeft = bl;
		botRight = br;
		topLeft = tl;
		topRight = tr;
		
		
		
		vertLeft = new Line2D.Double(botLeft, topLeft);
		vertRight =  new Line2D.Double(botRight, topRight);
		
		horizBot =  new Line2D.Double(botLeft, botRight);
		horizTop =  new Line2D.Double(topLeft, topRight);
		
		diagPos = new Line2D.Double(botLeft, topRight);
		diagNeg = new Line2D.Double(topLeft, botRight);
		
		center = new Point2D.Double(pf.getXofIntersect(diagPos,diagNeg),pf.getYofIntersect(diagPos,diagNeg));
		
		points[0] = botLeft;
		points[1] = botRight;
		points[2] = topRight;
		points[3] = topLeft;
		
		lines[0] = horizBot;
		lines[1] = vertRight;
		lines[2] = horizTop;
		lines[3] = vertLeft;
		
	}
	
	
	PathfinderPoint2D pf;
	
	private Point2D.Double center;
	
	private Point2D.Double botLeft;
	private Point2D.Double botRight;
	
	private Point2D.Double topLeft;
	private Point2D.Double topRight;
	
	private Line2D.Double vertLeft;
	private Line2D.Double vertRight;
	
	private Line2D.Double horizBot;
	private Line2D.Double horizTop;
	
	private Line2D.Double diagPos;
	private Line2D.Double diagNeg;
	
	public Line2D.Double getDiagPos(){
		return diagPos;
	}
	
	public Line2D.Double getDiagNeg(){
		return diagNeg;
	}
	
	
	public Point2D.Double getCenter(){
		return center;
	}
	
	public Point2D.Double getBL(){
		return botLeft;
	}
	
	public Point2D.Double getBR(){
		return botRight;
	}
	
	public Point2D.Double getTL(){
		return topLeft;
	}
	
	public Point2D.Double getTR(){
		return topRight;
	}
	
	
	public Line2D.Double getVL(){
		return vertLeft;
	}
	
	public Line2D.Double getVR(){
		return vertRight;
	}
	
	public Line2D.Double getHB(){
		return horizBot;
	}
	
	public Line2D.Double getHT(){
		return horizTop;
	}
	
	//Returns the index of the 
	public int checkIntersects(Line2D.Double path){
		for(int i = 0; i<4; i++) {
			if(path.intersectsLine(lines[i]))
				return i;
		}
			
		return -1;
	}
	

}
