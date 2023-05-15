package LOGICAL_PROGRAMMING;

public class AMSTRONG_NUMBER {
	public static void main(String[] args) {
		int ams=0;
		int n=153;
		int lsd;
		int temp=n;
		while(n>0) {
			lsd=n%10;
			ams=ams+lsd*lsd*lsd;
			n=n/10;
		}
		if(ams==temp) {
			System.out.println("IT IS A AMSTRONG NUMBER");
		}
		else {
			System.out.println("IT IS NOT A AMSTRONG NUMBER");
		}
	}

}
