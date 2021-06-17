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
public class Student extends JFrame implements ActionListener{
		JLabel l1,l2,L;
		static String u,p;
		JTextField t1,t2;
		Connection con;
		 Statement st;
		 ResultSet rs;
		JButton b1,b2,b3,b4;
		JPasswordField x;
		int length=5;
		public Student(){
			setLayout(null);
		Font f=new Font("Arial",Font.ITALIC,17);
			x=new JPasswordField();
			L=new JLabel("STUDENT LOGIN");
			L.setFont(new Font("calligrapher",Font.ITALIC,40));
			L.setBounds(350,100,600,45);
			add(L);
			l1=new JLabel("Username");
			l2=new JLabel("Password");
			t1=new JTextField();
			b1=new JButton("login");
			b2=new JButton("New_User");
			b3=new JButton("ForgotPassword");
			b4=new JButton("EXIT");	
			l1.setBounds(300,300,80,25);
			l1.setFont(f);
			l2.setBounds(300,350,80,25);
			t1.setBounds(400,300,180,25);
			x.setBounds(400,350,180,25);
			b1.setBounds(300,400,80,25);
			b2.setBounds(450,400,100,25);
			b3.setBounds(600,400,150,25);
			b4.setBounds(400,450,100,25);
			add(l1);
			add(l2);
			add(t1);
			add(x);
			add(b1);
			add(b2);
			add(b3);
			add(b4);
				b1.addActionListener(this);
				b2.addActionListener(this);
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
			if(ae.getSource()==b2){
					Std_New r=new Std_New();
				r.setBackground(Color.orange);
				r.setSize(1600,800);
				r.setVisible(true);
					this.dispose();
					}
					if(ae.getSource()==b1)
					{
						try
						{
							st=con.createStatement();
							String qry1="select * from NewStd_Register";
							rs=st.executeQuery(qry1);
							while(rs.next())
							{
								u=rs.getString("USERNAME");
								p=rs.getString("PASSWORD");
							}
						}
						catch(Exception e)
						{}
						
							String USERNAME=t1.getText();
							String PASSWORD=x.getText();
								if((USERNAME.equals(u))&&(PASSWORD.equals(p))){
					try{
				 	Std_Login ad=new Std_Login();
							ad.setSize(1600,800);
							ad.setVisible(true);
			 }
			catch(Exception ex){
				System.out.println(ex);
			
			}
		}
		else{
				JOptionPane.showMessageDialog(null,"password or username is not matched");
							
			}
		}
				if(ae.getSource()==b3){
					Std_Forgot f=new Std_Forgot();
				f.Captcha(length);
				f.setBackground(Color.green);
				f.setSize(1600,800);
				f.setVisible(true);
							}
							if(ae.getSource()==b4)
							{
								Welcome1 w=new Welcome1();
								w.setSize(1600,800);
								w.setVisible(true);
								this.dispose();
							}
					}
		public static void main(String[] args){
				Student a=new Student();
				a.setSize(1600,800);
				a.setVisible(true);
			
		}
}
