package home.edu.vn.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerService {
	protected Connection conn=null;
	public SQLServerService(){
		String strServer="DESKTOP-UBC0EDN\\SQLEXPRESS";
		String strDatabase="dbQuanLySanPham";
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl="jdbc:sqlserver://"+strServer+":1433;databaseName="+strDatabase+";integratedSecurity=true;";
			conn=DriverManager.getConnection(connectionUrl);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
