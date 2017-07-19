package home.edu.vn;

public class DemoCustomer {
	
	//only use private for method 
	//to ensure encapsulation of object
	private String id;
	private String name;
	private int age;
	private String address;
	
	private static double x;
	public void changeXInfo(int newValue)
	{
		x=newValue;
	}
	public double getXInfo()
	{
		return x;
	}
	
	public String getId()
	{
		return this.id;//this is internal access method
	}
	public void setId(String id)
	{
		//this.id: Instance Variable
		//id: Local Variable
		this.id=id;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getAge()
	{
		return this.age;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setAddress(String address)
	{	
		this.address=address;
	}
	
	//Constructor none argument
	public DemoCustomer()
	{
		System.out.println("Default contructor auto be call");
	}
	
	//Constructor have argument
	public DemoCustomer(String id,String name,int age,String address)
	{
		this.id=id;
		this.name=name;
		this.age=age;
		this.address=address;
	}
	
	public String toString() {
		return this.id+""+this.name+""+this.age+""+this.address+"";
	}
	
	
}
