package generic;

import java.util.*;

public class ArrayListLinkedListTest {
	static final int MAX_ELEMENT = 2000000;
	static final int NUM_ELEMENT = 1000000;
	
	public static void main(String[] args) {
		ArrayList al = new ArrayList(MAX_ELEMENT);
		LinkedList ll = new LinkedList();
		System.out.println("=== 순차적으로 추가하기 ===");
		System.out.println("ArrayList : \t" + add1(al));
		System.out.println("LinkedList : \t" + add1(ll));
		
		System.out.println();
		
		System.out.println("=== 접근시간 테스트 ===");
		System.out.println("ArrayList : \t" + access(al));
		System.out.println("LinkedList : \t" + access(ll));
		
		System.out.println();
		
		System.out.println("=== 중간에 추가하기 ===");
		System.out.println("ArrayList : \t" + add2(al));
		System.out.println("LinkedList : \t" + add2(ll));
		
		System.out.println();
		
		System.out.println("=== 중간에서 삭제하기 ===");
		System.out.println("ArrayList : \t" + remove2(al));
		System.out.println("LinkedList : \t" + remove2(ll));
		
		System.out.println();
		
		System.out.println("=== 순차적으로 삭제하기 ===");
		System.out.println("ArrayList : \t" + remove1(al));
		System.out.println("LinkedList : \t" + remove1(ll));
		
		System.out.println();
	}
	
	public static long access(List list) {
		long startTime = System.nanoTime();
		for (int i = 0; i < (NUM_ELEMENT/100); i++) {
			list.get(i);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public static long add1(List list) {
		long startTime = System.nanoTime();
		for (int i = 0; i < NUM_ELEMENT; i++) {
			list.add(i);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public static long add2(List list) {
		long startTime = System.nanoTime();
		for (int i = 0; i < (NUM_ELEMENT/100); i++) {
			list.add(1000 + i, i);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public static long remove1(List list) {
		long startTime = System.nanoTime();
		for (int i = list.size() - 1; i >= 0; i--) {
			list.remove(i);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
	
	public static long remove2(List list) {
		long startTime = System.nanoTime();
		for (int i = 0; i < (NUM_ELEMENT/100); i++) {
			list.remove(i);
		}
		long endTime = System.nanoTime();
		return (endTime - startTime);
	}
}
