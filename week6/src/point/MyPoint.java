package point;

public class MyPoint {
	public int x;
	public int y;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("Point is on x = " + x + ", " + "y= " + y);
	}
}
