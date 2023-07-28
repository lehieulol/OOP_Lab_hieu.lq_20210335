package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public interface Menu {
	/**
	Show menu correspond to the object
	@param 
	@return A string which is Input prompt for this menu
	@throws
	*/
	public String show();
	public Menu input(Scanner ui, Aims mainMenu, Store store, Cart cart);
}
