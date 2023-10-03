import java.util.Scanner;

public class Simple369 {
	public static void main(String args[]) {	
		Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
		System.out.print("Enter integar value 1~99 : "); 
		int value = scanner.nextInt(); // 정수 읽기
		int firstDigit = value / 10; // 10의 자리수
		int secondDigit = value % 10; // 1의 자리수
		if ((firstDigit == 3 || firstDigit == 6 || firstDigit == 9) && (secondDigit == 3 || secondDigit == 6 || secondDigit == 9))
			System.out.println("박수짝짝"); // 3, 6, 9가 두 개 있으므로 "박수짝짝" 출력
		else if (secondDigit == 3 || secondDigit == 6 || secondDigit == 9)
			System.out.println("박수짝"); // 3, 6, 9가 한 개 있으므로 "박수짝" 출력
		else
			System.out.println("No 3, 6, or 9"); // 3, 6, 9가 없으므로 "No 3, 6, or 9" 출력
		scanner.close();
	}
}
