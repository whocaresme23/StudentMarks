import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;
class Enter_Marks{
	public static void main(String [] args){
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String pass="system";
			String sql="create table ENTER_MARKS("
												+"STD_ID NUMBER(15) NOT NULL ,"
												+"NAME VARCHAR2(30),"
												+"BRANCH VARCHAR2(5),"
												+"ENGLISH NUMBER(3),"
												+"MATHS_1 NUMBER(3),"
												+"COMP_PROM NUMBER(3),"
												+"CHEMISTRY NUMBER(3),"
												+"BEE NUMBER(3),"
												+"DRAWING NUMBER(3),"
												+"TOTAL NUMBER(4),"
												+"CGPA NUMBER(10,3),"
												+"PRIMARY KEY(STD_ID)"
												+")";
			Connection con=null;
			try{
				Class.forName( "oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(url,user,pass);
				Statement st=con.createStatement();
			//	int m=st.con.createStatement();
				int m=st.executeUpdate(sql);
				con.close();
			}
			
			catch(Exception ex){
				System.out.println(ex);
				}
	}
}
