package ass_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
		
		ArrayList<Student> vt = new ArrayList<Student>();
		HashMap<String,Student> hs = new HashMap<String,Student>(); 
		for (int i = 0; i < 4; i++) {
			System.out.print(">>");
			Student a = new Student(scanner.nextLine());
			vt.add(a); 
			hs.put(a.pop(),a);
			
		}
		System.out.println("----------------------------");
		for (int i = 0; i < vt.size(); i++) {
			vt.get(i).Show();
		}

		String tmp;
		String temp;
		for (;;) {
			System.out.print("학생이름 >>");
			tmp = scanner.next();
			if (tmp.equals("그만"))
				break;
			if(hs.containsKey(tmp) == false) {
				System.out.println("없는 사람");
			}
			else {
			System.out.println(hs.get(tmp).aa);
			}

		}
		System.out.println("종료합니다.");
	}

}