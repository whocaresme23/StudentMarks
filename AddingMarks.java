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
public class AddingMarks  extends JFrame implements ActionListener,ItemListener{
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,L;
		JButton b1,b2;
                 Connection con;
		 Statement st;
		 ResultSet rs;
		JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
		public AddingMarks(){
			setLayout(null);
			L=new JLabel("ADDING MARKS");
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
				b1=new JButton("Exit");
				b2=new JButton("SAVE");
				t5=new JTextField();
				t6=new JTextField();
				t7=new JTextField();
				t8=new JTextField();
				t9=new JTextField();
				t10=new JTextField();
				t11=new JTextField();
				L.setBounds(300,30,600,45);
					L.setFont(new Font("serif",Font.ITALIC,40));
				l2.setBounds(200,100,125,40);        t2.setBounds(350,100,175,40);
				l1.setFont(new Font("subway",Font.ITALIC,35));
				t1.setFont(new Font("subway",Font.ITALIC,35));
				l1.setBounds(80,150,245,40);        t1.setBounds(350,150,225,40);
				l2.setFont(new Font("subway",Font.ITALIC,35));
				t2.setFont(new Font("subway",Font.ITALIC,35));
				l3.setBounds(200,200,125,40);        t3.setBounds(350,200,175,40);
				l3.setFont(new Font("subway",Font.ITALIC,35));
				t3.setFont(new Font("subway",Font.ITALIC,35));
				l4.setBounds(600,100,120,25);       t4.setBounds(700,100,90,25);
				l5.setBounds(600,130,120,25);        t5.setBounds(700,130,90,25);
				l6.setBounds(600,160,120,25);        t6.setBounds(700,160,90,25);
				l7.setBounds(600,190,120,25);        t7.setBounds(700,190,90,25);
				l8.setBounds(600,220,120,25);        t8.setBounds(700,220,90,25);
				l9.setBounds(600,250,120,25);        t9.setBounds(700,250,90,25);  
				l10.setBounds(600,280,120,25);       t10.setBounds(700,280,90,25);
				l11.setBounds(600,310,120,25);	    t11.setBounds(700,310,90,25);
				b1.setBounds(800,500,120,25);
				b2.setBounds(600,500,120,25);
					add(L);
				add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);add(l9);add(l10);add(l11);
				add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(t8);add(t9);add(t10);add(t11);
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
			public void actionPerformed(ActionEvent ae){
				if(ae.getSource()==b1){
				Administrator A=new Administrator();
				A.setSize(1600,800);
				A.setVisible(true);
			this.dispose();
					}
				if(ae.getSource()==b2){
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
					 String qry="insert into ENTER_MARKS values("+STD_ID+",'"+NAME+"','"+BRANCH+"',"+ENGLISH+","+MATHS_1+","+COMP_PROM+","+CHEMISTRY+","+BEE+","+DRAWING+","+TOTAL+","+CGPA+")";
					 rs=st.executeQuery(qry);
					 con.close();
				 }
				 catch(Exception e)
				 {}
			 new Add_Dialog();
					}		
				}
			public void itemStateChanged(ItemEvent ie){}
		public static void main(String[] args){
				AddingMarks d=new AddingMarks();
				d.setBackground(Color.pink);
				d.setSize(1600,800);
				d.setVisible(true);
			
		}

} 
