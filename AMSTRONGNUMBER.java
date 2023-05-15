package LOGICAL_PROGRAMMING;

import java.util.Scanner;

public class AMSTRONGNUMBER {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER A NUMBER");
		int n=sc.nextInt();
		int ldn;
		int temp=n;
		int ams=0;
		while(n>0) {
			ldn=n%10;
			ams=ams+ldn*ldn*ldn;
			n=n/10;
		}
		if(temp==ams) {
			System.out.println("IT IS A AMSTRONG NUMBER");
		}
		else {
			System.out.println("IT IS NOT A AMSTRONG NUMBER");
		}
	}

}
