package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class Track implements Playable{
	String title = "";
	int length = 0;		
	public Track(String title) {
		this.title = title;
	}
	public Track(int length) {
		this.length = length;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public static Track autoPrompt(Scanner ui) {
		System.out.print("Input title: ");
		String title = ui.nextLine();
		System.out.print("Input length: ");
		int length = ui.nextInt();
		ui.nextLine();
		return new Track(title, length);
	}
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle()); 
		System.out.println("Track length: " + this.getLength());
	}
	public boolean equals(Track track) {
		if(this.title == track.title && this.length == track.length) {
			return true;
		}
		return false;
	}
}
