package lib;

import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

class Seat {
	private int seatNumber;
	private String seatType;
    private String resverName;
    private String resverNumber;
    private String resvNumber;
    private boolean isReserved;
    Random random = new Random();
    
    public Seat() {
    	this("", "010-0000-0000");
    }
    // Constructor Overloading
    public Seat(String resverName, String resverNumber) {
        this.resverName = resverName;
        this.resverNumber = resverNumber;
        this.isReserved = false;
    }
    // 예약상태 반환 메서드
    public boolean isReserved() {
    	return isReserved;
    }
    // 예약정보 설정 메서드 모음
    public void setReserved(boolean i) {
    	this.isReserved = i;
    }
    public void setresverName(String resverName) {
    	this.resverName = resverName;
    }
    public void setresverNumber(String resverNumber) {
    	this.resverNumber = resverNumber;
    }
    public void setseatNumber(int seatNumber) {
    	this.seatNumber = seatNumber;
    }
    public void setseatType(String seatType) {
    	this.seatType = seatType;
    }
    public void setresvNumber(String resvNumber) {
    	this.resvNumber = resvNumber;
    }
    // 예약번호를 생성하는 메서드
    // 예약번호 = 현재날짜yyMMdd 6자리 + 좌석타입 + 전화번호 4자리 + ~9999까지의 4자리 난수
    public void makeresvNumber() {
    	int randomNumber = random.nextInt(10000);
        String formattedRandomNumber = String.format("%04d", randomNumber);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String date = dateFormat.format(new Date());
        String middleDigits = resverNumber.substring(4, 8);
        this.resvNumber = date + seatType + middleDigits + formattedRandomNumber;
    }
    // 예약정보를 얻는 메서드 모음
    public String getresverName() {
		return this.resverName;
	}
    public String getresverNumber() {
		return this.resverNumber;
	}
    public String getresvNumber() {
		return this.resvNumber;
	}
    public int getseatNumber() {
		return this.seatNumber;
	}
    public String getseatType() {
    	return this.seatType;
    }
    // 별표 처리된 예약정보를 얻는 메서드 모음
    public String getMaskedresverName() {
    	String MaskedName = resverName.substring(0,1) + "***";
    	return MaskedName;
    }
    public String getMaskedresverNumber() {
    	String MaskedNumber = resverNumber.substring(0,4) + "****" + resverNumber.substring(8,13);
    	return MaskedNumber;
    }
    
    // toString() Method Overriding
    public String toString() {
		return "좌석: " + getseatType() + getseatNumber() + " 예약자성명: " + getresverName() 
		+ " 전화번호: " + getresverNumber() + " 예약번호: " + getresvNumber();
	}
    // 가려진 정보를 반환하는 메서드
    public String toMaskedString() {
		return "좌석: " + getseatType() + getseatNumber() + " 예약자성명: " + getMaskedresverName() 
		+ " 전화번호: " + getMaskedresverNumber();
	}
}

public class Seats {
	private Seat[] seats;
	
    public Seats(String seatType, int size) {
        this.seats = new Seat[size];
        for (int i = 0; i < size; i++) {
            seats[i] = new Seat(); 
            seats[i].setseatType(seatType);
            seats[i].setseatNumber(i+1);
        }
    }
    // 좌석 번호를 넣으면 좌석 반환
    public Seat getSeat(int index) {
    	return seats[index-1];
    }
    
    // 좌석번호와 예약자이름, 번호를 받아 예약을 하는 메서드
    public void makeResv(int index, String resverName, String resverNumber) {
    	seats[index-1].setresverName(resverName);
    	seats[index-1].setresverNumber(resverNumber);
    	seats[index-1].makeresvNumber();
    	seats[index-1].setReserved(true);
    }
    // 좌석번호를 받아 좌석을 초기화해 예약을 취소하는 메서드
    public void cancelResv(int index) {
    	seats[index-1].setresverName("");
    	seats[index-1].setresverNumber("010-0000-0000");
    	seats[index-1].setresvNumber("");
    	seats[index-1].setReserved(false);
    }
    
    public String toString(int index) {
		return seats[index-1].toString();
	}
    public String toMaskedString(int index) {
		return seats[index-1].toMaskedString();
	}
    public boolean isReserved(int index) {
        return seats[index-1].isReserved();
    }
    //해당 좌석타입이 매진되었는지 확인하는 메서드
    public boolean isitSoldOut() {
    	int reservedCount = 0;
    	for (Seat seat : seats) {
    		if (seat.isReserved()) {
    			reservedCount++;
    		}
    	}
    	return reservedCount == seats.length;
    }
    // 예약자의 번호와 이름으로 예약횟수를 검사하여 반환하는	 메서드
    public int resvCount(String resverName, String resverNumber) {
        int count = 0;
        for (Seat refseat : seats) {
            if (refseat.getresverName().equalsIgnoreCase(resverName) 
            		&& refseat.getresverNumber().equals(resverNumber)) {
                count++;
            }
        }
        return count;
    }
    // 예약번호로 예약정보 찾고 정보를 출력하는 메서드
    public void queryByresvNumber(String resvNumber) {
    	boolean found = false;
    	for (Seat refseat : seats) {
    		if (refseat.isReserved()) {
    			if (refseat.getresvNumber().equalsIgnoreCase(resvNumber)) {
    				found = true;
    				System.out.println("입력하신 예약번호로 예약 내역이 존재합니다.");
    				System.out.println(refseat.toString());
    			}
    		}
    	}
    	if (!found) System.out.println("입력하신 예약번호로 예약 내역이 존재하지 않습니다.");
    }
    // 좌석번호로 예약정보 찾고 가려진 정보를 출력하는 메서드
    public void queryByseatNumber(int SeatNumber) {
    	boolean found = false;
    	for (Seat refseat : seats) {
    		if (refseat.isReserved()) {
    			if (SeatNumber == refseat.getseatNumber()) {
    				found = true;
    				System.out.println("입력하신 좌석으로 예약 내역이 존재합니다.");
    				System.out.println(refseat.toMaskedString());
    			}
    		}
    	}
    	if (!found) System.out.println("입력하신 좌석으로 예약 내역이 존재하지 않습니다.");
    }
    // 예약번호로 예약정보 찾고 취소하는 메서드
    public void cancelByresvNumber(String resvNumber) {
    	boolean found = false;
    	for (Seat refseat : seats) {
    		if (refseat.isReserved()) {
    			if (refseat.getresvNumber().equalsIgnoreCase(resvNumber)) {
    				System.out.println("입력하신 예약번호로 예약 내역이 존재합니다.");
    				System.out.println(refseat.toString());	
    				System.out.println("예약을 삭제합니다.");
    				refseat.setresverName("");
    				refseat.setresverNumber("010-0000-0000");
    				refseat.setresvNumber("");
    				refseat.setReserved(false);
    				found = true;
    			}
    		}
    	}
    	if (!found) System.out.println("입력하신 예약번호로 예약 내역이 존재하지 않습니다.");
    }
}
