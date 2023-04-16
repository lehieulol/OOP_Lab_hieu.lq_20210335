package Lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OOP_lab_6_3 {

	public OOP_lab_6_3() {
		// pass
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println("Input n:");
			int n = 0;
			try {
				n = keyboard.nextInt();
			}catch (InputMismatchException ex) {
				System.out.println("Format Error");
				keyboard.nextLine();
				continue;
			}
			if(n <= 0) {
				System.out.println("Negative input");
				continue;
			}
			for (int i = 0; i < n; i++) {
				System.out.print(" ".repeat(n-i-1));
				System.out.print("*".repeat(2*i+1));
				System.out.println(" ".repeat(n-i-1));
			}
			break;
		}
		keyboard.close();
	}

}
