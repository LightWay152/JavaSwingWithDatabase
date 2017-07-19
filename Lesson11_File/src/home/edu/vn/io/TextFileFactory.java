package home.edu.vn.io;

import home.edu.vn.model.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TextFileFactory {
	public static boolean saveFile(ArrayList<Customer>listCustomer,String path)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream(path);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw=new BufferedWriter(osw);
			for(Customer cus: listCustomer)
			{
				String line=cus.getId()+";"+cus.getName();
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			osw.close();
			fos.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<Customer>readFile(String path)
	{
		ArrayList<Customer>listCustomer=new ArrayList<Customer>();
		
		try
		{
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			String line=br.readLine();
			while(line!=null)
			{
				String []arr=line.split(";");
				if(arr.length==2)
				{
					Customer cus=new Customer(arr[0],arr[1]);
					listCustomer.add(cus);
				}
				line=br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return listCustomer;
	}
}
