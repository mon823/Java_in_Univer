package aa;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class aaaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		LinkedList<String> vt = new LinkedList<String>();
		vt.add("apple");
		vt.add("사과");
		vt.add("영어");
		Collections.sort(vt);
		for(int i=0;i<vt.size();i++)
			System.out.println(vt.get(i));
		System.out.println(Collections.max(vt));
	}
}