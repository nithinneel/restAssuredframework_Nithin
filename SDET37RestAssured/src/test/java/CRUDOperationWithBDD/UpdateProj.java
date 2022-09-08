package CRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProj {
@Test
public void updateProject() {
	//create request body
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "nithin");
	jObj.put("projectName", "pro123nit");
	jObj.put("status", "completed");
	jObj.put("teamSize", 10);
	
	baseURI="http://localhost";
	port=8084;
	
	given().body(jObj)
	.contentType(ContentType.JSON)
	
	.when().put("/projects/TY_PROJ_2002")
	
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	
}
}
