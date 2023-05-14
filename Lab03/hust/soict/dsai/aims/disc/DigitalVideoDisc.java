package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String directory;
	private int length;
	private float cost = 0;
	private int id;
	
	private static int nbDigitalVideoDisc = 0;
	
	public DigitalVideoDisc(String title) {
		super();
		this.id = DigitalVideoDisc.nbDigitalVideoDisc++;
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.id = DigitalVideoDisc.nbDigitalVideoDisc++;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		this.id = DigitalVideoDisc.nbDigitalVideoDisc++;
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.id = DigitalVideoDisc.nbDigitalVideoDisc++;
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
	}

	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirectory() {
		return directory;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void shallow_copy(DigitalVideoDisc b) {
		this.title = b.title;
		this.category = b.category;
		this.directory = b.directory;
		this.length = b.length;
		this.cost = b.cost;
	}
	public String toString() {
		return String.format("DVD - %s - %s - %s - %d: %.2f $", this.title, this.category, this.directory, this.length, this.cost);
	}
	public boolean isMatch(int id) {
		if (this.id == id) {
			return true;
		}
		return false;
	}
}
