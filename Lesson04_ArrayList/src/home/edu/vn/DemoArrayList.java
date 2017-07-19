package home.edu.vn;

import java.util.ArrayList;

public class DemoArrayList {

	public static void main(String[] args) {
		/*ArrayList list = new ArrayList();
		list.add("x");
		list.add(9+"");
		
		ArrayList list2 = new ArrayList();
		list2.add("1.5");
		*/
		ArrayList list3 = new ArrayList();
		list3.add("An");
		list3.add("Binh");
		list3.add("Giai");
		list3.add("Thoat");
		list3.add(2, "Teo");
		
		for(int i=0;i<list3.size();i++)
		{
			String x=list3.get(i)+"";
			System.out.println(x);
		}
		
		System.out.println("===================");
		for(Object data: list3)
		{
			System.out.println(data);
		}
		
		ArrayList<Double> list4=new ArrayList<Double>();
		for(int i=0;i<10;i++)
		{
			list4.add(i*2.0);
		}
		System.out.println("Value of list 4 is:");
		for(double x: list4)
		{
			System.out.println(x);
		}
		
		ArrayList<Float> list5=new ArrayList<Float>();
		list5.add(1.5f);
		list5.add(1.8f);
		System.out.println("Number of list 5 is = "+list5.size());
		list5.add(113.114f);
		System.out.println("Number of list 5 is = "+list5.size());
		list5.remove(1.5f);
		System.out.println("Number of list 5 is = "+list5.size());
		System.out.println("Elements in ArrayList list5 is:");
		for(float x: list5)
		{
			System.out.println(x);
		}
		list5.set(0, 78.99f);
		
		System.out.println("Elements in ArrayList list5 is:");
		for(float x: list5)
		{
			System.out.println(x);
		}
	}

}
