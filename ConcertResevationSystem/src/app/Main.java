package app;

import java.util.Scanner;
import java.util.InputMismatchException;

import lib.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Seats Vseats = new Seats("V", 30);
	static Seats Sseats = new Seats("S", 30);
	static Seats Aseats = new Seats("A", 30);
	static Seats Bseats = new Seats("B", 30);
	
	static Seats selectedSeatType(String seatType) {
        switch (seatType.toUpperCase()) {
            case "V":
                return Vseats;
            case "S":
                return Sseats;
            case "A":
                return Aseats;
            case "B":
                return Bseats;
            default:
                return null;
        }
    }
	
	static void resvMenu() {
		Utils.Divider();
		System.out.println("비어있는 좌석의 타입과 번호를 확인 후 입력해 주세요.\n"
				+ "같은 좌석 타입 1인 2석까지 동시 예약 가능합니다.");
		
		// 좌석 타입 입력
		System.out.print("좌석 타입을 입력하여 주세요. (V, S, A, B) >> ");
		String seatType;
		
		while (true) {
            try {
            	seatType = scanner.next("[SsVvAaBb]");
                if (selectedSeatType(seatType).isitSoldOut()) {
                	System.out.print("죄송합니다. 해당 좌석타입은 매진되었습니다. 다른 좌석타입을 입력해주세요. >> ");
                } else break;
            } catch (InputMismatchException e) {
            	Utils.Divider();
                System.out.print("--잘못된 좌석타입 입력--\nV, S, A, B 중 하나를 입력하여 주세요. >> ");
                scanner.nextLine();
            }
        }
		System.out.println(seatType.toUpperCase() + "석 을 선택하셨습니다.");
		
		// 좌석 번호 입력
		Utils.Divider();
		System.out.print("다음으로 좌석의 번호를 입력해 주세요. (1~30) >> ");
		int seatNumber;
		while (true) {
		    try {
		    	seatNumber = scanner.nextInt();
		        if (seatNumber < 1 || seatNumber > 30) {
		            throw new InputMismatchException();
		        }
		        if (selectedSeatType(seatType).isReserved(seatNumber)) {
		        	System.out.print("죄송합니다. 해당 좌석 번호는 매진되었습니다. 다른 좌석번호를 입력해주세요. >> ");
		        } 
		        else break;
		    } catch (InputMismatchException e) {
		    	Utils.Divider();
		        System.out.print("--잘못된 좌석번호 입력--\n1 ~ 30까지의 좌석번호 중 하나를 입력하여 주세요. >> ");
		        scanner.nextLine();
		    } 
		}
		System.out.println(seatType.toUpperCase() + "석의 " + seatNumber +  "번을 선택하셨습니다.");
		Utils.Divider();
		System.out.println("예약자분의 성명과 전화번호를 입력해 주세요. (ex. 김철수 010-1234-5678) >> ");
		String resverName = scanner.next();
		String resverNumber = scanner.next();
		selectedSeatType(seatType).makeResv(seatNumber, resverName, resverNumber);
		System.out.println(selectedSeatType(seatType).toString(seatNumber));
		
		System.out.println("메뉴로 돌아가시려면 를, 추가로 좌석을 하나 더 예약을 원하시면 좌석번호를 입력해주세요. >> ");
		
	}
	
	static void queryMenu() {
		Utils.Divider();
		
	}
	
	static void cancelMenu() {
		Utils.Divider();
		
	}
	
	static void infoMenu() {
		Utils.Divider();
		System.out.println("해당 공연은 2023.11.15에 1회 주최되는 공연입니다.	");
	}
	
	static void mainMenu() {
		
		Utils.Divider();
		System.out.println("2023.11.15 공연 예약 시스템입니다.\n원하시는 메뉴를 입력해 주세요.\n"
				+ "1. 좌석 예약\n2. 예약 조회\n3. 예약 취소\n4. 공연 정보	");
		Utils.Divider();
		String menu = scanner.next();
		if (menu.equals("1") || menu.equals("좌석 예약")) {
			System.out.println("좌석 예약을 선택하셨습니다.");
			resvMenu();
		}
		
		else if (menu.equals("2") || menu.contains("조회")) {
			System.out.println("예약 조회를 선택하셨습니다.");
			queryMenu();
		}
		else if (menu.equals("3") || menu.contains("취소")) {
			System.out.println("예약 취소를 선택하셨습니다.");
			cancelMenu();
		}
		else if (menu.equals("4") || menu.contains("정보")) {
			System.out.println("공연 정보를 선택하셨습니다.");
			infoMenu();
		}
		else {
			System.out.println("찾으시는 메뉴가 없습니다.");
			mainMenu();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(Vseats.toString(1));
		Vseats.makeResv(1, "John Doe", "010-1234-5678");
		System.out.println(Vseats.toString(1));
		Aseats.makeResv(4, "Chris", "010-1234-5678"); // 3번 좌석 예약 걸음 
		System.out.println(Aseats.toString(4));
		System.out.println(Aseats.isReserved(4));
		Vseats.setSoldOut();
		System.out.println(selectedSeatType("V").isitSoldOut());
		mainMenu();
	}

}
