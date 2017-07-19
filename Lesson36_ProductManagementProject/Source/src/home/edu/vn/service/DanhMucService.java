package home.edu.vn.service;

import home.edu.vn.model.DanhMuc;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class DanhMucService extends SQLServerService {
	public Vector<DanhMuc> docToanBoDanhMuc()
	{
		Vector<DanhMuc> vec=new Vector<DanhMuc>();
		try
		{
			String sql="select * from DanhMuc where isDeleted=0";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				DanhMuc dm=new DanhMuc();
				dm.setMaDM(result.getString(1));
				dm.setTenDM(result.getString(2));
				dm.setIsDeleted(0);
				vec.add(dm);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return vec;
	}
}
