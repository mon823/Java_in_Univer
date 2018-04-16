
public class Cpoint extends Point {	//다중상속을 못하게 되어 있음.
	private String color;
	
	public void setColor(String color) {
		setPoint(1,2);
		this.color = color;
	}
	public void getColor() {
		System.out.println(color);
	}
	
}
