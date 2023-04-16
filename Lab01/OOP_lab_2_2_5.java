package Lab01;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class OOP_lab_2_2_5 extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5794017448102483929L;
	protected JTextField firstNumber, secondNumber, operator;
    protected JTextArea result;
    protected JButton calc;
	public OOP_lab_2_2_5() {		 
		firstNumber = new JTextField(10);
		operator = new JTextField(10);
		secondNumber = new JTextField(10);
		calc = new JButton("Calculate");
		calc.addActionListener(this);
		
        result = new JTextArea(2, 20);
        result.setEditable(false);
        
        //Add Components to this panel.
        setLayout(new GridLayout(4,2));
        
        JTextField temp = new JTextField("1st number:");
        temp.setEditable(false);
        add(temp);
        add(firstNumber);
        

        temp = new JTextField("Operator:");
        temp.setEditable(false);
        add(temp);
        add(operator);

        temp = new JTextField("2nd number:");
        temp.setEditable(false);
        add(temp);
        add(secondNumber);
        
        add(calc);
        
        add(result);
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		result.setText("");
		String sf = firstNumber.getText(), o = operator.getText(), ss = secondNumber.getText();
		Double f, s, res = 0.0;
		try {
			f = Double.parseDouble(sf); s = Double.parseDouble(ss);
		}catch (NumberFormatException ex){
			result.setText("Number Format Error");
			return;
		}
        switch (o){
        case "+":
        	res = f+s;
        	break;
        case "-":
        	res = f-s;
        	break;
        case "*":
        	res = f*s;
        	break;
        case "/":
        	res = f/s;
        	break;
        default:{
        	result.setText("Operator format error");
        	return;
        }
        }
        String sres = String.valueOf(res);
        result.setText(sres);
    }
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("2.2.5 a.k.a Basic operator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new OOP_lab_2_2_5());
		frame.pack();
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {createAndShowGUI();}});
	}
}
