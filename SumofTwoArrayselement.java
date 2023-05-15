package ARRAYSPROGRAMM;

import java.util.Arrays;
import java.util.Scanner;

public class SumofTwoArrayselement {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("ENETR THE SIZE OF 1ST ARRAY: ");
		int array1size=sc.nextInt();
		System.out.print("ENTER THE  SIZE OF THE SECOND ARRAY: ");
		int array2size=sc.nextInt();
		if(array1size!=array2size) {
			System.out.println("BOTH ARRAY MUST HAVE SAME ELEMENTS");
			return;
		}
		int []arr1=new int[array1size];
		int []arr2=new int[array1size];
		int []arr3=new int[array1size];
		System.out.println("ENTER 1ST ARRAY ELEMENT :");
		System.out.println("==========================");
		for(int i=0;i<arr1.length;i++) {
			System.out.print("ENTER "+i+" NO INDEX: ");
			arr1[i]=sc.nextInt();
		}
		System.out.println("ENTER 2ND ARRAY ELEMENT: ");
		System.out.println("===========================");
		for(int i=0;i<arr2.length;i++) {
			System.out.print("ENTER "+i+" NO INDEX: ");
			arr2[i]=sc.nextInt();
		}
		for(int i=0;i<arr3.length;i++) {
			arr3[i]=arr1[i]+arr2[i];
		}
		System.out.println("RESULT OF SUM OF ARRAY OF TWO ELEMENTS IS : "+Arrays.toString(arr3));
	}

}
