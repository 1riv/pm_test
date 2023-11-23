package week12;

import java.io.*;

public class FileOutputSreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b[] = {7, 51, 3, 4, -1, 24};
		
		try {
			FileOutputStream fout = new FileOutputStream("/Users/igjeong/Downloads/test.out");
			
			for (int i = 0; i < b.length; i++) {
				fout.write(b[i]);
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("Could not store /Users/igjeong/Downloads/test.out"
		+ e.getMessage());
			return;
		}
		System.out.println("/Users/igjeong/Downloads/test.out successfully stored");
	}

}
