package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAath {
@Test(priority = 1)
public void basicAuth() {
	baseURI="http://localhost";
	port=8084;
	
	given()
	.auth().basic("rmgyantra", "rmgy@9999")
	.when()
	.get("/login")
	.then()
	.assertThat().statusCode(202).log().all();
}

@Test(priority = 2)
public void basicPreEmptiveAuth() {
	baseURI="http://localhost";
	port=8040;
	
	given()
	.auth().preemptive().basic("rmgyantra", "ramgy@9999")
	.when()
	.get("/login")
	.then().assertThat().statusCode(202).log().all();
}

@Test(priority = 3)
public void basicDigestiveAuth() {
	baseURI="http://localhost";
	port=8084;
	
	given()
	.auth().digest("rmgyantra", "rmgy@9999")
	.when().get("/login")
	.then().assertThat().statusCode(202).log().all();
}
}
