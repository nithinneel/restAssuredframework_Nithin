package CRUDOperationWithBDD;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProUsingJSONFILE {
@Test
public void createProUsingJsonFile() {
	//create request body
	File file = new File("./src/test/resources/CreateProject.json");
	
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(file)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then()
	.assertThat()
	.statusCode(201)
	.log().all();
	
}
}
