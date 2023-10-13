package week6;

public class Person {
	private int weight;
	int age;
	protected int height;
	public String name;
	
	public void set(int age, int height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
