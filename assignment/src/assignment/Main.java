package assignment;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Add ad= new Add();
		Sub su= new Sub();
		Mul mu= new Mul();
		Div di= new Div();
		
		int a,b;
		String c;
		System.out.print("�� ������ �����ڸ� �Է��Ͻÿ�>>");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.next();
		
		if(c.equals("+")) {
			ad.setValue(a,b);
			System.out.println(ad.calculate());
		}
		else if(c.equals("-")) {
			su.setValue(a,b);
			System.out.println(su.calculate());
		}	
		else if(c.equals("*")) {
			mu.setValue(a,b);
			System.out.println(mu.calculate());
		}
		else if(c.equals("/")) {
			di.setValue(a,b);
			System.out.println(di.calculate());
		}
		
		else {
			System.out.println("�߸��� �Է�");
		}
			
	}

}
