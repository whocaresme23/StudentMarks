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
public class Admin_New extends JFrame implements ActionListener,ItemListener,AdjustmentListener{
		JLabel L,l1,l2,l3,l5;
		JTextField t1,t3,t5;
		Connection con;
		static int c1;
		 Statement st;
		 ResultSet rs;
		JPasswordField t2;
		JButton b1,b2;
		public Admin_New(){
			setLayout(null);
			L=new JLabel("ADMINISTRATOR REGISTRATION FORM(NEW USER)");
			l1=new JLabel("UserName");
			l2=new JLabel("Password");
			l3=new JLabel("FullName");
			
			t1=new JTextField();
			t2=new JPasswordField();
			t3=new JTextField();
			b1=new JButton("GoTOBack");
			b2=new JButton("Register");
			L.setBounds(300,50,850,30);
			L.setFont(new Font("calligrapher",Font.ITALIC,30));
		    l1.setFont(new Font("signboard",Font.ITALIC,25));
			t1.setFont(new Font("signboard",Font.ITALIC,25));
			l1.setBounds(300,250,125,40);       t1.setBounds(500,250,200,40);
			l2.setFont(new Font("signboard",Font.ITALIC,25));
			t2.setFont(new Font("signboard",Font.ITALIC,25));
			l2.setBounds(300,300,125,40);       t2.setBounds(500,300,200,40);
			l3.setFont(new Font("signboard",Font.ITALIC,25));
			t3.setFont(new Font("signboard",Font.ITALIC,25));
			l3.setBounds(300,400,125,40);       t3.setBounds(500,400,325,40);
			b1.setBounds(300,600,100,40);
			b2.setBounds(500,600,100,40);
			add(L);add(l1);add(l2);add(l3);
			add(t1);add(t2);add(t3);
		    add(b1);add(b2);			
		    b1.addActionListener(this);
			b2.addActionListener(this);
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
		public void adjustmentValueChanged(AdjustmentEvent ae){}
			public void actionPerformed(ActionEvent ae){
				if(ae.getSource()==b1)
				{
					Administrator a=new Administrator();
					a.setSize(1600,800);
					a.setVisible(true);
					this.dispose();
				}
				 if(ae.getSource()==b2){
					                     try{	
					
					st=con.createStatement();								
					String qry="select * from NewAdmin_Register ";
				 rs=st.executeQuery(qry);
				 while(rs.next()){
			int A=Integer.parseInt(rs.getString("ADMIN_ID"));
			 c1=A+1;
				 
			}
				
		}
			catch(Exception ex){
				System.out.println(ex);
			
			}
			int ADMIN_ID=c1;
			String USERNAME=t1.getText();
					 String PASSWORD=t2.getText();
					 String NAME=t3.getText();
		
				
			try{	
					st=con.createStatement();								
					String qry="insert into NewAdmin_Register values("+ADMIN_ID+",'"+USERNAME+"','"+PASSWORD+"','"+NAME+"')";
				 rs=st.executeQuery(qry);
				 JOptionPane.showMessageDialog(null,"your ADMIN_ID number is:"+c1);	
					JOptionPane.showMessageDialog(null,"you registered successfully ");
						con.close(); 
					
			}
			
			catch(Exception ex){
				System.out.println(ex);
			
			}
			
				 new Admin_NewDialog();
				 this.dispose();
					}
				}

			public void itemStateChanged(ItemEvent ie){}
		public static void main(String[] args){
				Admin_New r=new Admin_New();
				r.setBackground(Color.orange);
				r.setSize(1600,800);
				r.setVisible(true);
				
		}
}
