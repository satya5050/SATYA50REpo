package LOGICAL_PROGRAMMING;

import java.util.Scanner;

public class Factors_of_a_number {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER A NUMBER YOU REQUIRED: ");
		int n=sc.nextInt();
		System.out.println(n+ ""+" FACTORS ARE: ");
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				System.out.print(i+" ");
			}
		}
	}

}
