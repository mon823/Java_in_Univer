package Stack;

public class Print {
	Object tmp;

	public <T> void printStack(Stack<T> stk) {
		tmp = new Object();
		for (;;) {
			tmp = stk.pop();
			if (tmp == null)
				break;
			System.out.println(tmp);
		}
	}

}
