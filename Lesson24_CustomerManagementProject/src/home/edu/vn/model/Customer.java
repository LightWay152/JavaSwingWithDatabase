package home.edu.vn.model;

public class Customer {
	private String id;
	private String name;
	private String phone;
	private String email;
	private CustomerGroup group;
	
	
	
	public Customer() {
		super();
	}
	public Customer(String id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CustomerGroup getGroup() {
		return group;
	}
	public void setGroup(CustomerGroup group) {
		this.group = group;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
