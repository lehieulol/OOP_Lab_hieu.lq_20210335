package hust.soict.dsai.aims.cart;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class Cart {
	// Execise 9
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int qtyOrdered;
	
	public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered == Cart.MAX_NUMBER_ORDERED) {
			System.out.println("Cart full, cannot order more!");
			return false;
		}
		if (Arrays.asList(this.itemOrdered).contains(disc)) {
			System.out.println("Item is already in the cart");
			return false;
		}
		this.itemOrdered[this.qtyOrdered] = disc;
		this.qtyOrdered += 1;
		System.out.println("Item is added successfully");
		return true;
	}
	
	public int addDigitalVideoDisc(DigitalVideoDisc[] disc) {
		int count = 0;
		for(DigitalVideoDisc i : disc) {
			boolean a = this.addDigitalVideoDisc(i);
			if (a) {
				count++;
			}
		}
		return count;
	}
	/*
	 * I prefer array approach since it give me easier way to call it. Also both method is duplicate so only 1 can be chose.
	public int addDigitalVideoDisc(DigitalVideoDisc... disc) {
		int count = 0;
		for(DigitalVideoDisc i : disc) {
			boolean a = this.addDigitalVideoDisc(i);
			if (a) {
				count++;
			}
		}
		return count;
	}
	*/
	
	public int addDigitalVideoDisc(DigitalVideoDisc disc, DigitalVideoDisc disc2) {
		int count = 0;
		boolean a = this.addDigitalVideoDisc(disc);
		if (a) {count++;}
		a = this.addDigitalVideoDisc(disc2);
		if (a) {count++;}
		return count;
	}
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (! Arrays.asList(this.itemOrdered).contains(disc)) {
			System.out.println("Item is unavailable");
			return false;
		}
		int index = Arrays.asList(this.itemOrdered).indexOf(disc);
		for (int i = index; i < this.qtyOrdered - 1; i++) {
			this.itemOrdered[i] = this.itemOrdered[i+1];
		}
		this.itemOrdered[this.qtyOrdered - 1] = new DigitalVideoDisc("<Deleted Token>");
		this.qtyOrdered -= 1;
		System.out.println("Item is removed successfully");
		return true;		
	}
	
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < this.qtyOrdered; i++) {
			sum += this.itemOrdered[i].getCost();
		}
		return sum;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < this.qtyOrdered; i++) {
			System.out.println(String.format("%d. %s", i+1, this.itemOrdered[i].toString()));
		}
		System.out.println(String.format("Total cost: %.2f $", this.totalCost()));
	}
	
	public boolean search(int id) {
		for (int i = 0; i < this.qtyOrdered; i++) {
			if (this.itemOrdered[i].isMatch(id)) {
				System.out.println("Item found: " + this.itemOrdered[i].toString());
				return true;
			}
		}
		System.out.println("Item not found.");
		return false;
	}
}
