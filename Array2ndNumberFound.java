package ARRAYSPROGRAMM;

import java.util.Arrays;

public class Array2ndNumberFound {
	public static void main(String[] args) {
		int[]arr= {2,4,5,6,7,8};
		int []arr1= {3,4,5,6,67,8};
		int[] merge=new int[arr.length+arr1.length];
	for(int i=0;i<arr.length;i++) {
		merge[i]=arr[i];
	  }
	System.out.println(Arrays.toString(arr));
	 for(int i=0,j=arr.length;j<(arr.length + arr1.length);i++,j++ ){
       merge[j] = arr1[i];
	}
	 System.out.println(Arrays.toString(arr1));
	 System.out.println(Arrays.toString(merge));
	}
}
