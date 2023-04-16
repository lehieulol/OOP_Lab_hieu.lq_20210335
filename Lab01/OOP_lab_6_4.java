package Lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OOP_lab_6_4 {

	public OOP_lab_6_4() {
		// pass
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println("Input year:");
			int year = 0;
			try {
				year = keyboard.nextInt();
			}catch (InputMismatchException ex) {
				System.out.println("Year Format Error");
				keyboard.nextLine();
				continue;
			}
			if (year < 0) {
				System.out.println("Negative Year");
				continue;
			}
			String smonth = "";
			String[][] month_input = {{"January", "Jan.", "Jan", "1"},
					{"February", "Feb.", "Feb", "2"},
					{"March", "Mar.", "Mar", "3"},
					{"April", "Apr.", "Apr", "4"},
					{"May", "5"},
					{"June", "Jun", "6"},
					{"July", "Jul", "7"},
					{"August", "Aug.", "Aug", "8"},
					{"September", "Sept.", "Sep", "9"},
					{"October", "Oct.", "Oct", "10"},
					{"November", "Nov.", "Nov", "11"},
					{"December", "Dec.", "Dec", "12"}};
			int[][] month_data = {{31,31},{28,29},{31,31},{30,30},{31,31},{30,30},{31,31},{31,31},{30,30},{31,31},{30,30},{31,31}};
			System.out.println("Input month:");
			keyboard.nextLine();
			smonth = keyboard.nextLine();
			int month;
			boolean found = false;
			for (month = 0; month < 12; month++) {
				for (String i : month_input[month]) {
					if (smonth.equals(i)) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				System.out.println("Month Format Error");
				continue;
			}
			int nhuan = 0;
			if (year % 100 == 0) {
				year /= 100;
			}
			if (year % 4 == 0) {
				nhuan = 1;
			}
			System.out.println(month_data[month][nhuan]);
			break;
		}
		keyboard.close();
	}

}
