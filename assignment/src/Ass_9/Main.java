package Ass_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> hs = new HashMap<String,Integer>();
		ArrayList<String> li = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		String name;
		int point;
		boolean flg = false;
		System.out.println("** ����Ʈ ���� ���α׷��Դϴ� **");
		for(;;) {
			System.out.print("�̸��� ����Ʈ �Է� >>");
			name = scanner.next();
			if(name.equals("�׸�")) break;
			point = scanner.nextInt();
			
			flg = hs.containsKey(name);
			if(!flg) {
				li.add(name);
				hs.put(name, point);
			}

			
			if(flg==false) {
				for(int i=0;li.size()> i ;i++) {
					System.out.print("(");
					System.out.print(li.get(i));
					System.out.print(",");
					System.out.print(hs.get(li.get(i)));
					System.out.print(")");
				}
			}
			else {
				hs.replace(name, hs.get(name)+point);
				for(int i=0;li.size()> i ;i++) {
					System.out.print("(");
					System.out.print(li.get(i));
					System.out.print(",");
					System.out.print(hs.get(li.get(i)));
					System.out.print(")");
				}
			}
			System.out.println();
			
			
		}
		

	}

}
