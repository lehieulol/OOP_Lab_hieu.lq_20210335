package hust.soict.dsai.test;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		//Disc dvd1 = (DIs DigitalVideoDisc.builder().directory("Roger Aller").title("The Lion King").category("Animation").cost(19.95f).build();
		System.out.println(DigitalVideoDisc.builder().title("The Lion King").getClass());//.directory("Roger Aller").category("Animation").cost(19.95f).build()
	}
}
