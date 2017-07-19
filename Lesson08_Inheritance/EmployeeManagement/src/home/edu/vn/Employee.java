package home.edu.vn;

public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	//0 ==> 2 object equal each other
	//>0 ==> object1>object2
	//<0 ==> object1<object2
	public int compareTo(Employee arg0) {
		int compareName=this.name.compareToIgnoreCase(arg0.getName());
		if(compareName==0)
		{
			if(this.id==arg0.id)
				return 0;
			if(this.id>arg0.id)
				return -1;
			return 1;
		}
		return compareName;
	}
	
	
}
