package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class EmployeeDeserialization {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Employee emp = objectMapper.readValue(new File("./employee.json"), Employee.class);
		System.out.println("employeeName = "+emp.getEmployeeName() +" empID = "+ emp.getEmployeID()+" empPh = "+emp.getPhoneNo());
	}
}
