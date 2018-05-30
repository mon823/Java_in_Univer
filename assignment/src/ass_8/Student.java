package ass_8;

import java.util.StringTokenizer;

public class Student {

	String name;
	String ma;
	String id;
	String aver;
	String aa;

	Student(String str) {
		aa = str;
		StringTokenizer st = new StringTokenizer(str, ", ");
		this.name = st.nextToken();
		this.ma = st.nextToken();
		this.id = st.nextToken();
		this.aver = st.nextToken();
	}
	
	String pop() {
		
		return this.name;
	}

	void Show() {
		System.out.print("이름 : ");
		System.out.println(this.name);
		System.out.print("학과 : ");
		System.out.println(this.ma);
		System.out.print("학번 : ");
		System.out.println(this.id);
		System.out.print("학점평균 : ");
		System.out.println(this.aver);
		System.out.println("----------------------------");
	}

}
