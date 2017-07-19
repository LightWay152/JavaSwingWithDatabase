package home.edu.vn;

public class DemoTestCustomer {

	public static void main(String[] args) {
		DemoCustomer teo=new DemoCustomer();
		teo.setId("NV1");
		//teo.id="NV1";//Never use like that
		teo.setName("Tran Van Teo");
		teo.setAge(30);
		teo.setAddress("Ca Mau");
		System.out.println(teo);
		
		System.out.println("Only want to get address = "+teo.getAddress());
		
		//Alias: 2 object 1 refer to the same memory cell
		DemoCustomer ty=new DemoCustomer();
		ty.setName("Ho Thi Ty");
		
		System.out.println("Name of Teo = "+teo.getName());
		System.out.println("Name of Ty = "+ty.getName());
		
		teo=ty;
		teo.setName("Ho Van Do");
		System.out.println("Name of Ty = "+ty.getName());
		
		System.out.println("x = "+teo.getXInfo());
		DemoCustomer an=new DemoCustomer();
		an.changeXInfo(100);
		System.out.println("x = "+teo.getXInfo());
		DemoCustomer binh=new DemoCustomer();
		System.out.println("x of Binh = "+binh.getXInfo());
	}

}
