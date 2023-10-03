
public class WhilesSmple {
	public static void main(String args[]) {
		char c = 'a';
		
		while (c <= 'z') {
			System.out.print(c);
			c = (char)(c + 1);
		}
		System.out.print('\n');
		char v = 'a';
			
		do {
			System.out.print(v);
			v = (char)(v + 1);
		} while(v <= 'z');
		
	}

}
