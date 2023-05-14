package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoop {

	public static void main(String[] args) {
		Random r = new Random(123);
		long start = System.nanoTime();
		String s = "";
		for (int i = 0; i < 60000; i++) {
			s+=r.nextInt(2);
		}
		System.out.println((System.nanoTime() - start)/1000000 + " ms");
		
		r = new Random(123);
		start = System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 60000; i++) {
			sb.append(r.nextInt(2));
		}
		s = sb.toString();
		System.out.println((System.nanoTime() - start)/1000000 + " ms");
	}

}
