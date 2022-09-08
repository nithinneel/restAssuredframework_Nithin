package CRUDOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClass.createProLibrary;

public class CreateProUsingPojoClass {
	@Test
	public void createProUdingPojo() {
		//create request body
		createProLibrary pLib = new createProLibrary("nithin","nnggiioo","created",10);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}
}
