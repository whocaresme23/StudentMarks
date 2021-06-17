import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchResult extends Frame implements ActionListener{
JFrame frame, frame1;
JTextField textbox;
JLabel label;
JButton button,b2;
JPanel panel;
JTable table;

String driverName = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String userName = "system";
String password = "system";
String[] columnNames = {"STD_ID","NAME","BRANCH","ENGLISH","MATHS_1","COMP_PROM","CHEMISTRY","BEE","DRAWING","TOTAL","CGPA"};

public void createUI()
{
frame = new JFrame("Database Search Result");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(null);
textbox = new JTextField();
textbox.setBounds(530,200,150,40); 
label = new JLabel("Enter your STD_ID");
label.setBounds(200, 200, 350, 40);
textbox.setFont(new Font("subway",Font.ITALIC,35));
label.setFont(new Font("subway",Font.ITALIC,35));
button = new JButton("SEARCH");
button.setBounds(270,300,100,35);
button.addActionListener(this);
b2 = new JButton("BACK");
b2.setBounds(480,300,70,35);
b2.addActionListener(this);

frame.add(textbox);
frame.add(label);
frame.add(button);
frame.add(b2);
frame.setVisible(true);
frame.setSize(1200,800); 
} 

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==button)
{
System.out.println("Showing Table Data.......");
showTableData(); 
}
if(ae.getSource()==b2){
Student A=new Student();
A.setSize(1200,800);
A.setVisible(true);
}
}

public void showTableData()
{

frame1 = new JFrame("Database Search Result");
frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame1.setLayout(new BorderLayout()); 
//TableModel tm = new TableModel();
DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columnNames);
//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
//table = new JTable(model);
table = new JTable();
table.setModel(model); 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
JScrollPane scroll = new JScrollPane(table);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
String textvalue = textbox.getText();
String STD_ID= "";
String NAME= "";
String BRANCH = "";
String ENGLISH = "";
String MATHS_1= "";
String COMP_PROM= "";
String CHEMISTRY= "";
String BEE= "";
String DRAWING= "";
String TOTAL= "";
String CGPA= "";
try
{ 
Class.forName(driverName); 
Connection con = DriverManager.getConnection(url, userName, password);
String sql = "select * from Enter_Marks where STD_ID = "+textvalue;
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
int i =0;
if(rs.next())
{
STD_ID = rs.getString("STD_ID");
NAME = rs.getString("NAME");
BRANCH = rs.getString("BRANCH");
ENGLISH = rs.getString("ENGLISH");
MATHS_1 = rs.getString("MATHS_1");
COMP_PROM = rs.getString("COMP_PROM");
CHEMISTRY = rs.getString("CHEMISTRY");
BEE = rs.getString("BEE");
DRAWING = rs.getString("DRAWING");
TOTAL = rs.getString("TOTAL");
CGPA = rs.getString("CGPA");
model.addRow(new Object[]{STD_ID,NAME,BRANCH,ENGLISH,MATHS_1,COMP_PROM,CHEMISTRY,BEE,DRAWING,TOTAL,CGPA});
i++; 
}
if(i <1)
{
JOptionPane.showMessageDialog(null, "No Record Found","Error",
JOptionPane.ERROR_MESSAGE);
}
if(i ==1)
{
System.out.println(i+" Record Found");
}
else
{
System.out.println(i+" Records Found");
}
}
catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
JOptionPane.ERROR_MESSAGE);
}
frame1.add(scroll);
frame1.setVisible(true);
frame1.setSize(1200,800);
}

public static void main(String args[])
{
SearchResult sr = new SearchResult();
sr.createUI(); 
}
}
