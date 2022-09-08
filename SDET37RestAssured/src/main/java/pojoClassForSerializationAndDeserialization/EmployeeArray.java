package pojoClassForSerializationAndDeserialization;

public class EmployeeArray {
		
		String EmployeeName;
		String EmployeeID;
		String[] EmployeeEmails;
		long[] EmployeePhone;
		
		
		public EmployeeArray(String employeeName, String employeeID, String[] employeeEmails, long[] employeePhone) {
			super();
			EmployeeName = employeeName;
			EmployeeID = employeeID;
			EmployeeEmails = employeeEmails;
			EmployeePhone = employeePhone;
		}
		
		public EmployeeArray() {
			
		}

		public String getEmployeeName() {
			return EmployeeName;
		}


		public void setEmployeeName(String employeeName) {
			EmployeeName = employeeName;
		}


		public String getEmployeeID() {
			return EmployeeID;
		}


		public void setEmployeeID(String employeeID) {
			EmployeeID = employeeID;
		}


		public String[] getEmployeeEmails() {
			return EmployeeEmails;
		}


		public void setEmployeeEmails(String[] employeeEmails) {
			EmployeeEmails = employeeEmails;
		}


		public long[] getEmployeePhone() {
			return EmployeePhone;
		}


		public void setEmployeePhone(long[] employeePhone) {
			EmployeePhone = employeePhone;
		}
		
		
}
