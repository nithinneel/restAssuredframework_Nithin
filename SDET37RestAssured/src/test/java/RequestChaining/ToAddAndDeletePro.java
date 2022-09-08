package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import javax.annotation.meta.When;

import org.testng.annotations.Test;

import JavaUtility.JavaLib;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClass.createProLibrary;

public class ToAddAndDeletePro {
@Test
public void addAndDeltePro() {
	JavaLib jLib = new JavaLib();
	createProLibrary pObj = new createProLibrary("Nithin", "Zen"+jLib.toGetRandomNumber(),"created",5);
	
	baseURI="http://localhost";
	port=8084;
	
	 Response response = given()
	.body(pObj)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject");
	
	//capture the project id
	 String proID = response.jsonPath().get("projectId");
	 response.then().log().all();
	 
	//delete the Project
	 given()
	 .pathParam("pID", proID)
	 .when()
	 .delete("/projects/{pID}")
	 .then()
	 .assertThat().statusCode(204).log().all();
}
}
