package home.edu.vn.service;

import home.edu.vn.model.SanPham;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class SanPhamService extends SQLServerService {
	public int luuSanPham(SanPham sp)
	{
		try
		{
			String sql="insert into sanpham values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, sp.getMaSp());
			preparedStatement.setString(2, sp.getTenSp());
			preparedStatement.setInt(3, sp.getSoLuong());
			preparedStatement.setInt(4, sp.getDonGia());
			preparedStatement.setString(5, sp.getMaDM());
			preparedStatement.setInt(6, 0);
			return preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	public ArrayList<SanPham> docSanPhamTheoDanhMuc(String madm)
	{
		ArrayList<SanPham>dsSP=new ArrayList<SanPham>();
		try
		{
			String sql="select * from sanpham where madm=? and isdeleted=0";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, madm);
			
			ResultSet result=preStatement.executeQuery();
			while(result.next())
			{	
				SanPham sp=new SanPham();
				sp.setMaSp(result.getString(1));
				sp.setTenSp(result.getString(2));
				sp.setSoLuong(result.getInt(3));
				sp.setDonGia(result.getInt(4));
				sp.setMaDM(result.getString(5));
				sp.setIsDeleted(0);
				dsSP.add(sp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dsSP;
	}
}
