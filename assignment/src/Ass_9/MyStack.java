package Ass_9;

public class MyStack<T> implements IStack<T>{
	int top;
	Object [] stack;
	MyStack(){
		top=0;
		stack = new Object [10];
	}
	public T pop(){
		if(top==0){
			return null;
		}
		top --;
		return (T)stack[top];
	}
	
	public boolean push(T ob){
		stack[top] = ob;
		top ++;
		return true;
		
	}
}
