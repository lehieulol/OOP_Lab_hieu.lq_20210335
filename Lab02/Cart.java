import java.util.Arrays;


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
}
