package Stack;

public class StackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> st = new Stack<String>();
		Print a = new Print();
		for (int i = 1; i <= 5; i++) {

			st.push(String.valueOf(i));
		}
		
		// i == Integer => String
		st.pop();
		
		st.push("kkkkk");

		a.printStack(st);

	}

}
/*
 * 
 * String���� int���� ������ �ٲٴ� ��� 
 * int numInt = Integer.parseInt(numStr);
 * System.out.println(numInt);
 * 
 * int���� ���� String���� �ٲٴ� ��� 
 * String numStr2 = String.valueOf(numInt);
 * System.out.println(numStr2);
 * 
 */