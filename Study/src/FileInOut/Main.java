package FileInOut;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		//FileReader fin = null;
		//FileWriter fout = null;
		FileOutputStream fout = null;
		
		try {
			//fout = new FileWriter("C:\\Users\\Seokam\\eclipse-workspace\\Study\\src\\FileInOut\\test_1.txt");
			fout = new FileOutputStream("C:\\Users\\Seokam\\eclipse-workspace\\Study\\src\\FileInOut\\test_1.txt");
			//fout.write("A\r\n");		//윈도우 환경에서는 개행시 \r\n 을 해야함.
			//fout.write("C");
			fout.write((byte)'1');
			
			fout.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		FileInputStream fin = null;		//바이트 단위 따라서 파일 포멧을 다시 안바꿔 주면 한글을 잘 읽어 올 수 없음
		InputStreamReader in = null;
		try {
			//fin = new FileReader("C:\\Users\\Seokam\\eclipse-workspace\\Study\\src\\FileInOut\\test.txt");
			fin = new FileInputStream("C:\\Users\\Seokam\\eclipse-workspace\\Study\\src\\FileInOut\\test_1.txt");
			in = new InputStreamReader(fin,"MS949"); 		//한글 완성형 확장형 문자 집합
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			fin.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e);

		}

	}

}
