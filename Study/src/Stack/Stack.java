package Stack;

public class Stack<T> {
	int top;
	Object [] stack ; 
	
	Stack (){	
		top = 0;
		stack = new Object [10];
	}
	
	public void push(T ele) {
		stack[top] = ele;
		top ++;
	}
	
	@SuppressWarnings("unchecked")
	public T pop(){
		if(top == 0) {
			return null;
		}
		top--;
		return (T)stack[top];
	}

}