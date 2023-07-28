package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField tfInput, tfOutput;
	private int sum = 0;
	public AWTAccumulator() {
		this.setLayout(new GridLayout(2,2));
		
		this.add(new Label("Enter an integer:"));
		tfInput = new TextField(10);
		tfInput.addActionListener(new TFInputListener());
		this.add(tfInput);
		
		this.add(new Label("Accumulated sum:"));
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		this.add(tfOutput);
		
		this.setTitle("AWT Accumulator");
		this.setSize(350, 120);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
		
	public static void main(String args[]) {
		new AWTAccumulator();
	}
	
	private class TFInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int in;
			try {
				in = Integer.parseInt(tfInput.getText());
			}catch (NumberFormatException e1){
				e1.printStackTrace(System.out);
				tfInput.setText("");
				return;
			}
			
			sum += in;
			tfInput.setText("");
			tfOutput.setText(""+sum);
		}
		
	}
}
