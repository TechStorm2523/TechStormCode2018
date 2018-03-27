package pathFinding;

public class pathAction extends PathObj {
	String system;
	double target;
	
	public pathAction(String sys, double tar) {
		system = sys;
		target = tar;
		
		
		
	}
	public double getTarget() {
		
		return target;
		
	}
	public String getSystem() {
		
		return system;
	}
}
