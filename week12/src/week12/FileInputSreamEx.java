package week12;

import java.io.*;

public class FileInputSreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b[] = new byte[6];
		
		try {
			FileInputStream fin = new FileInputStream("/Users/igjeong/Downloads/test.out");
			
			int n = 0, c;
			
			while ((c = fin.read()) != -1) {
				b[n] = (byte)c;
				n++;
			}
			
			System.out.println("Output data from /Users/igjeong/Downloads/test.out ");
					
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i] + " ");
			}
			System.out.println();
			
			fin.close();
			
		} catch (IOException e) {
			System.out.println("Cannot read from /Users/igjeong/Downloads/test.out"
		+ e.getMessage());
		}
		
	}

}
