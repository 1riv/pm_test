package generic;

import java.util.*;

public class ListiteratorEx {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		ListIterator it = list.listIterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
		
		while (it.hasPrevious()) {
			System.out.print(it.previous());
		}
		System.out.println();
		
		ListIterator itRandom = list.listIterator(2);
		while (itRandom.hasNext()) {
			System.out.print(itRandom.next());
		}
		System.out.println();
		
		itRandom.set(7);
		itRandom = list.listIterator(2);
		while (itRandom.hasNext()) {
			System.out.print(itRandom.next());
		}
		System.out.println();
		
	}
}
