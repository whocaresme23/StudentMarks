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
public class Administrator extends JFrame implements ActionListener{
		JLabel l1,l2,L;
		JTextField t1;
		Connection con;
		 Statement st;
		 ResultSet rs;
		JButton b1,b2,b3,b4;
		static String u,p;
		JPasswordField x;
		Image img;
		int length=5;
		String s="clg.png";
		public Administrator(){
			setLayout(null);
		Font f=new Font("Arial",Font.ITALIC,17);
		L=new JLabel("ADMINISTRATOR LOGIN");
		L.setFont(new Font("subway",Font.ITALIC,40));
		L.setBounds(350,100,600,45);
		add(L);
			x=new JPasswordField();
			l1=new JLabel("Username");
			l2=new JLabel("Password");
			t1=new JTextField();
			b1=new JButton("login");
			b2=new JButton("New_User");
			b3=new JButton("ForgotPassword");
			b4=new JButton("BACK");	
			l1.setBounds(800,550,80,25);
			l1.setFont(f);
			l2.setBounds(800,600,80,25);
			t1.setBounds(900,550,180,25);
			x.setBounds(900,600,180,25);
			b1.setBounds(800,650,80,25);
			b2.setBounds(950,650,100,25);
			b3.setBounds(1100,650,150,25);
			b4.setBounds(850,700,100,30);
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
				Admin_New r=new Admin_New();
				r.setBackground(Color.orange);
				r.setSize(1600,800);
				r.setVisible(true);
					}
					if(ae.getSource()==b1){
						try
						{
							st=con.createStatement();
							String qry1="select * from NewAdmin_Register";
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
				 	Admin_Login ad=new Admin_Login();
							ad.setSize(1600,800);
							ad.setVisible(true);
							this.dispose();
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
					Admin_Forgot f=new Admin_Forgot();
				f.Captcha(length);
				f.setBackground(Color.green);
				f.setSize(1600,800);
				f.setVisible(true);
							this.dispose();
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
				Administrator a=new Administrator();
				a.setSize(1600,800);
				a.setVisible(true);
			
		}
}
