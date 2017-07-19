package home.edu.vn;

import java.util.ArrayList;
import java.util.Collections;

public class TestEmployee {
	
	public static void main(String[] args){
		ArrayList<Employee>list=new ArrayList<Employee>();
		list.add(new Employee(5, "teo"));
		list.add(new Employee(2, "an"));
		list.add(new Employee(1, "hong"));
		list.add(new Employee(4, "binh"));
		list.add(new Employee(3, "tinh"));
		list.add(new Employee(6, "an"));
		
		System.out.println("List of employee of company is:");
		for(Employee em:list)
		{
			System.out.println(em.getId()+" "+em.getName());
		}
		
		Collections.sort(list);
		
		System.out.println("List of sorted employee of company is:");
		for(Employee em:list)
		{
			System.out.println(em.getId()+" "+em.getName());
		}
	}
}
