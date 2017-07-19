package home.edu.vn.test;

import home.edu.vn.io.TextFileFactory;
import home.edu.vn.model.Customer;

import java.sql.Savepoint;
import java.util.ArrayList;

public class TestCustomer {
	
	public static void testSaveFile()
	{
		ArrayList<Customer>listCustomer=new ArrayList<Customer>();
		listCustomer.add(new Customer("KH01","Nguyễn Thị An"));
		listCustomer.add(new Customer("KH02","Trần Văn Bình"));
		listCustomer.add(new Customer("KH03","Hồ Thị Giải"));
		listCustomer.add(new Customer("KH01","Hoàng Ngọc Thoát"));
		
		boolean result=TextFileFactory.saveFile(listCustomer, "e:\\dulieu.txt");
		if(result==true)
		{
			System.out.println("Đã lưu File thành công!");
		}
		else
		{
			System.out.println("Lưu File thất bại!");
		}
	}
	public static void main(String[] args) {
		//testSaveFile();
		ArrayList<Customer>listCustomer=TextFileFactory.readFile("e:\\dulieu.txt");
		
		System.out.println("List of customer loaded into computer is:");
		System.out.println("Id\tName");
		for(Customer cus: listCustomer)
		{
			System.out.println(cus);
		}
	}

}
