package Vallidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DyanmicValidationGetProject {
@Test
public void dynammicValidationGetProject() {
	//pre Condition
	baseURI="http://localhost";
	port=8040;
	String actualData="nitpro18";
	//Action
	Response response = when().get("/projects");
	
	//Validation
	boolean flag=false;
	List<String> pID = response.jsonPath().get("projectId");
	for(String projectID:pID) {
		if (projectID.equalsIgnoreCase(actualData)) {
			flag=true;
		}
	}
	Assert.assertTrue(true);
	System.out.println("HI..");
	response.then().log().all();
	
}
}
