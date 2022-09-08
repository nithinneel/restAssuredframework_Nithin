package UsingFramework;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.EndPointsLibrary;
import GenericUtility.IConstants;
import GenericUtility.RestAssuredLibrary;
import io.restassured.response.Response;

public class getAllProjects  {
@Test
public void getallPro() {
	String expectedData="TY_PROJ_1003";
	RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	baseURI=IConstants.BASEURI;
	port=IConstants.PORTNUM;
	
	Response response = when()
	.get(EndPointsLibrary.getAllProjects);
	
	List<String> proIds = rLib.getJsonDataList(response, "projectId");
	boolean flag = false;
	for(String pId:proIds) {
		
		if (pId.equalsIgnoreCase(expectedData)) {
			flag=true;
		}
	}
	Assert.assertTrue(flag);
	Reporter.log("project available",true);
	response.then().assertThat().statusCode(200).log().all();
}
}
