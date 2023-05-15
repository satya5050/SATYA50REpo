package GUIBASED;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class GuiFrame extends JFrame implements ActionListener,WindowListener{
	private static final String SELECT_STUDENT_QUERY=" SELECT SNAME,SNO,AVG,SADD FROM STUDENT";
	private Connection con;	
	private PreparedStatement ps;
	private ResultSet rs;
	private JButton btn1,btn2,btn3,btn4; 
	private JLabel lsno,lsname,lsadd,lsavg;
	private JTextField tsno,tsname,tsadd,tsavg;
	public GuiFrame () {
		System.out.println("GUI 0 PARAM CONSTRUCTER START");
		setTitle("::GUI FRONTEND SCROLL-FRAME::");
		setSize(300,300);
		setLayout(new FlowLayout());
		
		//setting compponents
		 lsno=new JLabel("sno");
		add(lsno);
		 tsno=new JTextField(10);
		add(tsno);
		lsname=new JLabel("sname");
		add(lsname);
		tsname=new JTextField(10);
		add(tsname);
	   lsadd=new JLabel("sadd");
		add(lsadd);
		 tsadd=new JTextField(10);
		add(tsadd);
		 lsavg=new JLabel("savg");
		add(lsavg);
		 tsavg=new JTextField(10);
		add(tsavg);
		
		//Add buttons
		 btn1=new JButton("FIRST");
		 btn2=new JButton("NEXT");
		 btn3=new JButton("LAST");
		 btn4=new JButton("PREVIOUS");
		
		add(btn1);add(btn2);add(btn3);add(btn4);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		//add window listener
		this.addWindowListener(this);
		tsno.setEditable(false);
		tsname.setEditable(false);
		tsadd.setEditable(false);
		tsavg.setEditable(false);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("GUI 0 PARAM CONSTRUCTER END");
		intializeJDBC();
	}
	public void intializeJDBC() {
		try {
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","SYSTEM","ORACLE");
	ps=con.prepareStatement(SELECT_STUDENT_QUERY,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs=ps.executeQuery() ;
		}catch(SQLException se) {
		se.printStackTrace();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	new GuiFrame ();
}
@Override
public void actionPerformed(ActionEvent e) {
	System.out.println("GuiFrame.actionPerformed() ");
	boolean flag=false;

		if(e.getSource()==btn1) {
			try {
				rs.first();
				flag=true;
				System.out.println("first button is clicked");
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		else if(e.getSource()==btn2) {
			System.out.println("next button is clicked");
	
		try {
			if(rs.isLast()) {
				rs.next();
				flag=true;
			}
		}catch(SQLException se) {
			se.printStackTrace();
		 }
		}
else if(e.getSource()==btn3) {
		System.out.println("previous button is clicked");
	try {
		if(!rs.isFirst()) {
			rs.previous();
			flag=true;
		}
	}catch(SQLException se) {
		se.printStackTrace();
	}
	}
	else {
		System.out.println("last button is clicked");
	try {
		rs.last();
		flag=true;
	}catch(SQLException se) {
		se.printStackTrace();
	}
		}
	if(flag==true) {
		try {
	 tsno.setText(rs.getString(1));
	 tsname.setText(rs.getString(2));
	 tsadd.setText(rs.getString(3));
	 tsavg.setText(rs.getString(4));
		}catch(SQLException se) {
			se.printStackTrace();
	}
    }
}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	System.out.println("GUIframeTest.windowClosing()");
	try {
		if(rs!=null)
			rs.close();
	}catch(SQLException se) {
		se.printStackTrace();
	}
	try {
		if(ps!=null)
			ps.close();
	}catch(SQLException se) {
		se.printStackTrace();
	}
	try {
		if(con!=null)
			con.close();
	}catch(SQLException se) {
		se.printStackTrace();
	}
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
}
