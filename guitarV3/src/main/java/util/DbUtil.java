package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {
	/*static Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	*/
	//sqlite
	public static Connection getSqliteConnection(){
		String driver="org.sqlite.JDBC";
		String conStr="jdbc:sqlite:guitarV2.db3";
		Connection conn=null;
	    try {
	    	Class.forName(driver);
	    	conn = DriverManager.getConnection(conStr); 
	    	return conn;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; 
    }
	//mysql
	
	public static Connection getMySqlConnection(){
		String driver="com.mysql.jdbc.Driver";
		String conStr="jdbc:mysql://localhost:3306/guitarv3?user=root&password=123456&useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn=null;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(conStr);
			return conn;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;			
	}
}