package home.edu.vn.test;

import home.edu.vn.io.SerializeFileFactory;
import home.edu.vn.model.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestCustomer {
	
	static ArrayList<Customer>listCustomer=new ArrayList<Customer>();
	
	public static void menu()
	{
		System.out.println("1.Input customer");
		System.out.println("2.Output customer");
		System.out.println("3.Search customer");
		System.out.println("4.Sort customer");
		System.out.println("5.Save customer");
		System.out.println("6.Read customer");
		System.out.println("7.Statistic customer");
		System.out.println("8.Exit");
		int choose=0;
		System.out.println("Please choose option[1..8]:");
		choose=new Scanner(System.in).nextInt();
		switch(choose)
		{
		case 1:
			inputHandling();
			break;
		case 2:
			outputHandling();
			break;
		case 3:
			searchHandling();
			break;
		case 4:
			sortHandling();
			break;
		case 5:
			saveHandling();
			break;
		case 6:
			readHandling();
			break;
		case 7:
			statisticHandling();
			break;
		case 8:
			exitHandling();
			break;
		default:
			break;
			
		}
	}
	
	private static void exitHandling() {
		System.out.println("Thank you for using this software. Goodbye!");
		System.exit(0);//interrupt program
	}

	private static void statisticHandling() {
		int n=0;
		System.out.println("============================");
		for(Customer customer: listCustomer)
		{
			if(customer.getPhone().startsWith("098"));
			{
				n++;
			}
		}
		System.out.println("Have "+n+" customers Viettel");
		System.out.println("============================");
	}

	private static void readHandling() {
		listCustomer=SerializeFileFactory.readFile("e:\\dulieukhachhang.db");
		System.out.println("Đã đọc File thành công!");
	}

	private static void saveHandling() {
		boolean result=SerializeFileFactory.saveFile(listCustomer, "e:\\dulieukhachhang.db");
		if(result==true)
		{
			System.out.println("Đã lưu File thành công!");
		}
		else
		{
			System.out.println("Đã lưu File thất bại!");
		}
	}

	private static void sortHandling() {
		Collections.sort(listCustomer);
		System.out.println("Completed to sort telephone number!");
	}

	private static void searchHandling() {
		String phone="";
		System.out.println("Enter first phone number wanna find:");
		phone=new Scanner(System.in).nextLine();
		System.out.println("============================");
		System.out.println("Customer have number with "+phone+" at begin is:");
		for(Customer customer: listCustomer)
		{
			if(customer.getPhone().startsWith(phone))
			{
				System.out.println(customer);
			}
		}
		System.out.println("============================");
	}

	private static void outputHandling() {
		System.out.println("============================");
		System.out.println("Id\tName\tPhone");
		for(Customer customer: listCustomer)
		{
			System.out.println(customer);
		}
		System.out.println("============================");
	}

	private static void inputHandling() {
		try
		{
			Customer customer=new Customer();
			System.out.println("Enter id:");
			int id=new Scanner(System.in).nextInt();
			System.out.println("Enter name:");
			String name=new Scanner(System.in).nextLine();
			System.out.println("Enter phone:");
			String phone=new Scanner(System.in).nextLine();
			
			customer.setId(id);
			customer.setName(name);
			customer.setPhone(phone);
			
			listCustomer.add(customer);
		}
		catch(Exception ex)
		{
			System.out.println("Wrong input. Please input again!");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		while(true)
		{
			menu();
		}
	}

}
