package hust.soict.dsai.aims.media;

import java.util.Scanner;

import hust.soict.dsai.aims.Aims;
import hust.soict.dsai.aims.Menu;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class Disc extends Media implements Playable{
	private String directory;
	private int length;
	
	public static class Builder extends Media.Builder{
		private String directory = "";
		private int length = 0;
		public Builder() {};
		
		public Builder directory(String directory) {
			this.directory = directory;
			return this.self();
		}
		
		public Builder length(int length) {
			this.length = length;
			return this.self();
		}
		protected Builder self() {
			return (Builder) this;
		}
		public Disc autoPrompt(Scanner ui) {
			System.out.print("Input director: ");
			String director = ui.nextLine();
			this.directory(director);
			System.out.print("Input length: ");
			int length = ui.nextInt();
			ui.nextLine();
			this.length(length);
			return (Disc) super.autoPrompt(ui);
		}
		@Override
		protected Disc internalBuild() {
			return new Disc(this);
		}
	}
	public static Builder builder() {
		return new Builder();
	}
	public Disc(Builder builder) {
		super(builder);
		this.directory = builder.directory;
		this.length = builder.length;
	}

	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public String toString() {
		return String.format("Disc - Length: %d\t- Director: %s\t- %s", this.length, this.directory, super.toString());
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
			this.play();
			return null;
		case 0:
			return cart;
		default:
			return null;
		}
	}
	@Override
	public void play() {
		//Do nothing
	}
}
