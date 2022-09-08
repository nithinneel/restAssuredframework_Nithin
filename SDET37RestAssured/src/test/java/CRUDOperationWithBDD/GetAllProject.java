package CRUDOperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProject{
@Test
public void getallePro() {
	baseURI="http://localhost";
	port=8084;
	
	when()
	.get("/projects")
	
	.then()
	.log().all();
}
}
