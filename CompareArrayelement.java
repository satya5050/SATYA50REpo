package ARRAYSPROGRAMM;

import java.util.Scanner;

public class CompareArrayelement {
	public static void main(String[] args) {
		int[]arr1= {10,20,30,40,50};
		int arr2[]=arr1;
		int[]arr3= {10,20,30,40,50};
		int[]arr4= {30,40,50,60,20};
		if(arr1==arr2) {
			System.out.println("ARRAY1 & ARRAY2 ARE SAME");
		}
		else {
			System.out.println("ARRAY1 & ARRAY2 ARE NOT SAME");
		}
		if(arr1==arr3) {
			System.out.println("ARRAY1 & ARRAY3 ARE SAME");
		}
		else {
			System.out.println("ARRAY1 & ARRAY3 ARE NOT SAME");
		}
		if(arr1==arr4) {
			System.out.println("ARRAY2 & ARRAY3 ARE SAME");
		}
		else {
          System.out.println("ARRAY2 & ARRAY3 ARE NOT SAME");
		}
	}

}
