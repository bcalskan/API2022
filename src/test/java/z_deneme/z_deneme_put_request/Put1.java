package z_deneme.z_deneme_put_request;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme.z_deneme_test_data.DenemeJsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Put1 extends JsonPlaceHolderBaseUrl {
     /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void put01() {
        spec.pathParams("first", "todos", "second", 198);

        DenemeJsonPlaceHolderTestData denemeExpectedData = new DenemeJsonPlaceHolderTestData();
        Map<String, Object> denemeExpectedDataMap = denemeExpectedData.expectedDataWithMissingKeys(21, "Wash the dishes", false);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(denemeExpectedDataMap).when().put("/{first}/{second}");
        Map<String, Object> actualDataMap = response.as(HashMap.class);

        assertEquals(denemeExpectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(denemeExpectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(denemeExpectedDataMap.get("completed"),actualDataMap.get("completed"));
    }
}
