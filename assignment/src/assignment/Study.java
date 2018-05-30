package assignment;

import java.util.Scanner;

public class Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s = new String();
		System.out.println(s.length());
		for(int i=0;i<s.length();i++) {
			System.out.print(s.substring(0,i-1));
			System.out.println(s.substring(i));
			
			
		}	
	}
}
