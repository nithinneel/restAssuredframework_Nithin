package CRUDOperationWithBDD;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
@Test
public void createPro() {
	//create request body
	HashMap map = new HashMap();
	map.put("createdBy", "goutham");
	map.put("projectName", "Sony");
	map.put("status","created");
	map.put("teamSize", 5);
	
	baseURI="http://localhost";
	port=8084;

	given()
	.body(map)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();
}
}
