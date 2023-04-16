package Lab01;

import java.util.Scanner;

public class OOP_lab_6_2 {

	public OOP_lab_6_2() {
		// pass
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = keyboard.nextLine();
		System.out.println("How old are you?");
		int age = keyboard.nextInt();
		System.out.println("How tall are you?");
		Double height = keyboard.nextDouble();
		keyboard.close();
		System.out.println(String.format("Mr/Mrs. %s, %d years old. Your height is %f.", name, age, height));
	}

}
