package home.edu.vn;

public abstract class Employee {
	private String name;
	private String id_card;
	public abstract int exportSalary();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public Employee(String name, String id_card) {
		super();
		this.name = name;
		this.id_card = id_card;
	}
	public Employee() {
		super();
	}
	
	public String toString() {
		return this.name+"==>"+exportSalary();
	}
}
