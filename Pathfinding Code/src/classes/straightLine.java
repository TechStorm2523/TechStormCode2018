package classes;

public class straightLine extends PathObj {

	public straightLine(double dR, double dL, double vR, double vL, double tI) { //Contstructor w/ all params
		setDR(dR);
		setDL(dL);
		setVR(vR);
		setVL(vL);
		setTime(tI);
		
	}
	
	public straightLine(double dR, double dL, double tI) { //Contstructor w/ distance and time
		setDR(dR);
		setDL(dL);
		setTime(tI);
		calcVfromDT();
		
	}
	
}
