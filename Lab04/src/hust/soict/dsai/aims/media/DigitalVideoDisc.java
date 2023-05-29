package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc{
	
	public static class Builder extends Disc.Builder{
		public Builder() {};
		protected Builder self() {
			return (Builder) this;
		}
		public DigitalVideoDisc autoPrompt(Scanner ui) {
			return (DigitalVideoDisc) super.autoPrompt(ui);
		}
		@Override
		public DigitalVideoDisc internalBuild() {
			return new DigitalVideoDisc(this);
		}
	}
	public static Builder builder() {
		return new Builder();
	}
	public DigitalVideoDisc(Builder builder) {
		super(builder);
	}
	
	@Override
	public String toString() {
		return String.format("DVD - %s", super.toString().substring(7));
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength());
	}
}
