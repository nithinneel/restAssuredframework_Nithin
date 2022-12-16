package interview;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class P1 {
@Test(invocationCount = 0)

public void create() {
//	"name": "morpheus",
//    "job": "leader"
//POST
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("name", "morpheus");
	map.put("job", "leader");
	
	baseURI="https://reqres.in/";
	given().contentType(ContentType.JSON)
	.body(map)
	.when().post("/api/users")
	.then().assertThat().statusCode(201).log().all();
	
}


@Test

public void postSingelUser() {
	
	
}
}
