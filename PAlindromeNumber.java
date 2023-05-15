package LOGICAL_PROGRAMMING;

import java.util.Scanner;

public class PAlindromeNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER A NUMBER: ");
		int n=sc.nextInt();
		int pal=0;
		int temp=n;
		int ldn;
		while(n>0) {
			ldn=n%10;
			pal=(pal*10)+ldn;
			n=n/10;
		}
		if(temp==pal) {
			System.out.println("IT IS A PALINDROME NUMBER");
		}
		else {
			System.out.println("IT IS NOT A PALINDROME NUMBER");
		}
	}

}
