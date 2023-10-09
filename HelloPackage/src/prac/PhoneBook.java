package prac;
import java.util.Scanner;
import java.util.InputMismatchException;

// Contact class: 이름과 전화번호를 포함한 연락처를 나타내는 클래스
class Contact {
    private String name;
    private String phoneNumber;
    // 이름과 전화번호로 Contact 초기화
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    // 각각 이름과 전화번호를 반환하는 메서드
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
// PhoneBook class: 연락처들의 목록을 관리하는 클래
public class PhoneBook {
    private Contact[] contacts;  // 연락처 배열
    // 주어진 크기만큼의 연락처 배열을 초기화
    public PhoneBook(int size) {
        this.contacts = new Contact[size];
    }
    // 연락처를 배열에 추가하는 메서드
    public void addContact(int index, Contact contact) {
        contacts[index] = contact;
    }
    // 이름으로 연락처를 검색하고 출력하는 메서드
    public void searchByName(String name) {
        boolean found = false;
        int count = 0;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact.getName() + "'s number is " + contact.getPhoneNumber());
                found = true;
                count++;
            }
        }
        if (count > 1) {
            System.out.println(count + " contacts found with the name " + name + ".");
        }
        if (!found) {
            System.out.println(name + " not found.");
        }
    }
    // 메인 메서드: 사용자로부터 연락처 정보를 입력받고 검색
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Number of Person>>");
        int headCount = 0;
        // 사용자로부터 명수를 입력받음
        try {
            headCount = stdin.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("입력을 확인해주세요.");
            stdin.close();
            return;
        }
        
        PhoneBook phonebook = new PhoneBook(headCount); // 입력한 인원수로 배열 생성
        // 사용자로부터 연락처 정보를 입력받음
        for (int i = 0; i < headCount; i++) {
            System.out.print("Name and Phonenumber (ex. 홍길동 010-1234-5678) >> ");
            String name = stdin.next();
            String phoneNumber = stdin.next();
            phonebook.addContact(i, new Contact(name, phoneNumber));
        }
        // 저장 끝
        System.out.println("Store Done.");
        // 이름으로 연락처를 검색하는 무한 루프
        while (true) {
            System.out.print("Name to search >> ");
            String name = stdin.next();
            // 특정 단어를 입력했을때 중단하도록 설정
            if (name.equalsIgnoreCase("stop") || name.equals("중단") || name.equals("그만")) {
                System.out.println("Finder Closed.");
                stdin.close();
                return;
            } else {
                phonebook.searchByName(name); // searchByName 메서드를 이용해 번호 찾기
            }
        }
    }
}