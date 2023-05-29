package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestMediaBuilder {

	public static void main(String[] args) {
		DigitalVideoDisc a = (DigitalVideoDisc) DigitalVideoDisc.builder().length(50).directory("dir").category("Music").cost(10.5f).title("CD1").build();
		a.show();
		System.out.print(a.toString());
	}

}
