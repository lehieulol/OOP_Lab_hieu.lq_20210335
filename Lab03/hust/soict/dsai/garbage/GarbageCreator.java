package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		String filename = "C:\\Users\\HH\\eclipse-workspace\\OOP_lab_5\\src\\hust\\soict\\dsai\\garbage\\fuzzy_q-charging_Paper_CoLe.pptx";
		byte[] inputByte = {0};
		inputByte = Files.readAllBytes(Path.of(filename));
		long start = System.nanoTime();
		String s = "";
		for (byte b : inputByte) {
			s+=(char)b;
		}
		System.out.println((System.nanoTime() - start)/1000000 + " ms");
		System.out.println(s);
	}

}
