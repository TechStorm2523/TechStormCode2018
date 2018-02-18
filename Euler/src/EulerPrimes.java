
public class EulerPrimes {

	public static void main(String[] args) {
		int testing = 0;
		int num = 0;
		boolean flag = false;
		while(num<10001) {
			for(int i = 0; i<testing; i++) {
				if(testing%i==0) {
					flag=true;
				}
			}
			System.out.println(flag);
			if(flag) {
				num++;
			} else {
				flag = false;
			}
		}
		System.out.println(num);
	}
	
	
}
