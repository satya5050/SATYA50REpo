package GUIBASED;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorGUI {

	private JFrame SATYACALCULATOR;
	private JTextField textField;

	double  first;
	double second;
	double result;
	String operation;
	String  answer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.SATYACALCULATOR.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorGUI() {
		initialize();
	textField.setEditable(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SATYACALCULATOR = new JFrame();
		SATYACALCULATOR.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("GUI WINDOW IS CLOSED");
			}
		});
		SATYACALCULATOR.setBounds(100, 100, 450, 300);
		SATYACALCULATOR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SATYACALCULATOR.getContentPane().setLayout(null);
		SATYACALCULATOR.setTitle("::SATYA:CALCULATOR::");
		SATYACALCULATOR.setSize(410,270);

		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton.getText();
				textField.setText(number);
				textField.setText(number);
			}
		});
		btnNewButton.setBounds(0, 57, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_1.getText();
			}
		});
		btnNewButton_1.setBounds(96, 57, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_2.getText();
				textField.setText(number);
			}
		});
		btnNewButton_2.setBounds(189, 57, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("3");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_3.getText();
				textField.setText(number);
			}
		});
		btnNewButton_3.setBounds(296, 57, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_4.getText();
				textField.setText(number);
			}
		});
		btnNewButton_4.setBounds(0, 91, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_5.getText();
				textField.setText(number);
			}
		});
		btnNewButton_5.setBounds(96, 91, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_6.getText();
				textField.setText(number);
			}
		});
		btnNewButton_6.setBounds(189, 91, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_7.getText();
				textField.setText(number);
			}
		});
		btnNewButton_7.setBounds(296, 91, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_012 = new JButton("+");
		btnNewButton_012.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="+";
			}
		});
		btnNewButton_012.setBounds(0, 159, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_012);

		JButton btnNewButton_013 = new JButton("-");
		btnNewButton_013.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="-";
			}
		});
		btnNewButton_013.setBounds(96, 161, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_013);

		JButton btnNewButton_014 = new JButton("*");
		btnNewButton_014.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="*";
			}
		});
		btnNewButton_014.setBounds(189, 161, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_014);

		JButton btnNewButton_015 = new JButton("=");
		btnNewButton_015.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer;
				second =Double.parseDouble(textField.getText());
				if(operation=="+") {
					result=first+second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="-") {
					result=first-second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="*") {
					result=first*second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="/") {
					result=first/second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operation=="%") {
					result=first%second;
					answer=String.format("%.2f", result);
					textField.setText(answer);
				}
			}
		});
		btnNewButton_015.setBounds(296, 161, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_015);

		JButton btnNewButton_16 = new JButton("/");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="/";
			}
		});
		btnNewButton_16.setBounds(0, 189, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("\uF0E7");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace=null;
				if(textField.getText().length()>0) {
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					backSpace =str.toString();
					textField.setText(backSpace);
				}
			}
		});
		btnNewButton_17.setBounds(96, 189, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("DLT");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_18.getText();
				textField.setText(null);
			}
		});
		btnNewButton_18.setBounds(189, 189, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton("AC");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_19.setBounds(296, 189, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_19);

		JButton btnNewButton_08 = new JButton("8");
		btnNewButton_08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_08.getText();
				textField.setText(number);
			}
		});
		btnNewButton_08.setBounds(0, 125, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_08);

		JButton btnNewButton_09 = new JButton("9");
		btnNewButton_09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_09.getText();
				textField.setText(number);
			}
		});
		btnNewButton_09.setBounds(96, 127, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_09);

		JButton btnNewButton_010 = new JButton(".");
		btnNewButton_010.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField.getText()+btnNewButton_010.getText();
				textField.setText(number);
			}
		});
		btnNewButton_010.setBounds(189, 125, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_010);

		JButton btnNewButton_011 = new JButton("%");
		btnNewButton_011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first=Double.parseDouble(textField.getText());
				textField.setText("");
				operation="%";
			}

		});
		btnNewButton_011.setBounds(296, 125, 89, 23);
		SATYACALCULATOR.getContentPane().add(btnNewButton_011);

		textField = new JTextField();
		textField.setBounds(37, 0, 311, 46);
		SATYACALCULATOR.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
