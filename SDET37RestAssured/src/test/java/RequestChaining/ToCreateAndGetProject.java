package RequestChaining;

import org.testng.annotations.Test;

import JavaUtility.JavaLib;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.createProLibrary;

import static io.restassured.RestAssured.*;

public class ToCreateAndGetProject {
@Test
public void createAndGetProject() {
	JavaLib jLib = new JavaLib();
	
	//create request body
	createProLibrary pLib = new createProLibrary("Nithin","Apple"+jLib.toGetRandomNumber(),"created",10);
	
	baseURI="http://localhost";
	port=8084;
	
	Response response = given()
	.body(pLib)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject");
	
	//capture the project ID
	String porId = response.jsonPath().get("projectId");
	System.out.println(porId);
	response.then().log().all();
	
	//get the project
	given()
	.pathParam("pid", porId)
	.when()
	.get("/projects/{pid}")
	.then()
	.assertThat().statusCode(200).log().all();
	
}
}
