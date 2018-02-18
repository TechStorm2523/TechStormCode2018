
public class Euler2 {
	
	public static void main(String[] args) {
		int current = 1;
		int prevprev;
		int prev = 0;
		int total = 0;
		while(current<4000000) {
			prev = current;
			prevprev=prev;
			current = prevprev+prev;
			if(current%2==0) {
				total += current;
			}
		}
		System.out.println(current);
		
	}
	
	
	
	
}
