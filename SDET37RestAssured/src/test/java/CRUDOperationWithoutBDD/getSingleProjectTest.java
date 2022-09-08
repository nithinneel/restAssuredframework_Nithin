package CRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getSingleProjectTest {
@Test
public void getSingleProTest() {
	Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1802");
	ValidatableResponse validateResponce = response.then();
	validateResponce.assertThat().statusCode(200);
	validateResponce.assertThat().contentType(ContentType.JSON);
	validateResponce.log().all();
}
}
