package Ass_10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		HashMap<String,String> hm = new HashMap<String,String>();
		StringBuffer sb = new StringBuffer();
		FileInputStream fin = null;
		InputStreamReader in = null;
		String str,name;
		int cnt;
		try {
			fin = new FileInputStream("C:\\Users\\Seokam\\eclipse-workspace\\assignment\\src\\Ass_10\\phone.txt");
			in = new InputStreamReader(fin,"MS949");
			int c;
			while ((c = in.read()) != -1) {
				sb.append((char)c);
				if(c == '\n') {
					str = sb.toString();
					StringTokenizer st = new StringTokenizer(str, " ");
					hm.put(st.nextToken(), st.nextToken());
					sb.delete(0,sb.length());
				}
			}
			fin.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);

		}
		cnt = hm.size();
		cnt++;
		System.out.println("총 "+ cnt +"개의 전화번호를 읽었습니다.");
		for(;;) {
			System.out.print("이름>>");
			name = scanner.next();
			if(name.equals("그만"))break;
			System.out.print(hm.get(name));
			
		}
		scanner.close();
	}
}
