package lib;

public class Utils {
	// Exception classes
	// Inheritance
	public static class OverseatNumberException extends Exception {
	    public OverseatNumberException() {
	        super("--좌석번호가 범위를 벗어남--");
	    }
	}
	public static class PatternMismatchException extends Exception {
	    public PatternMismatchException() {
	        super("--입력 형식이 맞지않음--");
	    }
	}
	// 구분선을 그려주는 메서드
	public static void Divider() {
        for (int i = 0; i < 40; i++) {
            System.out.print("=");
        }
        System.out.println();
	}
	// Method Overloading
	// 길이를 정수로 받으면 그 수만큼 구분선 출력
	public static void Divider(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("=");
        }
	}
	// 유니코드 문자를 출력하는 메서드
	public static void fSquare() {
		System.out.print("\u25A3 ");
	}
	public static void eSquare() {
		System.out.print("\u25A2 ");
	}
	// 현재 좌석의 배열을 받아 좌석배치도 및 좌석예약현황을 출력하는 메서드
	public static void SeatingPlan(Seats Vseats, Seats Sseats, Seats Aseats, Seats Bseats) {
		Divider(65);
        System.out.println();
		// V석 1 ~ 30
		System.out.print("|  ");
		for (int i=1; i<31; i++) {
			if (Vseats.isReserved(i) == true)
				fSquare();
			else eSquare();
		}
		System.out.println("\t|");
		System.out.println("|  V석 01 ~ 30\t\t\t\t\t\t\t|");
		// S석 1 ~ 30
		System.out.print("|  ");
		for (int i=1; i<31; i++) {
			if (Sseats.isReserved(i) == true)
				fSquare();
			else eSquare();
		}
		System.out.println("\t|");
		System.out.println("|  S석 01 ~ 30\t\t\t\t\t\t\t|");
		// A, B석 1 ~ 15
		System.out.print("|  ");
		for (int i=1; i<16; i++) {
			if (Aseats.isReserved(i) == true)
				fSquare();
			else eSquare();
		}
		for (int i=1; i<16; i++) {
			if (Bseats.isReserved(i) == true)
				fSquare();
			else eSquare();
		}
		System.out.println("\t|");
		System.out.println("|  A석 01 ~ 15\t\t\t| B석 01 ~ 15\t\t\t|");
		// A, B석 16 ~ 30
		System.out.print("|  ");
		for (int i=1; i<16; i++) {
			if (Aseats.isReserved(i+15) == true)
				fSquare();
			else eSquare();
		}
		for (int i=1; i<16; i++) {
			if (Bseats.isReserved(i+15) == true)
				fSquare();
			else eSquare();
		}
		System.out.println("\t|");
		System.out.println("|  A석 16 ~ 30\t\t\t| B석 16 ~ 30\t\t\t|");
		
		Divider(65);
        System.out.println();
	}
}
