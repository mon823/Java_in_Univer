package assignment;

import java.util.Scanner;

public class DicApp extends Dictionary {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String word;
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
		for(;;) {
			System.out.print("�ѱ� �ܾ�?");
			word = scanner.next();
			if(word.equals("�׸�"))break;
			kor2Eng(word);
		}

	}
}