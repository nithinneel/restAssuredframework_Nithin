package interview;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2 {
	
	Object id;
	
@Test(enabled = false)
public void createSingleUser() {
	JSONObject jObj = new JSONObject();
	jObj.put("name", "nithin");
	jObj.put("job", "leader");
	
	baseURI="https://reqres.in/";
	
	Response response = given().body(jObj).contentType(ContentType.JSON)
	.when().post("/api/users");
	response.then().assertThat().statusCode(201);
	response.then().assertThat().contentType(ContentType.JSON);
	response.then().log().all();
	//System.out.println(response.getContentType());
	//System.out.println(response.asString());
	//System.out.println(response.prettyPrint());
	//System.out.println(response.prettyPeek());
	//System.out.println(response.getStatusCode());
	//System.out.println(response.getStatusLine());
	//System.out.println(response.getTime());
	//System.out.println(response.getBody());
	
}

@Test(enabled = false)
public void toGetSingleUser() {
	baseURI="https://reqres.in/";
	Response response = when().get("/api/users?page=2");
	//response.then().assertThat().time(Matchers.lessThan(3500L),TimeUnit.MILLISECONDS);
	//response.then().assertThat().statusCode(200).log().all();
	List<String> data = response.jsonPath().get("data.email");
	for(String email:data) {
		System.out.println(email);
	}

}

@Test(enabled = false)
public void createByPojoClass() {
	ReqresPojoClass pObj = new ReqresPojoClass("preetam", "engineer");
	baseURI="https://reqres.in/";
	given().contentType(ContentType.JSON).body(pObj)
	.when().post("/api/users")
	.then().log().all();
}


@Test(dataProvider = "dataprovider",enabled = false, priority = 1)
public void dataDrivenTestingByDataProviderAndPojoClass(String name, String job) {
	ReqresPojoClass pojoObj = new ReqresPojoClass(name, job);
	baseURI="https://reqres.in/";
	Response resp = given().contentType(ContentType.JSON).body(pojoObj)
	.when().post("/api/users");
	resp.then().log().all();
	id = resp.jsonPath().get("id");
	System.out.println(id);
}
@DataProvider
public Object[][] dataprovider(){
	Object[][] dpr = new Object[2][2];
	dpr[0][0]="goutham";
	dpr[0][1]="engineer";
	
	dpr[1][0]="sanagmesh";
	dpr[1][1]="testEngineer";
	return dpr;
}

@Test(dependsOnMethods = "dataDrivenTestingByDataProviderAndPojoClass", enabled = false, priority = 2)
public void getRequestUsingPathParameter() {
	baseURI="https://reqres.in/";
	given()
	.pathParam("userid", id)
	.when().get("/api/users/{userid}")
	.then().log().all();
}
@Test(enabled = false)
public void reqResAuthentication() {
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("email", "eve.holt@reqres.in");
	map.put("password", "cityslicka");
	
	baseURI="https://reqres.in/";
	
	given().contentType(ContentType.JSON).body(map)
	.when().post("/api/login")
	.then().log().all();
	
}
@Test
public void getAllRequest() {
	baseURI="https://reqres.in/";
	Response response = when().get("/api/users?page=2");
	//response.then().assertThat().statusCode(200)
	//.log().all();
	Object data = response.jsonPath().get("data.*");
}
}
