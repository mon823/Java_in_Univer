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
		System.out.print("�̸� : ");
		System.out.println(this.name);
		System.out.print("�а� : ");
		System.out.println(this.ma);
		System.out.print("�й� : ");
		System.out.println(this.id);
		System.out.print("������� : ");
		System.out.println(this.aver);
		System.out.println("----------------------------");
	}

}
