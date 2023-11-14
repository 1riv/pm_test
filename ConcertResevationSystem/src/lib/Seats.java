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
    public Seat(String resverName, String resverNumber) {
        this.resverName = resverName;
        this.resverNumber = resverNumber;
        this.isReserved = false;        
    }
    
    public boolean isReserved() {
        return isReserved;
    }
    public void setReserved() {
    	this.isReserved = true;
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
    public void setresvNumber() {
    	int randomNumber = random.nextInt(9999); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String date = dateFormat.format(new Date());
        String middleDigits = resverNumber.substring(4, 8);
        this.resvNumber = date + seatType + seatNumber + middleDigits + randomNumber;
    }
    
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
    
    public String toString() {
		return "좌석: " + getseatType() + getseatNumber() + "\t예약자 이름 : " + getresverName() 
		+ "\t전화번호: " + getresverNumber() + "\t예약번호: " + getresvNumber();
	}
}

public class Seats {
	private Seat[] seats;
	
	
    public Seats(String seatType, int size) {
        this.seats = new Seat[size];
        for (int i = 0; i < size; i++) {
            seats[i] = new Seat(); 
            seats[i].setseatNumber(i+1);
            seats[i].setseatType(seatType);
        }
    }
    
    public Seat getSeat(int index) {
    	return seats[index-1];
    }

    public void makeResv(int index, String resverName, String resverNumber) {
    	seats[index-1].setresverName(resverName);
    	seats[index-1].setresverNumber(resverNumber);
    	seats[index-1].setresvNumber();
    	seats[index-1].setReserved();
    }
    
    public String toString(int index) {
		return seats[index-1].toString();
	}
    public boolean isReserved(int index) {
        return seats[index-1].isReserved();
    } 
    
    public boolean isitSoldOut() {
    	int reservedCount = 0;
    	for (Seat seat : seats) {
    		if (seat.isReserved()) {
    			reservedCount++;
    		}
    	}
    	return reservedCount == seats.length;
    }
    
    // 관리자 메서드 모음
    public void setSoldOut() {
    	for (int i = 0; i < seats.length; i++) {
            seats[i].setReserved();
        }
    } 
    
    
}
