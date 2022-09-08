package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import JavaUtility.JavaLib;
import io.restassured.http.ContentType;
import pojoClass.createProLibrary;

public class CreateAndUpdateProject {
@Test
public void createAndUpdatePro() {
	//create the body
	JavaLib jLib = new JavaLib();
	baseURI="http://localhost";
	port=8084;
	
	createProLibrary pLib = new createProLibrary("nithin","cipla","created",5);
	given()
	.body(pLib)
	.contentType(ContentType.JSON)
	//Action
	.when()
	.post("/addProject")
	//validation
	.then().statusCode(201).log().all();
	
	
	
	
}
}
