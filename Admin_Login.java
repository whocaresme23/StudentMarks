import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.filechooser.*;
public class Admin_Login extends JFrame implements ActionListener{
			JLabel l1;
			Connection con;
		 Statement st;
		 ResultSet rs;
			JButton b1,b2,b3;
			public Admin_Login(){
			setLayout(null);
			l1=new JLabel("ADMINISTRATOR");
			b1=new JButton("Adding MARKS");
			b2=new JButton("Editing MARKS");
			b3=new JButton("Logout");
			l1.setBounds(100,150,290,25);		
			l1.setFont(new Font("serif",Font.ITALIC,25));
			b1.setBounds(100,200,140,25);		
			b2.setBounds(100,250,140,25);
			b3.setBounds(550,400,120,25);
			add(b1);add(b2);add(b3);
			add(l1);
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
				
			addWindowListener(new WindowAdapter(){
						public void windowClosing(WindowEvent we){
								System.exit(0);
						}
				});
			try{
				Class.forName( "oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				}
				catch(Exception e){
					System.out.println(e);
					}
			}
				public void actionPerformed(ActionEvent ae){
					if(ae.getSource()==b1){
						AddingMarks d=new AddingMarks();
				d.setBackground(Color.pink);
				d.setSize(1600,800);
				d.setVisible(true);
				this.dispose();

											}
						 if(ae.getSource()==b2){
						 EditingMarks d1=new EditingMarks();
				d1.setBackground(Color.orange);
				d1.setSize(1600,800);
				d1.setVisible(true);
				this.dispose();
			
						}
								 if(ae.getSource()==b3){
								 		Administrator a=new Administrator();
										a.setSize(1600,800);
										a.setVisible(true);
										this.dispose();
							}
					}
				public static void main(String[] args){
				Admin_Login A=new Admin_Login();
				A.setBackground(Color.green);
				A.setSize(1600,800);
				A.setVisible(true);
			}

}
