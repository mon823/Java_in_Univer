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
 * String값을 int형의 값으로 바꾸는 방법 
 * int numInt = Integer.parseInt(numStr);
 * System.out.println(numInt);
 * 
 * int형의 값을 String으로 바꾸는 방법 
 * String numStr2 = String.valueOf(numInt);
 * System.out.println(numStr2);
 * 
 */