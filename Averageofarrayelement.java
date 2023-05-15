package ARRAYSPROGRAMM;

import java.util.Scanner;

public class Averageofarrayelement {
	public static void main(String[] args) {
		int avg=0;
		int arr[]=new int[6];
		int sum=0;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
		System.out.print("ENTER "+i+" INDEX OF ARRAY ELEMENT: ");
		arr[i]=sc.nextInt();
		sum=sum+arr[i];
		avg=sum/arr.length;
		}
		System.out.println("AVERAGE OF ARRAY ELEMENT IS: "+avg);
	}

}
