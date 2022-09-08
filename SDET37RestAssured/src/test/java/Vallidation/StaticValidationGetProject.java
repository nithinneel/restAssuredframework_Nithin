package Vallidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticValidationGetProject {
@Test
public void staticBodyValidationGetProject() {
	baseURI="http://localhost";
	port=8084;
	String expextedData="nitpro18";
	Response response = when().get("/projects");
	//System.out.println(response);
	
	String actualData = response.jsonPath().get("[1].projectId");
	Assert.assertEquals(actualData, expextedData);
	response.then().log().all();
}
}
