package Lab01;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class OOP_lab_2_2_6 extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7795228191099026087L;
	protected JTextField[][] a = new JTextField[2][3];
    protected JTextArea result;
    protected JButton calc[] = new JButton[2];
	public OOP_lab_2_2_6() {
		
		calc[0] = new JButton("Quadratic");
		calc[0].addActionListener(this);
		
		calc[1] = new JButton("Linear system");
		calc[1].addActionListener(this);
		
        result = new JTextArea(3,20);
        result.setEditable(false);

        
        //Add Components to this panel.
        setLayout(new GridLayout(2,4));
        for (int i = 0; i < 2; i++) {
        	for (int j = 0; j < 3; j++) {
        		a[i][j] = new JTextField();
        		add(a[i][j]);
        	}
        	add(calc[i]);
        	if(i == 0) {
        		add(result);
        	}
        }
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		result.setText("");
		//System of linear equation
		if(evt.getSource() == calc[1]) {
			String[][] sinp = new String[2][3];
			Double[][] inp = new Double[2][3];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 3; j++) {
					sinp[i][j] = a[i][j].getText();
				}
			}
			try {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 3; j++) {
						inp[i][j] = Double.parseDouble(sinp[i][j]);
					}
				}
			}catch (NumberFormatException ex){
				result.setText("Number Format Error");
				return;
			}
			if (inp[0][0] == 0) {
				if (inp[1][0] == 0) {
					if (inp[0][1]*inp[1][2] != inp[1][1]*inp[0][2]) {
						result.setText("No Solution");
						return;
					}
				}else {
					Double temp[] = inp[0];
					inp[0] = inp[1];
					inp[1] = temp;
				}
			}
			for (int i = 2; i >= 0; i--) {
				inp[1][i] = inp[1][i]*inp[0][0] - inp[0][i]*inp[1][0];
			}
			
			for (Double[] i : inp) {
				for (Double j : i) {
					System.out.print(String.format("%f ", j));
				}
				System.out.println();
			}
			
			if (inp[1][1] == 0) {
				if (inp[1][2] == 0) {
					if (inp[0][0] == 0) {
						if (inp[0][1] == 0) {
							if (inp[0][2] == 0) {
								result.setText("Infinite Solution");
							}else {
								result.setText("No Solution");
							}
						}else {
							result.setText(String.format("Infinite Solution\n y = %f", inp[0][2]/inp[0][1]));
						}
					}else {
						if (inp[0][1] == 0) {
							result.setText(String.format("Infinite Solution\n x = %f", inp[0][2]/inp[0][0]));
						}else {
							result.setText(String.format("Infinite Solution\n %.2fx + %.2fy = %.2f", inp[0][0], inp[0][1], inp[0][2]));
						}
					}
				}else {
					result.setText("No Solution");
				}
			}else {
				Double y = inp[1][2]/inp[1][1];
				Double x = (inp[0][2] - inp[0][1]*y)/inp[0][0];
				result.setText(String.format("x = %f\ny = %f", x, y));
			}
		}
		//Quadratic equation
		if(evt.getSource() == calc[0]) {
			String[] sinp = new String[3];
			Double[] inp = new Double[3];
			for (int j = 0; j < 3; j++) {
				sinp[j] = a[0][j].getText();
			}
			try {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 3; j++) {
						inp[j] = Double.parseDouble(sinp[j]);
					}
				}
			}catch (NumberFormatException ex){
				result.setText("Number Format Error");
				return;
			}
	        String sres = "";
	        if (inp[0] == 0) {
	        	if (inp[1] == 0) {
	        		if (inp[2] == 0) {
	        			sres = "Infinite Solution";
	        		}else sres = "No Solution";
	        	}else {
	        		sres = String.valueOf(inp[2]/inp[1]);
	        	}	
	        }else {
	        	Double delta = Math.pow(inp[1], 2) - 4*inp[0]*inp[2];
	        	if (delta < 0) {
	        		sres = "No Solution";
	        	}else if (delta == 0) {
	        		sres = String.valueOf(-inp[1]/inp[0]/2);
	        	}else {
	        		sres = String.valueOf((-inp[1]+Math.sqrt(delta))/(2*inp[0])) + "\n" + String.valueOf((-inp[1]-Math.sqrt(delta))/(2*inp[0]));
	        	}
	        }			
	        result.setText(sres);
		}
		
    }
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("2.2.6 a.k.a Quadratic Solver / 2 2 Linear System Solver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new OOP_lab_2_2_6());
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {createAndShowGUI();}});
	}
}
