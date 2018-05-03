package assignment;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a,b;
		String c;
		System.out.println("두 정수와 연산자를 입력하시오 >>");
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.next();
		if(c.equals("+")) {
			Add add=new Add();
			add.setValue(a, b);
			System.out.println(add.calculate());
		}
		else if(c.equals("+")) {
			Add add=new Add();
			add.setValue(a, b);
			System.out.println(add.calculate());
		}
		else if(c.equals("-")) {
			Sub sub=new Sub();
			sub.setValue(a, b);
			System.out.println(sub.calculate());
		}
		else if(c.equals("*")) {
			Mul mul=new Mul();
			mul.setValue(a, b);
			System.out.println(mul.calculate());
		}
		else if(c.equals("*")) {
			Div div=new Div();
			div.setValue(a, b);
			System.out.println(div.calculate());
		}
		scanner.close();
	}

}
