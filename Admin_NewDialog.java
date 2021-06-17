import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
public class Admin_NewDialog extends Frame implements ActionListener{  
    private static Dialog d;
    JLabel l;
    JButton b1,b2;  
    Admin_NewDialog() {  
        Frame f= new JFrame();  
        d = new Dialog(f , "select one option", true);  
        d.setLayout( null );  
         l=new JLabel ("Are you Registered Successfully?");
         b1 = new JButton ("yes");  
        b2=new JButton("no");
			l.setBounds(50,50,200,30);
        	b1.setBounds(100,100,70,25);
			b2.setBounds(200,100,70,25);
			        b1.addActionListener (this);
			        b2.addActionListener (this);
        d.add(l);  
        d.add(b1);
        d.add(b2);   
        d.setSize(300,300);    
        d.setVisible(true);  
    }  
    public void actionPerformed(ActionEvent ae){
				if(ae.getSource()==b1){
				d.dispose();
				Administrator ad=new Administrator();
				ad.setSize(1600,800);
				ad.setVisible(true);
	
				}							
				else if(ae.getSource()==b2){
				d.dispose();
		
				}
			}
    public static void main(String args[])  
    {  
        new Admin_NewDialog();  
    }  
}  
