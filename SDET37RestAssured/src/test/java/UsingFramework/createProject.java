package UsingFramework;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import GenericUtility.EndPointsLibrary;
import GenericUtility.IConstants;
import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import pojoClass.createProLibrary;

public class createProject {
@Test
public void createpro() {
	//create request body
	JavaUtility jLib = new JavaUtility();
	baseURI=IConstants.BASEURI;
	port=IConstants.PORTNUM;
	createProLibrary pLib = new createProLibrary("nithin","asus"+jLib.createRandomNumber(),"created",5);
	given()
	.body(pLib).contentType(ContentType.JSON)
	.when()
	.post(EndPointsLibrary.createProject)
	.then()
	.assertThat().statusCode(201).log().all();
	
}
}
