import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Welcome extends JFrame implements ActionListener
{
	JLabel l=new JLabel("WELCOME TO YSR ENGINEERING COLLEGE");
	JButton b=new JButton("Click Here To Continue");
    public Welcome()
	{
		setLayout(null);
		l.setFont(new Font("serif",Font.ITALIC,40));
		l.setBounds(300,200,900,60);
		b.setBounds(500,500,300,25);
		add(l);
		add(b);
		b.addActionListener(this);
	}
		public void actionPerformed(ActionEvent ae){
					if(ae.getSource()==b){
					Welcome1 w=new Welcome1();
		w.setSize(1600,800);
		w.setVisible(true);
		this.dispose();
		
		}
			}
		public static void main(String [] args){
		Welcome w=new Welcome();
		w.setSize(1600,800);
		w.setVisible(true);
		}

}
