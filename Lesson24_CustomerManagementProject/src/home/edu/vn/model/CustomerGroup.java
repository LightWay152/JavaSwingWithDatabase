package home.edu.vn.model;

import java.util.Vector;

public class CustomerGroup {
	private String id;
	private String name;
	private Vector<Customer>customers;
	
	
	public void addCustomer(Customer cus)
	{
		this.customers.add(cus);
		cus.setGroup(this);
	}
	public CustomerGroup() {
		super();
		this.customers=new Vector<Customer>();
	}
	public CustomerGroup(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.customers=new Vector<Customer>();
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
	public Vector<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Vector<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
}
