package app;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

import lib.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Seats Vseats = new Seats("V", 30);
	static Seats Sseats = new Seats("S", 30);
	static Seats Aseats = new Seats("A", 30);
	static Seats Bseats = new Seats("B", 30);
	// 알파벳을 받아서 해당 좌석타입 배열을 반환하는 메서드
	static Seats matchSeatType(String seatType) {
        switch (seatType.toUpperCase()) {
            case "V": return Vseats;
            case "S": return Sseats;
            case "A": return Aseats;
            case "B": return Bseats;
            default : return null;
        }
    }
	// 이름과 번호를 받아서 예약횟수를 체크해서 메인메뉴로 돌아가거나 계속 진행하는 메서드
	static void resvCheck(String resverName, String resverNumber) {
		int resvCount = Vseats.resvCount(resverName,resverNumber) + Sseats.resvCount(resverName,resverNumber)
		+ Aseats.resvCount(resverName,resverNumber) + Bseats.resvCount(resverName,resverNumber);
		Utils.Divider();
		System.out.println("예약자분은 현재 티켓을 " + resvCount +  "매 예약하셨습니다.");
		if (resvCount >= 2) {
			System.out.println("인당 2매까지 예약가능합니다.\n메인메뉴로 돌아갑니다.");
			mainMenu();
		};
	}
	// 좌석 타입과 번호를 받고 이름과 번호를 이용해서 예약하는 메서드
	static void resvByNaN(String resverName, String resverNumber) {
		resvCheck(resverName, resverNumber);
		Utils.SeatingPlan(Vseats, Sseats, Aseats, Bseats);
		Utils.Divider();
		System.out.println("비어있는 좌석의 타입과 번호를 확인 후 입력해 주세요.\n"
				+ "1인 2석까지 예약 가능합니다.");
		
		// 좌석 타입 입력
		System.out.print("예약하실 좌석의 타입을 입력하여 주세요. (V, S, A, B) >> ");
		String seatType;
		while (true) {
            try {
            	// 패턴을 정해서 받는 메서드
            	seatType = scanner.next("[SsVvAaBb]");
                if (matchSeatType(seatType).isitSoldOut()) {
                	System.out.print("죄송합니다. 해당 좌석타입은 매진되었습니다. 다른 좌석타입을 입력해주세요. >> ");
                } else break;
            } catch (InputMismatchException e) {
            	// Exception Handling
            	Utils.Divider();
                System.out.print("--잘못된 좌석타입 입력--\nV, S, A, B 중 하나를 입력하여 주세요. >> ");
                scanner.nextLine();
            }
        }
		System.out.println(seatType.toUpperCase() + "석을 선택하셨습니다.");
		
		// 좌석 번호 입력
		Utils.Divider();
		System.out.print("1~30번의 좌석중 예약하실 좌석의 번호를 숫자로 입력해 주세요. >> ");
		int seatNumber;
		while (true) {
		    try {
		    	seatNumber = scanner.nextInt();
		        if (seatNumber < 1 || seatNumber > 30) {
		        	// throw Exception
		            throw new Utils.OverseatNumberException();
		        }
		        if (matchSeatType(seatType).isReserved(seatNumber)) {
		        	System.out.print("죄송합니다. "+ seatType.toUpperCase() 
		        	+ seatNumber + "번 좌석은 얘매되었습니다. 다른 좌석번호를 입력해주세요. >> ");
		        }
		        else break;
		    } catch (Utils.OverseatNumberException e) {
		    	// Exception Handling
		    	System.out.println(e.getMessage());
		    	Utils.Divider();
		        System.out.print("1 ~ 30까지의 좌석번호 중 하나를 입력하여 주세요. >> ");
		        scanner.nextLine();
		    } 
		}
		System.out.println(seatType.toUpperCase() + "석의 " + seatNumber +  "번을 선택하셨습니다.");
		
		Utils.Divider();
		matchSeatType(seatType).makeResv(seatNumber, resverName, resverNumber);
		System.out.println("예약이 완료되었습니다. 예약번호를 꼭 기억해주세요.");
		System.out.println(matchSeatType(seatType).toString(seatNumber));
		System.out.print("추가로 예약을 원하시면 예약을, 메인으로 돌아가려면 아무키나 입력해주세요. >> ");
		String input = scanner.next();
		if (input.equals("예약")) {
			// 추가 예약을 받기 위해 메서드를 다시 호출
			resvByNaN(resverName, resverNumber);
		}
		else {
			System.out.println("메인메뉴로 돌아갑니다.");
			scanner.nextLine();
			mainMenu();
		}
	}
	// 예약메뉴
	static void resvMenu() {
		scanner.nextLine();
		// 예약자 이름 입력
		Utils.Divider();
		System.out.print("예약자분의 성명을 입력해 주세요. (ex. 김철수) >> ");
		String resverName = scanner.nextLine();
		// 예약자 번호 입력
		Utils.Divider();
		String resverNumber;
		System.out.print("예약자분의 전화번호를 입력해 주세요. (ex. 010-1234-5678) >> ");
		while (true) {
            try {
                resverNumber = scanner.next();
                String phoneNumberPattern = "010-\\d{4}-\\d{4}";
                if (!Pattern.matches(phoneNumberPattern, resverNumber)) {
                	// Exception Handling
                    throw new Utils.PatternMismatchException();
                }
                else break;
            } catch (Utils.PatternMismatchException e) {
            	System.out.println(e.getMessage());
                System.out.print("예약자분의 전화번호를 입력해 주세요. (ex. 010-1234-5678) >> ");
                scanner.nextLine();
            }
        }
		// 예약 조건 검사 후 예약 메서드 실
		resvByNaN(resverName, resverNumber);
	}
	
	
	// 조회메뉴
	static void queryMenu() {
		String resvNumberPattern = "\\d{6}[A-Za-z]\\d{8}";
		String resvSeatPattern = "[A-Za-z]\\d{1,2}";
		Utils.SeatingPlan(Vseats, Sseats, Aseats, Bseats);
		System.out.print("원하시는 좌석의 예약내역을 확인하려면 좌석 타입과 번호를, (ex. V1)"
				+ "\n또는 예약번호 15자리를 입력해주세요. "
				+ "\n메인으로 돌아가시려면 \"메인\" 또는 \"main\"이라고 입력해주세요 >> ");
		String qinput = scanner.next();
		// 받는 패턴에 따라 다른 출력으로 분기
        if (Pattern.matches(resvNumberPattern, qinput)) {
        	matchSeatType(qinput.substring(6, 7)).queryByresvNumber(qinput);
        	queryMenu();
		}
        else if (Pattern.matches(resvSeatPattern, qinput)) {
        	if (Integer.parseInt(qinput.substring(1)) > 30) {
        		System.out.println("잘못된 입력입니다.");
        	}
        	else {
        		matchSeatType(qinput.substring(0, 1)).queryByseatNumber(Integer.parseInt(qinput.substring(1)));
        	}
        }
        else if (qinput.equals("메인") || qinput.equalsIgnoreCase("main")) mainMenu();
        else {
        	System.out.println("잘못된 입력입니다.");
        }
        queryMenu();
	}
	// 취소메뉴
	static void cancelMenu() {
		Utils.Divider();
		String resvNumberPattern = "\\d{6}[A-Za-z]\\d{8}";
		System.out.print("예약을 취소하시려면 예약번호 15자리를 입력해주세요. "
				+ "\n메인으로 돌아가시려면 \"메인\" 또는 \"main\"이라고 입력해주세요 >> ");
		String cinput = scanner.next();
		if (Pattern.matches(resvNumberPattern, cinput)) {
        	matchSeatType(cinput.substring(6, 7)).cancelByresvNumber(cinput);
        	cancelMenu();
		}
		else if (cinput.equals("메인") || cinput.equalsIgnoreCase("main")) mainMenu();
        else {
        	System.out.println("잘못된 입력입니다.");
        }
		cancelMenu();
	}
	// 정보메뉴
	static void infoMenu() {
		Utils.Divider();
		scanner.nextLine();
		System.out.println("해당 공연은 2023.11.15에 1회 개최되는 공연입니다.	"
				+ "\n 좌석예약은 1인 2석까지 예약 가능합니다.");
		Utils.SeatingPlan(Vseats, Sseats, Aseats, Bseats);
		System.out.println("메인으로 돌아가시려면 아무키나 입력해주세요.");
		scanner.nextLine();
		mainMenu();
	}
	// 메인메뉴
	static void mainMenu() {
		Utils.Divider();
		System.out.println("2023.11.15 공연 예약 시스템입니다.\n원하시는 메뉴를 입력해 주세요.\n"
				+ "1. 좌석 예약\n2. 예약 조회\n3. 예약 취소\n4. 공연 정보\n5. 종료");
		Utils.Divider();
		String minput = scanner.next();
		if (minput.equals("1") || minput.equals("좌석 예약")) {
			System.out.println("좌석 예약을 선택하셨습니다.");
			resvMenu();
		}
		else if (minput.equals("2") || minput.contains("조회")) {
			System.out.println("예약 조회를 선택하셨습니다.");
			queryMenu();
		}
		else if (minput.equals("3") || minput.contains("취소")) {
			System.out.println("예약 취소를 선택하셨습니다.");
			cancelMenu();
		}
		else if (minput.equals("4") || minput.contains("정보")) {
			System.out.println("공연 정보를 선택하셨습니다.");
			infoMenu();
		}
		else if (minput.equals("5") || minput.equalsIgnoreCase("종료")) {
			// 프로그램 종료
            System.out.println("프로그램 종료");
            scanner.close();
            System.exit(0);
		}
		else {
			// 해당하는 메뉴가 없으면 다시 메인메뉴로
			System.out.println("찾으시는 메뉴가 없습니다.");
			mainMenu();
		}
	}
	// 메인메뉴 실행
	public static void main(String[] args) {
		mainMenu();
	}
}
