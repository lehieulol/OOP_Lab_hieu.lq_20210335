package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Scanner;

import hust.soict.dsai.aims.Menu;

public abstract class Media implements Comparable<Media>, Menu{
	int id;
	String title, category;
	float cost;
	static private int idNext = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new CompareTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new CompareCostTitle();
	
	public abstract static class Builder{
		int id;
		String title = "", category = "";
		float cost = 0;
		public Builder() {};
		
		public Builder title(String title) {
			this.title = title;
			return this.self();
		}
		public Builder category(String category) {
			this.category = category;
			return this.self();
		}
		public Builder cost(float cost) {
			this.cost = cost;
			return this.self();
		}
		protected Builder self() {
			return (Builder) this;
		}
		public Media autoPrompt(Scanner ui) {
			System.out.print("Input title: ");
			String title = ui.nextLine();
			this.title(title);
			System.out.print("Input category: ");
			String category = ui.nextLine();
			this.category(category);
			System.out.print("Input cost: ");
			float cost = ui.nextFloat();
			ui.nextLine();
			this.cost(cost);
			return this.build();
		}
		protected abstract Media internalBuild();
		public Media build() {
			return internalBuild();
		}
	}
	
	public Media(Builder builder){
		this.id = Media.idNext++;
		this.title = builder.title;
		this.category = builder.category;
		this.cost = builder.cost;
	}
	
	public static class CompareCostTitle implements Comparator<Media>{

		@Override
		public int compare(Media o1, Media o2) {
			float c1 = o1.cost, c2 = o2.cost;
			String t1 = o1.title, t2 = o2.title;
			if (c1<c2) {
				return -1;
			}
			if (c1>c2) {
				return 1;
			}
			return t1.compareTo(t2);
		}
		
	}
	
	public static class CompareTitleCost implements Comparator<Media>{

		@Override
		public int compare(Media o1, Media o2) {
			float c1 = o1.cost, c2 = o2.cost;
			String t1 = o1.title, t2 = o2.title;
			int t = t1.compareTo(t2);
			if (t != 0) return t;
			if (c1<c2) {
				return -1;
			}
			if (c1>c2) {
				return 1;
			}
			return 0;
		}
		
	}
	
	
	/*
	 * Media should implement Comparable
	 * Implement like below
	 * We can't use 2 ordering rule using this approach
	 * We can do DVD implements Comparable<DVD> and change compareTo accordingly
	 */
	@Override
	public int compareTo(Media m2) {
		float c1 = this.cost, c2 = m2.cost;
		String t1 = this.title, t2 = m2.title;
		if (c1<c2) {
			return -1;
		}
		if (c1>c2) {
			return 1;
		}
		return t1.compareTo(t2);
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public String toString() {
		return String.format("Title: %s\t- Category: %s\t - Cost: %.2f$", this.title, this.category, this.cost);
	}
	public boolean isMatch(int id) {
		if(this.id == id) {
			return true;
		}
		return false;
	}
	public boolean equals(Media media) {
		if (this.title == media.title) {
			return true;
		}
		return false;
	}
	
	public String show() {
		System.out.println("Media Information:");
		System.out.println(this.toString());
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		return "Please choose a number: 0-1-2"; 
	}
	//If the passing object is not an instance of Media, what happens? It will use the default equals
}
