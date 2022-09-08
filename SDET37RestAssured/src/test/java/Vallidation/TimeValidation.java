package Vallidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TimeValidation {
@Test
public void createProjectTimeManagement() {
	
	Random ranNum = new Random();
	int randomNumber = ranNum.nextInt(500);
	//create JSON Object
	
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "goutham");
	jObj.put("projectName", "Philip"+randomNumber);
	jObj.put("status","created");
	jObj.put("teamSize", 5);
	
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(jObj)
	.contentType(ContentType.JSON)
	
	.when().post("/addProject")
	
	.then()
	.assertThat()
	.time(Matchers.lessThan(450L),TimeUnit.MILLISECONDS)
	.log().all();
	Reporter.log("time with in 450ms",true);
	
	
	
}
}
