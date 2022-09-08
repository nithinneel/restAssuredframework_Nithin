package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class EmployeeSerialization {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//Create an object for pojo class
		Employee employee = new Employee("Nithin", "emp01", "nithin@gmail.com", 99999123456789l);
		//Create an object for ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		//Use writeValue()
		objectMapper.writeValue(new File("./employee.json"), employee);
	}
}
