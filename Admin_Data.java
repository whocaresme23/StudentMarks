import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;
class Admin_New{
	public static void main(String [] args){
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String pass="system";
			String sql="create table NewStd_Register("
												+"STD_ID NUMBER(15) NOT NULL ,"
												+"USERNAME VARCHAR2(30) NOT NULL UNIQUE,"
												+"PASSWORD VARCHAR2(30),"
												+"NAME VARCHAR2(40),"
												+"BRANCH VARCHAR2(30),"
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
