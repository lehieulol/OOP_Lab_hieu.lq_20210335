package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Container;
import java.awt.GridLayout;

public class SwingAccumulator extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfInput, tfOutput;
	private int sum = 0;
	public SwingAccumulator() {
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(2,2));
		
		cp.add(new JLabel("Enter an integer:"));
		tfInput = new JTextField(10);
		tfInput.addActionListener(new TFInputListener());
		cp.add(tfInput);
		
		cp.add(new JLabel("Accumulated sum:"));
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		this.setTitle("Swing Accumulator");
		this.setSize(350, 120);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
	public static void main(String args[]) {
		new SwingAccumulator();
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
