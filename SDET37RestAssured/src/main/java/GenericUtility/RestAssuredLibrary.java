package GenericUtility;

import java.util.List;

import io.restassured.response.Response;
/**
 * 
 * @author nithin
 *
 */
public class RestAssuredLibrary {
	/**
	 * this method will give the json data through json path from the response
	 * @param response
	 * @param path
	 * @return
	 */
	public List<String> getJsonDataList(Response response, String path) {
		List<String> jsonData = response.jsonPath().get(path);
		return jsonData;
	}
	public String getJsonData(Response response, String path) {
		String jsonData = response.jsonPath().get(path);
		return jsonData;
}
}