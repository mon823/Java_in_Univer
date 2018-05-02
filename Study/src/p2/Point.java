package p2;

public class Point {
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Point a) {
		if( this.x == a.x && this.y == a.y ) 
			return true;
		
		else
			return false;
	}
}
