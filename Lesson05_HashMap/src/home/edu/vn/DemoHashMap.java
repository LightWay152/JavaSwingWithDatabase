package home.edu.vn;

import java.util.HashMap;

public class DemoHashMap {

	public static void main(String[] args) {
		HashMap<Integer,String> list=new HashMap<Integer,String>();
		list.put(113,"Nguyen Van Teo, his hometown is Truong Sa");
		list.put(114, "Tran Thi Met, her hometown is Hoang Sa");
		list.put(115,"Nguyen Van Tun, his hometown is Ca Mau");
		
		String employee=list.get(114);
		
		System.out.println(employee);
		System.out.println("\nAll employees in company is:");
		for(String name: list.values()){
			System.out.println(name);
		}
		
		list.remove(115);
		System.out.println("\nAll employees in company after remove is:");
		for(String name: list.values()){
			System.out.println(name);
		}
	}

}
