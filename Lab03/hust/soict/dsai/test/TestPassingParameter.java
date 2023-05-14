package hust.soict.dsai.test;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderelaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderelaDVD);
		System.out.println("jungle dvd title: "+jungleDVD.getTitle());
		System.out.println("cinderela dvd title: "+cinderelaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderelaDVD.getTitle());
		System.out.println("jungle dvd title: "+jungleDVD.getTitle());
	}
	
	public static void swap(Object a, Object b) {
		Object tmp = a;
		a = b;
		b = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	public static void swap(DigitalVideoDisc a, DigitalVideoDisc b) {
		DigitalVideoDisc tmp = new DigitalVideoDisc("");
		tmp.shallow_copy(a);
		a.shallow_copy(b);
		b.shallow_copy(tmp);
	}
	
}
