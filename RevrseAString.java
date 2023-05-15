package LOGICAL_PROGRAMMING;
import java.util.Scanner;

public class RevrseAString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER A STRING: ");
		String s=sc.nextLine();
		String reverseStr="";
		int len=s.length();
		for(int i=len-1;i>=0;i--) {
			reverseStr=reverseStr+s.charAt(i);
		}
		System.out.println("REVERSE OF THE STRING IS : "+reverseStr);
	}

}
