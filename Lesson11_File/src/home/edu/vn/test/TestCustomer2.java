package home.edu.vn.test;

import home.edu.vn.io.SerializeFileFactory;
import home.edu.vn.io.TextFileFactory;
import home.edu.vn.model.Customer;

import java.util.ArrayList;

public class TestCustomer2 {

	public static void testSaveFile2()
	{
		ArrayList<Customer>listCustomer=new ArrayList<Customer>();
		listCustomer.add(new Customer("KH01","Nguyễn Thị An"));
		listCustomer.add(new Customer("KH02","Trần Văn Bình"));
		listCustomer.add(new Customer("KH03","Hồ Thị Giải"));
		listCustomer.add(new Customer("KH01","Hoàng Ngọc Thoát"));
		
		boolean result=SerializeFileFactory.saveFile(listCustomer, "e:\\dulieu2.txt");
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
		//testSaveFile2();
		ArrayList<Customer>listCustomer=SerializeFileFactory.readFile("e:\\dulieu2.txt");
		
		System.out.println("List of customer loaded into computer is:");
		System.out.println("Id\tName");
		for(Customer cus: listCustomer)
		{
			System.out.println(cus);
		}
	}

}
