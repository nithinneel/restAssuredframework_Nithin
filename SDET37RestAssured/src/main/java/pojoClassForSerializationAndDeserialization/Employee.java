package pojoClassForSerializationAndDeserialization;

public class Employee {
	
	String employeeName;
	String employeID;
	String employeeEmail;
	long phoneNo;
	
	public Employee(String employeeName, String employeID, String employeeEmail, long phoneNo) {
		super();
		this.employeeName = employeeName;
		this.employeID = employeID;
		this.employeeEmail = employeeEmail;
		this.phoneNo = phoneNo;
	}
	public Employee() {
		
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeID() {
		return employeID;
	}
	public void setEmployeID(String employeID) {
		this.employeID = employeID;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
