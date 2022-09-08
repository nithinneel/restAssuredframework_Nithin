package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeArray;

public class EmployeeArraySerialization {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//Create array variables
		String[] empEmail = {"nithin@gmail.com", "goutham@gmail.com"};
		long[] empPhone = {9900940201L, 889966318L};
		//Create object of Pojo class
		EmployeeArray empArray = new EmployeeArray("Nithin", "007", empEmail, empPhone);
		//create object of objectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		//Use writeVale()
		objectMapper.writeValue(new File("./empArray"), empArray);
	}
}

