package classes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EpicJ
 */
import java.awt.geom.*;

public class LinearPath {
   Point2D.Double orig;
   Point2D.Double goal;
   Line2D.Double path;
   
    public LinearPath(Point2D.Double origin, Point2D.Double goalPoint){ //Might be issues with type?
        orig = origin;
        goal = goalPoint;
        path = new Line2D.Double(orig,goal);
        
    }
    public double length(){
        return orig.distance(goal);
    }
    
}
