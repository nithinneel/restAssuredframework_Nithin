package CRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class addProjectTest {
	
	@Test
	public void CreateTest() {
		
		//create the JSON Object
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Nithin");
		jObj.put("projectName", "RestAssurepro");
		jObj.put("status", "created");
		jObj.put("teamSize",10); 
		
		//request body and content type
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jObj);
		reqSpec.contentType(ContentType.JSON);
		//validation
		Response responce = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validateResp = responce.then();
		validateResp.assertThat().contentType(ContentType.JSON);
		validateResp.assertThat().statusCode(201);
		validateResp.log().all();
		
	}
}
