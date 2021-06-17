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
public class EditingMarks  extends JFrame implements ActionListener,ItemListener{
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,L;
		Connection con;
		 Statement st;
		 ResultSet rs;
		JButton b1,b2,b3;
		JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
		public EditingMarks(){
			setLayout(null);
			L=new JLabel("EDITING MARKS");
				l1=new JLabel("Student  Name");
				l2=new JLabel("Std_Id");
				l3=new JLabel("Branch");
				l4=new JLabel("English");
				l5=new JLabel("Maths-1");
				l6=new JLabel("CP");
				l7=new JLabel("Chemistry");
				l8=new JLabel("Bee");
				l9=new JLabel("Drawing");
				l10=new JLabel("Total");
				l11=new JLabel("CGPA");
				t1=new JTextField();
				t2=new JTextField();
				t3=new JTextField();
				t4=new JTextField();
				b1=new JButton("SAVE");
				b3=new JButton("SHOW");
				b2=new JButton("EXIT");
				t5=new JTextField();
				t6=new JTextField();
				t7=new JTextField();
				t8=new JTextField();
				t9=new JTextField();
				t10=new JTextField();
				t11=new JTextField();
				L.setBounds(300,30,600,45);
					L.setFont(new Font("serif",Font.ITALIC,40));
				l1.setBounds(10,150,180,40);        t1.setBounds(250,150,125,40);
				l1.setFont(new Font("subway",Font.ITALIC,25));
				t1.setFont(new Font("subway",Font.ITALIC,25));
				t2.setFont(new Font("subway",Font.ITALIC,25));
				t3.setFont(new Font("subway",Font.ITALIC,25));
				l2.setBounds(100,100,125,40);        t2.setBounds(250,100,125,40);
				l2.setFont(new Font("subway",Font.ITALIC,25));
				l3.setBounds(100,200,125,40);        t3.setBounds(250,200,125,40);
				l3.setFont(new Font("subway",Font.ITALIC,25));
				l4.setBounds(600,100,120,25);       t4.setBounds(700,100,90,25);
				l5.setBounds(600,130,120,25);        t5.setBounds(700,130,90,25);
				l6.setBounds(600,160,120,25);        t6.setBounds(700,160,90,25);
				l7.setBounds(600,190,120,25);        t7.setBounds(700,190,90,25);
				l8.setBounds(600,220,120,25);        t8.setBounds(700,220,90,25);
				l9.setBounds(600,250,120,25);        t9.setBounds(700,250,90,25);  
				l10.setBounds(600,280,120,25);       t10.setBounds(700,280,90,25);
				l11.setBounds(600,310,120,25);	    t11.setBounds(700,310,90,25);
				b1.setBounds(800,500,120,35);
				b2.setBounds(500,500,120,35);
				b3.setBounds(650,500,120,35);
					add(L);
				add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);add(l11);
				add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);add(t9);add(t10);add(t11);
				add(b1);add(b2);add(b3);
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
				if(ae.getSource()==b2){
					Administrator A=new Administrator();
				A.setBackground(Color.green);
				A.setSize(1600,800);
				A.setVisible(true);
				this.dispose();
					}
					if(ae.getSource()==b1){
						long STD_ID=Long.parseLong(t2.getText());
					 String NAME=t1.getText();
					 String BRANCH=t3.getText();
					 int ENGLISH=Integer.parseInt(t4.getText());
					 int MATHS_1=Integer.parseInt(t5.getText());
					 int COMP_PROM=Integer.parseInt(t6.getText());
					 int CHEMISTRY=Integer.parseInt(t7.getText());
					 int BEE=Integer.parseInt(t8.getText());
					 int DRAWING=Integer.parseInt(t9.getText());
					 int TOTAL=Integer.parseInt(t10.getText());
					 float CGPA=Float.parseFloat(t11.getText());
					 try{
					 st=con.createStatement();
					 String qry="update ENTER_MARKS set STD_ID="+STD_ID+",NAME='"+NAME+"',BRANCH='"+BRANCH+"',ENGLISH="+ENGLISH+",MATHS_1="+MATHS_1+",COMP_PROM="+COMP_PROM+",CHEMISTRY="+CHEMISTRY+",BEE="+BEE+",DRAWING="+DRAWING+",TOTAL="+TOTAL+",CGPA="+CGPA+"";
					 rs=st.executeQuery(qry);
					 con.close();
				 }
				 catch(Exception e)
				 {}
					    new Edit_Dialog();
					    this.dispose(); 
					}
					if(ae.getSource()==b3)
					{
						int STD_ID=Integer.parseInt(t2.getText());
						try
						{
							st=con.createStatement();
							String qry1="select * from ENTER_MARKS where STD_ID="+STD_ID+"";
							rs=st.executeQuery(qry1);
							while(rs.next())
							{
								t1.setText(rs.getString("NAME"));
								t3.setText(rs.getString("BRANCH"));
								t4.setText(rs.getString("ENGLISH"));
								t5.setText(rs.getString("MATHS_1"));
								t6.setText(rs.getString("COMP_PROM"));
								t7.setText(rs.getString("CHEMISTRY"));
								t8.setText(rs.getString("BEE"));
								t9.setText(rs.getString("DRAWING"));
								t10.setText(rs.getString("TOTAL"));
								t11.setText(rs.getString("CGPA"));
							}
						}
						catch(Exception e)
						{
							System.out.println(e);
							}
				}
			}
			public void itemStateChanged(ItemEvent ie){}
		public static void main(String[] args){
				EditingMarks d1=new EditingMarks();
				d1.setBackground(Color.orange);
				d1.setSize(1600,800);
				d1.setVisible(true);
			
		}

} 
