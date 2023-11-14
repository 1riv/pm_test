import java.util.Scanner;

public class ArrayTest {
	public static void main(String args[]) {
		Scanner ds = new Scanner(System.in);
		int i;
		double sum = 0.0, avg;
		double dnum[] = new double[5];
		
		System.out.println("length of dum array: " + dnum.length);
		System.out.print("uninitialized dum[] values: ");
		
		for (i = 0; i < dnum.length; i++)
			System.out.print(dnum[i]+" ");
			System.out.println();
		
		for (i = 0; i < dnum.length; i++) {
			System.out.print("dnum["+i+"] value: ");
			dnum[i] = ds.nextDouble();
			sum += dnum[i];
		}
		
		avg = sum / dnum.length;
		System.out.println("sum of the array elements: " + sum + "\n" + "the average of the array elemnets: " + avg);
		ds.close();
	}

}
