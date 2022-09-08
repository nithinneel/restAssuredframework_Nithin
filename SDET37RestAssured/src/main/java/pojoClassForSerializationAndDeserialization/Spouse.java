package pojoClassForSerializationAndDeserialization;

public class Spouse extends Employee {
	String spouseName;
	String spouseID;
	long spousePhone;
	String spouseEmail;
	
	public Spouse(String employeeName, String employeID, String employeeEmail, long phoneNo, String spouseName,
			String spouseID, long spousePhone, String spouseEmail) {
		super(employeeName, employeID, employeeEmail, phoneNo);
		this.spouseName = spouseName;
		this.spouseID = spouseID;
		this.spousePhone = spousePhone;
		this.spouseEmail = spouseEmail;
	}
	
	public Spouse() {
		
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseID() {
		return spouseID;
	}

	public void setSpouseID(String spouseID) {
		this.spouseID = spouseID;
	}

	public long getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(long spousePhone) {
		this.spousePhone = spousePhone;
	}

	public String getSpouseEmail() {
		return spouseEmail;
	}

	public void setSpouseEmail(String spouseEmail) {
		this.spouseEmail = spouseEmail;
	}
	
	
}
