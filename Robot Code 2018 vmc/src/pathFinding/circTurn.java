package pathFinding;

public class circTurn extends PathObj {
	double divisor;
	double outSideDist;
	double inSideDist;
	public circTurn(double a, double t) {
		setTime(t);
		divisor = 360/a;
		
		outSideDist = (2*(Math.PI)*SAFE_DIST)/divisor;
		inSideDist = (2*(Math.PI)*SAFE_DIST-CENT_TO_CENT)/divisor;
		
		if(a<0) {
			setDL(inSideDist);
			setDR(outSideDist);
		} else if(a>0) {
			setDR(inSideDist);
			setDL(outSideDist);
		} else {
			System.out.println("Cannot be 0 angle. Use straightLine instead.");
		}
		
		calcVfromDT();
		
		
	}
	
	
}
