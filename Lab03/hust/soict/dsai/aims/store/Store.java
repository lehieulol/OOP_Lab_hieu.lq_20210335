package hust.soict.dsai.aims.store;

import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private static final int MAX_VOLUMN = 500;
	DigitalVideoDisc itemInStore[] = new DigitalVideoDisc[Store.MAX_VOLUMN];
	int qtyItem = 0;
	
	public boolean addDVD (DigitalVideoDisc disc) {
		if (this.qtyItem == Store.MAX_VOLUMN) {
			System.out.println("Store full, cannot order more!");
			return false;
		}
		if (Arrays.asList(this.itemInStore).contains(disc)) {
			System.out.println("Item is already in the store");
			return false;
		}
		this.itemInStore[this.qtyItem] = disc;
		this.qtyItem += 1;
		System.out.println("Item is added successfully");
		return true;
	}
	
	public boolean removeDVD (DigitalVideoDisc disc) {
		if (! Arrays.asList(this.itemInStore).contains(disc)) {
			System.out.println("Item is unavailable");
			return false;
		}
		int index = Arrays.asList(this.itemInStore).indexOf(disc);
		for (int i = index; i < this.qtyItem - 1; i++) {
			this.itemInStore[i] = this.itemInStore[i+1];
		}
		this.itemInStore[this.qtyItem - 1] = new DigitalVideoDisc("<Deleted Token>");
		this.qtyItem -= 1;
		System.out.println("Item is removed successfully");
		return true;
	}
}
