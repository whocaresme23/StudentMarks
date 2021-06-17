import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Welcome1 extends JFrame implements ActionListener{
	JLabel l=new JLabel("SELECT STUDENT/ADMINISTRATOR");
	JButton b=new JButton("STUDENT");
	JButton b1=new JButton("ADMINISTRATOR");
	JButton b2=new JButton("BACK");
	public Welcome1(){
	setLayout(null);
	l.setFont(new Font("serif",Font.ITALIC,20));
	l.setBounds(300,100,900,30);
	b.setBounds(400,200,120,25);
	b1.setBounds(400,300,200,25);
	b2.setBounds(400,400,120,25);
	add(l);
	add(b);
	add(b1);
	add(b2);
	b.addActionListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
	Administrator a=new Administrator();
				a.setSize(1600,800);
				a.setVisible(true);
		}
		if(ae.getSource()==b){
	Student s=new Student();
				s.setSize(1600,800);
				s.setVisible(true);
		}
			if(ae.getSource()==b2){
		Welcome w=new Welcome();
		w.setSize(1600,800);
		w.setVisible(true);
		this.dispose();
		
		}
		}
		public static void main(String [] args){
		Welcome1 w=new Welcome1();
		w.setSize(1600,800);
		w.setVisible(true);
		}

}
