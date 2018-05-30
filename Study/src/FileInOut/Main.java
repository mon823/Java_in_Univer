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
			//fout.write("A\r\n");		//������ ȯ�濡���� ����� \r\n �� �ؾ���.
			//fout.write("C");
			fout.write((byte)'1');
			
			fout.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		FileInputStream fin = null;		//����Ʈ ���� ���� ���� ������ �ٽ� �ȹٲ� �ָ� �ѱ��� �� �о� �� �� ����
		InputStreamReader in = null;
		try {
			//fin = new FileReader("C:\\Users\\Seokam\\eclipse-workspace\\Study\\src\\FileInOut\\test.txt");
			fin = new FileInputStream("C:\\Users\\Seokam\\eclipse-workspace\\Study\\src\\FileInOut\\test_1.txt");
			in = new InputStreamReader(fin,"MS949"); 		//�ѱ� �ϼ��� Ȯ���� ���� ����
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
