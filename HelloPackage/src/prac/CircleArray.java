package prac;

class Circlea {
	int radius;
	public Circlea(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return 3.14*radius*radius;
	}
}
	
public class CircleArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circlea [] c;
		c = new Circlea[5];
		for(int i=0; i<c.length; i++)
			c[i] = new Circlea(i);
		
		for(int i=0; i<c.length; i++)
			System.out.print((c[i].getArea()) + " ");
		
	}
}
