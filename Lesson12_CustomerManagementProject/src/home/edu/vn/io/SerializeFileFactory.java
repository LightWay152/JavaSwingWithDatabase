package home.edu.vn.io;

import home.edu.vn.model.Customer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeFileFactory {
	public static boolean saveFile(ArrayList<Customer>listCustomer,String path)
	{
		try
		{
			FileOutputStream fos=new FileOutputStream(path);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(listCustomer);
			oos.close();
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
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object data=ois.readObject();
			listCustomer=(ArrayList<Customer>) data;
			ois.close();
			fis.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return listCustomer;
	}
}
