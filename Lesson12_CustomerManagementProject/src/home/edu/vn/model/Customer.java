package home.edu.vn.model;

import java.io.Serializable;

public class Customer implements Serializable,Comparable<Customer>{
	private int id;
	private String name;
	private String phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public Customer() {
		super();
	}
	public String toString() {
		return this.id+"\t"+this.name+"\t"+this.phone;
	}
	public int compareTo(Customer o) {
		return this.phone.compareToIgnoreCase(o.phone);
	}
	
}
