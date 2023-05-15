package ARRAYSPROGRAMM;

import java.util.Arrays;

public class REVERSEaRRAY {
	public static void main(String[] args) {
	int []arr= {23,24,1,1,2,2,3};
	/*for(int i=arr.length-1;i>=0;i--) {
		System.out.print(arr[i]+"  ");
	//System.out.println(Arrays.toString(arr));	
	}*/
	for(int i=0;i<arr.length/2;i++) {
		int temp=arr[i];
		arr[i]=arr[arr.length-1-i];
		arr[arr.length-1-i]=temp;
	}
	System.out.println(Arrays.toString(arr));
	} 
}
