package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2CoopProject {
@Test
public void oauthCoopProject() {
	//create request to generate access token
	Response response = given()
	.formParam("client_id", "mychicken")
	.formParam("client_secret", "9dab373be53c6f07947a7ee8318a4855")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "https://nithinneelgunda.com")
	.formParam("code", "3756")
	
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	
	//capture the access token from the response of the above request
	String token = response.jsonPath().get("access_token");
	System.out.println(token);
	
	//create another request and use the token to access the API's
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", 3756)
	
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
	.then().log().all();
}
}
