package CRUDOperationWithBDD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JavaUtility.JavaLib;
import io.restassured.http.ContentType;
import pojoClass.createProLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectDataDrivenTesting {
	JavaLib jLib = new JavaLib();
@Test(dataProvider = "proData")
public void CreateMulitpleProjectsWithDifferentData(String createdBy, String projectName, String status, int teamSize) {
	//create prerequisites
	createProLibrary pLib = new createProLibrary(createdBy, projectName+jLib.toGetRandomNumber(), status, teamSize);
	baseURI="http://localhost";
	port=8084;
	
	given()
	.body(pLib)
	.contentType(ContentType.JSON)
	
	.when()
	.post("/addProject")
	
	.then().statusCode(201)
	.log().all();
}

//data provider method
@DataProvider
public Object[][] proData(){
	Object[][] data = new Object[3][4];
	
	data[0][0]="nithin";
	data[0][1]="dell";
	data[0][2]="created";
	data[0][3]=5;
	
	data[1][0]="nithin";
	data[1][1]="sony";
	data[1][2]="created";
	data[1][3]=5;
	
	data[2][0]="nithin";
	data[2][1]="dell";
	data[2][3]=5;
	
	return data;
}
}
