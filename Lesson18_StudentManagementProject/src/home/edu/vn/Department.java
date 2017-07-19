package home.edu.vn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Department implements Serializable{
	private String depCode;
	private String depName;
	private Vector<Staff>staffs;
	
	public void addStaff(Staff stf)
	{
		this.staffs.add(stf);
		stf.setDep(this);
	}
	
	public Department() {
		super();
		this.staffs=new Vector<Staff>();
	}
	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public Vector<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Vector<Staff> staffs) {
		this.staffs = staffs;
	}
	@Override
	public String toString() {
		return this.depName;
	}
}
