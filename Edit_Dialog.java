import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
public class Edit_Dialog extends Frame implements ActionListener{  
    private static Dialog d;
    Label l;
    Button b1,b2;  
    Edit_Dialog() {  
        Frame f= new JFrame();  
        d = new Dialog(f , "select one option", true);  
        d.setLayout( null );  
         l=new Label ("Your Marks are updated SuccessFully?");
         b1 = new Button ("ok");  
			l.setBounds(50,50,200,30);
        	b1.setBounds(100,100,70,25);
			        b1.addActionListener (this);
        d.add(l);  
        d.add(b1);
        d.setSize(300,300);    
        d.setVisible(true);  
    }  
    public void actionPerformed(ActionEvent ae){
				if(ae.getSource()==b1){
				d.dispose();
				}							
			}
    public static void main(String args[])  
    {  
        new Edit_Dialog();  
    }  
}  
