package assignment;

public class Sub extends Calc{
	private int a;
	private int b;
	
	@Override
	public void setValue(int a,  int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int calculate() {
		return a-b;
	}
}
