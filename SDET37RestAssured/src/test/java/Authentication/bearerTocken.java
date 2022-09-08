package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class bearerTocken {
@Test
public void bearertocken() {
	baseURI="https://api.github.com";
	given()
	.auth()
	.oauth2("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")
	.when().get("/repos/nithinneel/oauthSDET37")
	.then().assertThat().statusCode(200)
	.log().all();
}
}
