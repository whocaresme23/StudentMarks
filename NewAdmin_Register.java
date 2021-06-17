import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;
class NewAdmin_Register{
	public static void main(String [] args){
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String pass="system";
			String sql="create table NewAdmin_Register("
												+"ADMIN_ID NUMBER(15) NOT NULL ,"
												+"USERNAME VARCHAR2(30) NOT NULL UNIQUE,"
												+"PASSWORD VARCHAR2(30),"
												+"NAME VARCHAR2(40),"
												+"PRIMARY KEY(ADMIN_ID)"
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
