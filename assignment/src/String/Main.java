package String;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		String temp = scanner.nextLine();
		String tmp_1,tmp_2;
		for (;;) {
			System.out.print("���:");
			String tmp = scanner.nextLine();
			if(tmp.compareTo("�׸�")==0) break;
			StringTokenizer st = new StringTokenizer(tmp, "!");
			tmp_1 = st.nextToken();
			if(false == temp.contains(tmp_1)) {
				System.out.println("ã�� �� �����ϴ�!");
				continue;
			}
			tmp_2 = st.nextToken();
			if(tmp_1.compareTo(" ")==0) {
				System.out.println("�߸��� ����Դϴ�!");
				continue;
			}
			temp = temp.replace(tmp_1,tmp_2);
			System.out.println(temp);
			
		}
		System.out.println("�����մϴ�");

	}

}
