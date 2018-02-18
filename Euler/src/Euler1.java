
public class Euler1 {
	public static void main(String[] args) {
		int total = 0;
		int current = 0;
		while(current<1000) {
			if(current%3==0 || current%5==0) {
				total = total+current;
			}
			current++;
		}
		System.out.println(total);
	}
}
