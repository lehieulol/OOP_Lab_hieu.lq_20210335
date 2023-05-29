package hust.soict.dsai.aims.store;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.Menu;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class Store implements Menu{
	ArrayList<Media> itemInStore = new ArrayList<Media>();
	
	public boolean add (Media media) {
		if (this.itemInStore.contains(media)) {
			return false;
		}
		this.itemInStore.add(media);
		return true;
	}
	
	public boolean remove(Media media) {
		if (!this.itemInStore.remove(media)) {
			return false;
		}
		return true;
	}
	
	private void printMedia() {
		for(Media media:itemInStore) {
			System.out.println(media.toString());
		}
	}
	
	private Media findMedia(Scanner ui) {
		System.out.println("Input media name:");
		String title = ui.nextLine();
		for(Media media:itemInStore) {
			if (media.getTitle().equals(title)) {
				System.out.println("Media found!");
				return media;
			}
		}
		System.out.println("Media not found.");
		return null;
	}
	public void update(Scanner ui) {
		try{
			System.out.print("Remove (0) or Add (1) Media? ");
			byte input = ui.nextByte();
			ui.nextLine();
			switch (input) {
			case 0:
				this.remove(findMedia(ui));
				return;
			case 1:
				System.out.print("Add DVD (0) || CompactDisc (1) || Disc (2) || Book (3)? ");
				input = ui.nextByte();
				ui.nextLine();
				switch (input) {
				case 0:
					this.add(DigitalVideoDisc.builder().autoPrompt(ui));
					return;
				case 1:
					this.add(CompactDisc.builder().autoPrompt(ui));
					return;
				case 2:
					this.add(Disc.builder().autoPrompt(ui));
					return;
				case 3:
					this.add(Book.builder().autoPrompt(ui));
					return;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			return;
		}
	}
	
	@Override
	public String show() {
		System.out.println("Store: "); 
		System.out.println("Item avaiable: "); 
		System.out.println("--------------------------------"); 
		printMedia();
		System.out.println("--------------------------------"); 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		return "Please choose a number: 0-1-2-3-4"; 
	}

	@Override
	public Menu input(Scanner ui, Aims mainMenu, Store store, Cart cart) {
		byte input = ui.nextByte();
		ui.nextLine();
		Media temp;
		switch (input) {
		case 0:
			return mainMenu;
		case 1:
			temp = this.findMedia(ui);
			if (temp == null) return null;
			return temp;
		case 2:
			temp = this.findMedia(ui);
			if (temp == null) return null;
			cart.add(temp);
			return null;
		case 3:
			temp = this.findMedia(ui);
			if (temp == null) return null;
			boolean hasMethod = false;
			Method[] methods = temp.getClass().getMethods();
			for (Method m : methods) {
				if (m.getName().equals("play")) {
					hasMethod = true;
					try {
						m.invoke(temp, new Object[] {});
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			if(!hasMethod) {
				System.out.println("Media is unplayable!!!");
			}
			return null;	
		case 4:
			return cart;
		default:
			return null;
		}
	}
}
