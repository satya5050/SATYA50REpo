package ARRAYSPROGRAMM;

import java.util.Arrays;

public class ArrayReverse {
public static void main(String[] args) {
	int []arr= {23,5,6,5,4,3,6};
	System.out.println("ORIGIONAL ARRAY ELIMENT IS: ");
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]+" ");
	}
	System.out.println();
	System.out.println();
	System.out.print("REVERSED ARRAY ELIMENT IS: ");
	for(int i=arr.length-1;i>=0;i--){
		System.out.print(arr[i]+" ");
	}
	
  }
}
