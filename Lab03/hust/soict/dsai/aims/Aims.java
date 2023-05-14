package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

// Execise 5
public class Aims {

	public static void main(String[] args) {
		// Execise 10
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Was", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		anOrder.addDigitalVideoDisc(dvd1,dvd2);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		// Execise 11
		anOrder.removeDigitalVideoDisc(dvd3);
		
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
