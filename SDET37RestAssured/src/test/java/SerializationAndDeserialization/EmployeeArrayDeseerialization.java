package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeArray;

public class EmployeeArrayDeseerialization {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objmapper = new ObjectMapper();
		EmployeeArray empArray = objmapper.readValue(new File("./empArray"), EmployeeArray.class);
		System.out.println(empArray.getEmployeeID());
		System.out.println(empArray.getEmployeeName());
		System.out.println(empArray.getEmployeeEmails()[0]+" "+empArray.getEmployeeEmails()[1]);
		System.out.println(empArray.getEmployeePhone()[0]+" "+empArray.getEmployeePhone()[1]);
	}
}
