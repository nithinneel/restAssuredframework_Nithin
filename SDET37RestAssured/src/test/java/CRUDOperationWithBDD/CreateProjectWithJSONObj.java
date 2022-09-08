package CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithJSONObj {
	
	@Test
	public void createProject() {
		//Step1: create the pre requisites - request body
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "nithin");
		jObj.put("projectName", "pro123nit");
		jObj.put("status", "completed");
		jObj.put("teamSize", 12);
		
		baseURI="http://localhost";
		port = 8084;
		
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
