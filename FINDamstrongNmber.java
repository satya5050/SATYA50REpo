package LOGICAL_PROGRAMMING;

import java.util.Scanner;

public class FINDamstrongNmber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER A NUMBER: ");
		int n=sc.nextInt();
		int lsd;
		int temp=n;
		int ams=0;
		while(n>0) {
			lsd=n%10;
			ams=ams+(lsd*lsd*lsd);
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
