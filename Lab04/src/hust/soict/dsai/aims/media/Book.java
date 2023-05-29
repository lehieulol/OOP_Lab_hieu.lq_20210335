package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.Menu;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class Book extends Media{
	private ArrayList<String> author;
	
	// Builder	
	public static class Builder extends Media.Builder{
		ArrayList<String> author = new ArrayList<String>();
		public Builder() {};
		
		public Builder author(ArrayList<String> author) {
			this.author = author;
			return this.self();
		}
		protected Builder self() {
			return (Builder) this;
		}
		public Book autoPrompt(Scanner ui) {
			System.out.println("Input authors:");
			while(true) {
				String author = ui.nextLine();
				if(author.equals("")) break;
				this.author.add(author);
			}
			return (Book) super.autoPrompt(ui);
		}
		@Override
		protected Book internalBuild() {
			return new Book(this);
		}
	}
	public static Builder builder() {
		return new Builder();
	}
	// Builder Constructor
	public Book(Builder builder) {
		super(builder);
		this.author = builder.author;
	}
	public ArrayList<String> getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return String.format("Book - Author: %s\t- %s\t", this.author.toString(), super.toString());
	}
	@Override
	public Menu input(Scanner ui, Aims mainMenu, Store store, Cart cart) {
		byte input = ui.nextByte();
		ui.nextLine();
		switch (input) {
		case 1:
			cart.add(this);
			return null;
		case 2:
			System.out.println("Media is unplayable");
			return null;
		case 0:
			return cart;
		default:
			return null;
		}
	}
}
