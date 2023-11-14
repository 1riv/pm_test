package prac;

abstract class Shape1 {
	abstract void draw();
	abstract void computeArea(double a, double b);
}

class Rectangle1 extends Shape1 {
	void draw() {
		System.out.println("사각형을 그리는 기능");
	}
	void computeArea(double h, double v) {
		System.out.println("사각형의 넓이 : " + (h * v));
	}
}

class Triangle1 extends Shape1 {
	public void draw() {
		System.out.println("삼각형을 그리는 기능");
	}
	void computeArea(double a, double h) {
		System.out.println("삼각형의 넓이 : " + (a * h / 2));
	}
}

public class AbstractTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("==추상 메소드를 이용한 다형성==");
		Shape1 s = new Rectangle1();
		s.draw();
		s.computeArea(5.0, 10.0);
		s = new Triangle1();
		s.draw();
		s.computeArea(5.0, 10.0);
	}

}
