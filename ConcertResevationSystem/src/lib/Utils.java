package lib;

public class Utils {
	public static void Divider() {
        for (int i = 0; i < 40; i++) {
            System.out.print("=");
        }
        System.out.println();
	}
	public static void fSquare() {
		System.out.print("\u25A0 ");
	}
	public static void eSquare() {
		System.out.print("\u25A1 ");
	}
	
	public static void SeatingPlan() {
		for (int i=0; i<19; i++) System.out.print("__");
		
		System.out.println();
		System.out.print("|    ");
		for (int i=0; i<15; i++) eSquare();
		System.out.print("V석 |");
		
		System.out.println();
		System.out.print("|    ");
		for (int i=0; i<15; i++) eSquare();
		System.out.print("S석 |");
		
		System.out.println();
		System.out.print("|  ");
		for (int i=0; i<8; i++) eSquare();
		System.out.print("  ");
		for (int i=0; i<8; i++) eSquare();
		System.out.println(" |");
		
		System.out.print("|  ");
		for (int i=0; i<7; i++) eSquare();
		System.out.print("      ");
		for (int i=0; i<7; i++) eSquare();
		System.out.println(" |");
		
		for (int i=0; i<19; i++) System.out.print("__");
		System.out.println();
	}
}
