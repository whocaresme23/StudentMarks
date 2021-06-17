import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.filechooser.*;
public class Admin_Forgot extends JFrame implements ActionListener{
		JLabel l1,l2,l3,l4,l5,l6,l7;
		JTextField t1,t2,t5;
		JButton b1,b2,b3;
		Connection con;
		 Statement st;
		 ResultSet rs;
		final JPasswordField x1,x2;
		static int length=5;
		static	char passwd[]=new char[length];
		static String s,u;
	public char[] Captcha(int length){
				String Cap_Chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String small_Chars="abcdefghijklmnopqrstuvwxyz";
				String numbers="0123456789";
				String values= Cap_Chars+small_Chars+numbers;
				Random rndm=new Random();
				for(int i=0;i<length;i++){
					passwd[i]=values.charAt(rndm.nextInt(values.length()));
					}
				
			return passwd;
			}
		
		public Admin_Forgot(){
			setLayout(null);
			x1 = new JPasswordField();
			x2 = new JPasswordField();
			l1=new JLabel("ADMIN FORGOT PASSWORD");
			l2=new JLabel("UserName");
			l3=new JLabel("Admin_Id");
			l4=new JLabel("NewPassword");
			l5=new JLabel("ConfirmPassword");         
			l6=new JLabel("EnterCaptcha");
			l7=new JLabel();
			t1=new JTextField();
			t2=new JTextField();
			t5=new JTextField();
			b1=new JButton("Confirm");
			b2=new JButton("Exit");
			b3=new JButton("Captcha");
			l1.setBounds(350,20,520,40);
			l1.setFont(new Font("serile",Font.BOLD,35));
			l3.setBounds(400,125,150,40);	t2.setBounds(600,125,150,40);
			l2.setFont(new Font("subway",Font.ITALIC,25));
			t1.setFont(new Font("subway",Font.ITALIC,25));
			l2.setBounds(350,175,225,40);	t1.setBounds(600,175,150,40);
			l3.setFont(new Font("subway",Font.ITALIC,25));
			t2.setFont(new Font("subway",Font.ITALIC,25));
			l4.setBounds(350,225,225,40);	x1.setBounds(600,225,150,40); 
			l4.setFont(new Font("subway",Font.ITALIC,25));
			x1.setFont(new Font("subway",Font.ITALIC,25));	
			l5.setBounds(330,275,225,40);	x2.setBounds(600,275,150,40);
			l5.setFont(new Font("subway",Font.ITALIC,25));
			x2.setFont(new Font("subway",Font.ITALIC,25)); 
			l6.setBounds(345,325,225,40);	t5.setBounds(600,325,150,40);
			l6.setFont(new Font("subway",Font.ITALIC,25));
			t5.setFont(new Font("subway",Font.ITALIC,25));
			l7.setBounds(930,325,150,40);	b3.setBounds(770,325,150,40);
											l7.setFont(new Font("David",Font.BOLD,20));
			b1.setBounds(450,450,90,25);	b2.setBounds(550,450,90,25);
			add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);
			add(t1);add(t2);
			add(t5);
			add(b1);add(b2);add(b3);add(x1);add(x2);
			l7.setText(String.valueOf(passwd));

						b1.addActionListener(this);
			b2.addActionListener(this);
				b3.addActionListener(this);
			try{
				Class.forName( "oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				}
				catch(Exception e){
					System.out.println(e);
					}
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
					l7.setText(String.valueOf(passwd));
					s=String.valueOf(passwd);

			}
				if(ae.getSource()==b2){
					this.dispose();

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
							}
						}
						catch(Exception e)
						{}
						
							int ADMIN_ID=Integer.parseInt(t2.getText());
							String USERNAME=t1.getText();
							String NEWPASSWORD=x1.getText();
							String CONFIRMPASSWORD=x2.getText();
							 String ENTERCAPTCHA=t5.getText();
								if(USERNAME.equals(u)){
							if(NEWPASSWORD.equals(CONFIRMPASSWORD)){
								if(ENTERCAPTCHA.equals(s)){
																	try{	
					st=con.createStatement();								
					String qry="UPDATE NewAdmin_Register set PASSWORD='"+NEWPASSWORD+"' where ADMIN_ID="+ADMIN_ID+"";
				 rs=st.executeQuery(qry);	
				 con.close(); 
				 	Administrator ad=new Administrator();
							ad.setSize(1600,800);
							ad.setVisible(true);
			 }
			catch(Exception ex){
				System.out.println(ex);
			
			}
					}
					else{
						JOptionPane.showMessageDialog(null,"captcha not matched");
						
						}
								
		}
		else{
				JOptionPane.showMessageDialog(null,"password not matched");
							
			}
		}
			else{
				JOptionPane.showMessageDialog(null,"USERNAME is not matched");
							
			}
				
					}
					}
		public static void main(String[] args)throws IOException{
				Admin_Forgot f=new Admin_Forgot();
				f.Captcha(length);
				f.setBackground(Color.green);
				f.setSize(1600,800);
				f.setVisible(true);
			}
}
