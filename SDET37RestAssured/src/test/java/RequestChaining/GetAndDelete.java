package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetAndDelete {
@Test
public void getAndDeleteProject() {
	String actualProjectId="nitpro17";
	baseURI="http://localhost";
	port=8084;
	Response response = when()
	.get("/projects");
	
	List<String> pId = response.jsonPath().get("projectId");
	System.out.println(pId);
	for(String proID: pId) {
		if (proID.equalsIgnoreCase(actualProjectId)) {
			System.out.println(proID);
			given()
			.pathParam("projectId", proID)
			.when()
			.delete("/projects/{projectId}")
			.then()
			.assertThat().statusCode(204).log().all();
			break;
		}
	}
	response.then().log().all();
	System.out.println(pId);
}
}
