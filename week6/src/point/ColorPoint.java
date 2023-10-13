package point;

public class ColorPoint extends MyPoint{
	public String color;
	
	public void setColor(String color) {
		this.color = color;
	}

	public void showColorPoint() {
		showPoint();
		System.out.println("color is " + color);
	}
}
