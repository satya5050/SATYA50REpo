package GUIBASED;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIScroll {
	private static final String SELECT_QUERY="SELECT SNO,SNAME,SADD,AVG FROM STUDENT";
	private Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private JFrame frame;
	/**
	 * @wbp.nonvisual location=337,-11
	 */
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIScroll window = new GUIScroll();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIScroll() {
		initialize();
		initializeJDBC();
	}
	private void initializeJDBC() {
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
			ps=con.prepareStatement(SELECT_QUERY,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=ps.executeQuery();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("GUI_WINDOW _CLOSING");
				try {
					if(rs!=null)
						rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(ps!=null)
						rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(con!=null)
						rs.close();
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(323, 36, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(323, 80, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(323, 126, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(323, 165, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel = new JLabel("SNO::");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(210, 39, 69, 17);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SNAME");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(210, 83, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("SADD");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(210, 129, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("SAVG");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(210, 168, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton = new JButton("FIRST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					textField.setText(rs.getString(1));;
					textField_1.setText(rs.getString(2));;
					textField_2.setText(rs.getString(3));;
					textField_3.setText(rs.getString(4));

				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(25, 219, 99, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!rs.isLast()) {
						rs.next();
						textField.setText(rs.getString(1));;
						textField_1.setText(rs.getString(2));;
						textField_2.setText(rs.getString(3));;
						textField_3.setText(rs.getString(4));
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}

		});
		btnNewButton_1.setBounds(134, 219, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("PREVIOUS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!rs.isFirst()) {
						rs.previous();
						textField.setText(rs.getString(1));;
						textField_1.setText(rs.getString(2));;
						textField_2.setText(rs.getString(3));;
						textField_3.setText(rs.getString(4));
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(239, 219, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("LAST");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					rs.last();
					textField.setText(rs.getString(1));;
					textField_1.setText(rs.getString(2));;
					textField_2.setText(rs.getString(3));;
					textField_3.setText(rs.getString(4));

				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(335, 219, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
