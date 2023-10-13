package week6;

public class Student {
	int stuid;
	String name;
	static String univ = "SeoulTech";
	
	Student(int id, String n) {
		this.stuid = id;
		this.name = n;
	}
	
	public String toString() {
		return "(" + stuid + ") " + name + " in " + univ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Student stu1 = new Student(1, "Alice");
		Student stu2 = new Student(2, "Bob");
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());
	}

}
