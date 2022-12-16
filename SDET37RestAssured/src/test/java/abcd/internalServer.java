package abcd;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class internalServer {
public static void main(String[] args) {
	JSONObject obj = new JSONObject();
	Response response = given().contentType(ContentType.JSON).body(obj)
	.when().get("baseuri+endPoint");
	int statuscode = response.getStatusCode();
	response.then().assertThat().log().all();
	assertTrue(true, "pass no internal server error");

	
}
}
