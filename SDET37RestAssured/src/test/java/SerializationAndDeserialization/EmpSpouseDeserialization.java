package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Spouse;

public class EmpSpouseDeserialization {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Spouse empSpouse = objectMapper.readValue(new File("./EmpSpouse.json"), Spouse.class);
		System.out.println(empSpouse.getEmployeeName());
		System.out.println(empSpouse.getSpouseName());
	}
}
