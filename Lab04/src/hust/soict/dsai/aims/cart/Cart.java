package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.Menu;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Cart implements Menu{
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	
	public boolean add(Media media) {
		if (this.itemOrdered.contains(media)) {
			System.out.println("Item is already in the cart");
			return false;
		}
		this.itemOrdered.add(media);
		System.out.println("Item is added successfully");
		return true;
	}
	
	public int add(ArrayList<Media> medias) {
		int count = 0;
		for(Media media: medias) {
			boolean a = this.add(media);
			if (a) {
				count++;
			}
		}
		return count;
	}
	
	public boolean remove(Media media) {
		if (! this.itemOrdered.remove(media)) {
			System.out.println("Item is unavailable");
			return false;
		}
		System.out.println("Item is removed successfully");
		return true;		
	}
	
	public float totalCost() {
		float sum = 0;
		for (Media media : this.itemOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int i = 0;
		for (Media media : this.itemOrdered) {
			System.out.println(String.format("%d. %s", ++i, media.toString()));
		}
		System.out.println(String.format("Total cost: %.2f $", this.totalCost()));
	}
	
	public Media search(int id) {
		for (Media media : this.itemOrdered) {
			if (media.isMatch(id)) {
				System.out.println("Item found: " + media.toString());
				return media;
			}
		}
		System.out.println("Item not found.");
		return null;
	}
	
	public Media search(String title) {
		for (Media media : this.itemOrdered) {
			if (media.getTitle().equals(title)) {
				System.out.println("Item found: " + media.toString());
				return media;
			}
		}
		System.out.println("Item not found.");
		return null;
	}

	@Override
	public String show() {
		this.print();
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Search medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		return "Please choose a number: 0-1-2-3-4";
	}

	@Override
	public Menu input(Scanner ui, Aims mainMenu, Store store, Cart cart) {
		byte input = ui.nextByte();
		ui.nextLine();
		switch (input) {
		case 1:
			while (true) {
				System.out.println("Search by title (0) or Search by id (1)? Enter 2 to exit");
				input = ui.nextByte();
				ui.nextLine();
				switch (input) {
				case 0:
					System.out.println("Enter title:");
					String title = ui.nextLine();
					return search(title);
				case 1:
					System.out.println("Enter id:");
					int id = ui.nextInt();
					ui.nextLine();
					return search(id);
				case 2:
					return null;
				}
			}
		case 2:
			while(true) {
				System.out.println("Sort by title (0) or Sort by id (1)? Enter 2 to exit");
				input = ui.nextByte();
				ui.nextLine();
				switch (input) {
				case 0:
					this.itemOrdered.sort(Media.COMPARE_BY_TITLE_COST);
					return this;
				case 1: 
					this.itemOrdered.sort(Media.COMPARE_BY_COST_TITLE);
					return this;
				case 2:
					return null;
				}
			}
		case 3:
			while (true) {
				System.out.println("Remove by title (0) or Remove by id (1)? Enter 2 to exit");
				input = ui.nextByte();
				ui.nextLine();
				switch (input) {
				case 0:
					System.out.println("Enter title:");
					String title = ui.nextLine();
					cart.remove(search(title));
					return this;
				case 1:
					System.out.println("Enter id:");
					int id = ui.nextInt();
					ui.nextLine();
					cart.remove(search(id));
					return this;
				case 2:
					return null;
				}
			}
		case 4:
			this.itemOrdered.clear();
			System.out.println("Items ordered successfully!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		case 0:
			return store;
		default:
			return null;
		}
	}
}
