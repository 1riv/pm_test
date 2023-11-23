package week12;

import java.io.*;

public class BinaryCopyEx {
	public static void main(String[] args) {
		int c;
		
		try {
			FileInputStream fi = new FileInputStream("/Users/igjeong/Downloads/img.png");
			FileOutputStream fo = new FileOutputStream("/Users/igjeong/Downloads/copied_img.png");
			
			while ((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println("File Copied!");
		} catch (IOException e) {
			System.out.println("File Copy Error!");
		}
	}
}
