package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Scanner;

public class CompactDisc extends Disc{
	
	String artist;
	ArrayList<Track> tracks;
	//Builder
	public static class Builder extends Disc.Builder{
		String artist;
		ArrayList<Track> tracks = new ArrayList<Track>();
		public Builder() {};
		public Builder artist(String artist) {
			this.artist = artist;
			return this.self();
		}
		public Builder tracks(ArrayList<Track> tracks) {
			this.tracks = tracks;
			return this.self();
		}
		protected Builder self() {
			return (Builder) this;
		}
		public CompactDisc autoPrompt(Scanner ui) {
			System.out.print("Input artist: ");
			String artist = ui.nextLine();
			this.artist(artist);
			System.out.println("Input tracks:");
			while(true) {
				Track track = Track.autoPrompt(ui);
				if(track.equals(new Track("",0))) break;
				this.tracks.add(track);
			}
			return (CompactDisc) super.autoPrompt(ui);
		}
		protected CompactDisc internalBuild() {
			return new CompactDisc(this);
		}
	}
	public static Builder builder() {
		return new Builder();
	}
	//Constructor
	public CompactDisc(Builder builder) {
		super(builder);
		this.artist = builder.artist;
		this.tracks = builder.tracks;
	}
	
	public boolean addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Track already existed");
			return false;
		}
		this.tracks.add(track);
		System.out.println("Track added successfully");
		return true;
	}
	
	public boolean removeTrack(Track track) {
		if(!tracks.remove(track)) {
			System.out.println("Track not existed");
			return false;
		}
		return true;
	}
	
	public String getArtist() {
		return artist;
	}

	public int getLength() {
		int sum = 0;
		for(Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	public String toString() {
		return String.format("CompactDisc - Artist: %s\t- Contain: %d tracks\t- Total length: %d\t- %s", this.getArtist(), this.tracks.size(), this.getLength(), super.toString().substring(7));
	}
	
	@Override
	public void play() {
		System.out.println("Playing compact disc: " + this.getTitle() + " by " + this.getArtist()); 
		System.out.println("Compact disc length: " + this.getLength());
		for(Track track : tracks) {
			track.play();
		}
	}
}
