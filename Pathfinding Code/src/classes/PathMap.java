package classes;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author 2523
 * 
 * This class is used to store the path the robot should take, and also the list of goals the robot should
 * go to. 
 *
 */
public class PathMap {
	
	List<PathObj> motorInstruc;
	List<Line2D.Double> linePath;
	String[] goals;
	public int goalsLeft;
	
	
	public PathMap(String[] goalList) {
		motorInstruc = new ArrayList();
		linePath = new ArrayList();
		goals = goalList;
		goalsLeft = goals.length; //TODO: maybe change by 1
		
		
	}
	
	public void putLine(int index, Line2D.Double line) {
		linePath.add(index, line);
		
	}
	
	public void putLine(Line2D.Double line) {
		
		linePath.add(line);
		
	}
	
	public void dropLine(int i) {
		linePath.remove(linePath.get(i));
		
	}
	public void dropLine() {
		int path;
		if(linePath.size()!=0) {
			path = linePath.size()-1;
		} else {
			path = 0;
		}
			
		linePath.remove(linePath.get( path ));
		
	}


}
