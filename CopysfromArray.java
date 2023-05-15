package ARRAYSPROGRAMM;
import java.util.Arrays;
import java.util.Scanner;

public class CopysfromArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER ARRAYS ELEMENT: "+" ");
		int[]arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		int []arr1=arr;
		System.out.println("ORIGIONAL ARRAY IS: "+Arrays.toString(arr));
        System.out.println("THE COPY OF ARRAY IS : "+Arrays.toString(arr1));
	}
	
}
