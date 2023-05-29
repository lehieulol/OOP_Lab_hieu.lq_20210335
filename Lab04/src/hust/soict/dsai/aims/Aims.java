package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;


public class Aims implements Menu{
	private static final String PASSWORD = "20210335";
	public static void clrscr() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	@Override
	public String show() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		return "Please choose a number: 0-1-2-3";
	}
	
	@Override
	public Menu input(Scanner ui, Aims mainMenu, Store store, Cart cart) {
		byte input = ui.nextByte();
		ui.nextLine();
		switch (input) {
		case 2:
			System.out.print("Password: ");
			String password = ui.nextLine();
			if (!password.equals(PASSWORD)) {
				return null;
			}
			store.update(ui);
			return null;
		case 1:
			return store;
		case 3:
			return cart;
		case 0:
			System.exit(0);
		default:
			return null;
		}
	}
	
	public static void main(String[] args){
		Aims mainMenu = new Aims();
		Store store = new Store();
		Cart cart = new Cart();
		Menu current = mainMenu;
		
		DigitalVideoDisc item1 = (DigitalVideoDisc) DigitalVideoDisc.builder().directory("James Cameron").length(1859).cost(14.7f).title("Avatar").category("Science Fiction").build();
		ArrayList<Track> tracks = new ArrayList<Track>();
		tracks.add(new Track("History", 187));
		tracks.add(new Track("Story Of My Life", 245));
		tracks.add(new Track("What Make You Beautiful", 199));
		CompactDisc item2 = (CompactDisc) CompactDisc.builder().tracks(tracks).artist("One Direction").category("Music").cost(5.99f).title("One Direction Album").build();
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Paulo Coelho");
		authors.add("Author token");
		Book item3 = (Book) Book.builder().author(authors).category("Novel").cost(15.99f).title("The Alchemist").build();
		store.add(item1);
		store.add(item2);
		store.add(item3);
		try (Scanner UserInput = new Scanner(System.in)) {
			while (true) {
				String prompt = current.show();
				while (true) {
					System.out.println(prompt);
					Menu temp = current.input(UserInput, mainMenu, store, cart);
					if(temp != null) {
						current = temp;
						Aims.clrscr();
						break;
					}
				}
			}
		}
	}

	

}
