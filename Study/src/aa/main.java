package aa;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class main {
	
	public static void printfPoint(Vector<Point> vt) {
		for(int i=0;i<vt.size();i++) {
			System.out.println(vt.get(i).toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int tmp;
		int max=0;
		String max_s=null;
		String tmp_s=null;
		Vector<String> vt = new Vector<String>();
		vt.add("aaa");
		vt.add("bb");
		vt.add("c");
		Iterator<String> it = vt.iterator();
		while(it.hasNext()) {
			tmp_s = it.next();
			tmp = tmp_s.length();
			if (tmp > max) {
				max = tmp;
				max_s = tmp_s;
			}
		}
		System.out.println(max_s);
	}
}