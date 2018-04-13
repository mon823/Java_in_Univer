package assignment;

import java.util.Scanner;

public class DicApp extends Dictionary {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String word;
		System.out.println("한영 단어 검색 프로그램입니다.");
		for(;;) {
			System.out.print("한글 단어?");
			word = scanner.next();
			if(word.equals("그만"))break;
			kor2Eng(word);
		}

	}
}