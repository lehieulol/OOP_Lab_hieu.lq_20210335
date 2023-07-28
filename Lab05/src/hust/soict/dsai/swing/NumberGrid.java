package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] btnNumber = new JButton[10];
	private JButton btnDel, btnReset;
	private JTextField tfDisplay;
	
	public NumberGrid() {
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panelBtn = new JPanel(new GridLayout(4,3));
		addButton(panelBtn);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelBtn, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("NumberGrid");
		this.setSize(200, 200);
		this.setVisible(true);
	}
	
	private void addButton(JPanel pn) {
		ButtonListener btnListener = new ButtonListener();
		for(int i = 1; i<= 9; i++) {
			btnNumber[i] = new JButton(""+i);
			pn.add(btnNumber[i]);
			btnNumber[i].addActionListener(btnListener);
		}
		btnDel = new JButton("DEL");
		pn.add(btnDel);
		btnDel.addActionListener(btnListener);
		
		btnNumber[0] = new JButton("0");
		pn.add(btnNumber[0]);
		btnNumber[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		pn.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText()+button);
			}else if(button.equals("DEL")) {
				tfDisplay.setText(tfDisplay.getText().substring(0, Math.max(0, tfDisplay.getText().length()-1)));
			}else if(button.equals("C")) {
				tfDisplay.setText("");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new NumberGrid();
	}

}
