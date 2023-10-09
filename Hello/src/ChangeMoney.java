import java.util.InputMismatchException;
import java.util.Scanner;

public class ChangeMoney {
    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("금액을 입력하세요(원): ");
        try {
            // 사용자로부터 금액을 입력 받기
            int Money = stdin.nextInt();
            
            if (Money > 0) {
                int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
       
                // 환전 결과 출력
                System.out.println("환전 결과:");
                for (int i = 0; i < unit.length; i++) {
                    int ea = Money / unit[i]; // 해당 화폐 단위로 환전 가능한 개수 계산
                    if (ea == 0) continue; // 0인 경우 건너뛰고 다음 화폐 단위로 이동
                    else System.out.println(unit[i] + "원권: "  + ea + "개");
                    Money = Money % unit[i]; // 남은 금액 계산
                }
            } else {
                // 0보다 큰 금액을 입력하지 않은 경우 메시지 출력
                System.out.println("0보다 큰 숫자(금액)를 입력해주세요.");
            }
        } catch (InputMismatchException e) {
            // 숫자가 아닌 값을 입력한 경우 메시지 출력
            System.out.println("0보다 큰 숫자(금액)를 입력해주세요.");
        }
        stdin.close();
    }
}
