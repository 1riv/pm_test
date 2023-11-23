package generic;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray[] = new int [3];
		intArray[0] = 2;
		intArray[1] = 4;
		intArray[2] = 8;
//		intArray[3] = 16;
		System.out.println(Arrays.toString(intArray));
		
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		intArrayList.add(2);
		intArrayList.add(4);
		intArrayList.add(8);
		System.out.println(intArrayList.toString());
		
		intArrayList.add(16);
		System.out.println(intArrayList.toString());
		
		ArrayList<String> strArrayList = new ArrayList<String>();
		strArrayList.add("What");
		strArrayList.add("an");
		strArrayList.add("amazing!");
		System.out.println(strArrayList.toString());
	}

}
