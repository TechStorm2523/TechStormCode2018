package classes;
/**
 * Superclass for any object that goes in a path; Lines, curves, turns, and actions. Each Path Object
 * consists of velocities for both the left and right wheels, a length of time the move is intended to take,
 * and a distance for each wheel.
 * @param author Jack Luna
 * @param version 0.1
 */
public class PathObj {
	private double velocityLeft;
	private double velocityRight;
	private double distanceLeft; //In encoder pulses
	private double distanceRight; //In encoder pulses
	private double timeIntended;
	protected final double WHEEL_DIAMETER = 6;
	private final double ENCODER_RES = 4096;
	protected final double CENT_TO_CENT = 22.5;
	protected final double SAFE_DIST = 36; //inches
	public double encPulseForIn(double inches) {
		return (inches/(WHEEL_DIAMETER*Math.PI)) * 4096;
	}
	//Getters
	public double getVL() {
		return velocityLeft;
	}
	public double getVR() {
		return velocityLeft;
	}
	public double getDL() {
		return velocityLeft;
	}
	public double getDR() {
		return velocityLeft;
	}
	public double getTime() {
		return timeIntended;
	}
	
	//Setters
	public void setVL(double n) {
		velocityLeft = n;
	}
	public void setVR(double n) {
		velocityLeft = n;
	}
	public void setDL(double n) {
		velocityLeft = n;
	}
	public void setDR(double n) {
		velocityLeft = n;
	}
	public void setTime(double n) {
		timeIntended = n;
	}
	
	public void calcVfromDT() { //Calculates velocity from distance and time;
		velocityLeft = distanceLeft/timeIntended;
		velocityRight = distanceRight/timeIntended;
	}
	
}
