package CRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class putProjectTest {
	@Test
	public void putProject() {
		//create JSON object
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Nithin");
		jObj.put("projectName", "RestAssurepro-007");
		jObj.put("status", "created");
		jObj.put("teamSize",8); 
		
		//Request type and content type 
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.body(jObj);
		requestSpecification.contentType(ContentType.JSON);
		
		//validate
		Response putResponce = requestSpecification.put("http://localhost:8084/projects/TY_PROJ_1802");
		ValidatableResponse validatePut = putResponce.then();
		validatePut.assertThat().statusCode(200);
		validatePut.log().all();
		
	}
	
}
