package classes;
/**
 * 6pi
 * 
 * @author FIRST
 *
 */
public class pivotTurn extends PathObj{
	double angle = 0;
	double turnFrac = 0;
	double inches;
	public pivotTurn(double a, double t) {
		setTime(t);
		angle = a;
		turnFrac = a*(1/96);
		inches = (WHEEL_DIAMETER*Math.PI)*turnFrac;
		setDR(encPulseForIn(inches));
		setDL(encPulseForIn(inches));
		calcVfromDT();
		
		
		
	}
}
