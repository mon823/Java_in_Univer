package String_2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			String tmp = scanner.nextLine();
			if(tmp.compareTo("그만")==0) break;
			StringTokenizer st = new StringTokenizer(tmp, " ");
			int cnt = 0;
			while (st.hasMoreTokens()) {
				st.nextToken();
				cnt++;
			}

			System.out.println("어절 개수는" + cnt);
			cnt = 0;
			

		}
		System.out.println("종료합니다 ...");
		scanner.close();
	}

}
