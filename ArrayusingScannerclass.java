package ARRAYSPROGRAMM;

import java.util.Scanner;

public class ArrayusingScannerclass {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int[]arr=new int[5];
	System.out.println("DEFAULT VALUE OF ARRAY IS: ");
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
	}
	System.out.println();
	System.out.println("ENTER "+arr.length+"INTEGER VALUES ");
	for(int i=0;i<arr.length;i++) {
		arr[i]=sc.nextInt();
		}
	System.out.println();
	System.out.println("ARRAYS ELEMENTS ARE: ");
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[i]);
	}
 }
}
