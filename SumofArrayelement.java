package ARRAYSPROGRAMM;

import java.util.Scanner;

public class SumofArrayelement {
	public static void main(String[] args) {
		int[]arr=new int[5];
		int sum=0;
		Scanner sc=new Scanner(System.in);
		
		 for(int i=0;i<arr.length;i++) {
			 System.out.print("ENTER "+i+" INDEX OF ARRAY ELEMENT: ");
			 arr[i]=sc.nextInt();
			 sum=sum+arr[i];
		 }
		 System.out.println("SUM OF ARRAY ELEMENT IS : "+sum);
	}

}
