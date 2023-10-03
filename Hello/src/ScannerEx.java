import java.util.Scanner;

public class ScannerEx {
	public static void main(String args[]) {
		System.out.println("name, city, age, weight, marriage 여부를 빈칸으로 분리하여 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		
		String name = scanner.next();
		System.out.print("이름은 " + name + ", ");
			
		String city = scanner.next();
		System.out.print("도시는 " + city + ", ");
				
		int age = scanner.nextInt();
		System.out.print("나이는 " + age + ", ");
				
		Double weight = scanner.nextDouble();
		System.out.print("체중은 " + weight + ", ");
				
		boolean single = scanner.nextBoolean();
		System.out.print("독신 여부는 " + single + "입니다.");
			
		scanner.close();
	}

}
