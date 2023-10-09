package prac;

public class CircleTest {

	public static void main(String[] args) {
		System.out.println("Class and Object Practice");
		
		Circle pizza3 = new Circle(15, "Hawaiian Pizza");
		System.out.println(pizza3.toString());
		pizza3.setName("Pizza3");
		System.out.println(pizza3.toString());
		pizza3.setRadius(10);
		System.out.println(pizza3.toString());
		Circle pizzaCopy = new Circle(pizza3);
		System.out.println(pizzaCopy.toString());
		Circle pizza2 = new Circle();
		System.out.println(pizza2.toString());
	}

}
