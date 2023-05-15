package ARRAYSPROGRAMM;
import java.util.Arrays;
public class Arrayreversenoteliment {
	public static void main(String[] args) {
		int []arr= {23,5,6,5,4,3,6};
		System.out.println("ORIGIONAL ARRAY ELIMENT IS: ");
		for(int i=0;i<arr.length/2;i++){
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
			//System.out.println(Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
	}
}
