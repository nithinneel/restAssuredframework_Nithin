package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Spouse;

public class EmpSpouseSerialization {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//create object of Pojo class
		Spouse spouse = new Spouse("Nithin", "007","neel@qwe",990097777l,"Spouse2","008",789456132l,"asdff@qwer");
		//create object of ObjectMapper
		ObjectMapper objMapper = new ObjectMapper();
		//Use writeValue() from ObjectMapper
		objMapper.writeValue(new File("./EmpSpouse.json"), spouse);
	}
}
