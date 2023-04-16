package Lab01;

import javax.swing.JOptionPane;

public class OOP_lab_6_1 {

	public OOP_lab_6_1() {
		// pass
	}

	public static void main(String[] args) {
		while (true) {
			int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
			int confirm = JOptionPane.showConfirmDialog(null, "You have chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
			if (confirm == JOptionPane.YES_OPTION) {
				break;
			}
		}
	}

}
