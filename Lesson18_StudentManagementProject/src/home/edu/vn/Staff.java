package home.edu.vn;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable{
	private String stfCode;
	private String stfName;
	private Date startWorkDay;
	private Date yearOfBirth;
	private Department dep;
	
	
	public Staff(String stfCode, String stfName, Date startWorkDay,
			Date yearOfBirth) {
		super();
		this.stfCode = stfCode;
		this.stfName = stfName;
		this.startWorkDay = startWorkDay;
		this.yearOfBirth = yearOfBirth;
	}
	public String getStfCode() {
		return stfCode;
	}
	public void setStfCode(String stfCode) {
		this.stfCode = stfCode;
	}
	public String getStfName() {
		return stfName;
	}
	public void setStfName(String stfName) {
		this.stfName = stfName;
	}
	public Date getStartWorkDay() {
		return startWorkDay;
	}
	public void setStartWorkDay(Date startWorkDay) {
		this.startWorkDay = startWorkDay;
	}
	public Date getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(Date yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	
}
