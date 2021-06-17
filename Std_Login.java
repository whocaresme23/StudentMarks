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
public class Std_Login extends JFrame implements ActionListener{
			JLabel L,l2;
			Connection con;
		 Statement st;
		 ResultSet rs;
			JButton b3,b4;
			public Std_Login(){
			setLayout(null);
			l2=new JLabel("STUDENT INFORMATION");
			L=new JLabel("STUDENTS RESULTS");
			b3=new JButton("View Marks");
			b4=new JButton("Logout");
			L.setBounds(400,50,400,25);
			L.setFont(new Font("serif",Font.BOLD,25));
			l2.setBounds(400,150,400,25);
			l2.setFont(new Font("serif",Font.ITALIC,25));
			b3.setBounds(400,300,120,25);
			b4.setBounds(800,300,120,25);
			add(L);add(b3);add(b4);add(l2);
			b3.addActionListener(this);
			b4.addActionListener(this);
			
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
								 if(ae.getSource()==b3){								 
								 SearchResult sr = new SearchResult();
									sr.createUI(); 
								}
								 if(ae.getSource()==b4){
								 		Student a=new Student();
										a.setSize(1600,800);
										a.setVisible(true);
										this.dispose();
							}
					}
				public static void main(String[] args){
				Std_Login A=new Std_Login();
				A.setBackground(Color.green);
				A.setSize(1600,800);
				A.setVisible(true);
			}

}
