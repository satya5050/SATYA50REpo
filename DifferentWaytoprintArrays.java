package ARRAYSPROGRAMM;
import java.util.Arrays;
public class DifferentWaytoprintArrays {
	public static void main(String[] args) {
		int []arr= {1,3,4,5,6,6,7,8};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
		}
		System.out.println();
		for(int i: arr) {
			System.out.println(i+" ");
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));
	}

}
