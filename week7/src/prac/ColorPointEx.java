package prac;

class MyPoint {
	private int x, y;
	
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("Point is on x = " + x + ", " + "y = " + y);
	}
}

class ColorPoint extends MyPoint {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public void showColorPoint() {
		System.out.println("colore is " + color);
		showPoint();
	}
}
	
public class ColorPointEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorPoint cp = new ColorPoint(5, 6, "blue");
		cp.showColorPoint();
	}
}
