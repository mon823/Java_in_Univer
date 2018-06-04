package Ass_9;

public class main_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<10;i++) {
			stack.push(i);
		}
		while(true) {
			Integer n = stack.pop();
			if(n == null) break;
			System.out.print(n + " ");
		}
			
	}

}
