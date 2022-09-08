package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathPameters {
@Test
public void getProjectByPathParameters() {
	baseURI="http://localhost";
	port=8084;
	
	given()
	.pathParam("projectId", "TY_PROJ_1003")
	.when()
	.get("/projects/{projectId}")
	.then()
	.assertThat().statusCode(200).log().all();
}
}
