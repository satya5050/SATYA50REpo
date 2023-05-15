package LOGICAL_PROGRAMMING;

public class FIBBONACISERIES {
	public static void main(String[] args) {
		int a=0;int b=1;int c;
		System.out.print("FIBBONACCI SERIES ARE: ");
		for(int i=1;i<10;i++){
			System.out.print(a+" ");
			c=a+b;
			a=b;
			b=c;
		}
	}

}
