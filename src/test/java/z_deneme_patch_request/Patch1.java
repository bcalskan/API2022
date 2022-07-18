package z_deneme_patch_request;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme_test_data.DenemeJsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Patch1 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									   }
     */

    @Test
    public void patch01() {
        spec.pathParams("first", "todos", "second", 198);

        DenemeJsonPlaceHolderTestData request = new DenemeJsonPlaceHolderTestData();
        Map<String, Object> requestMap = request.expectedDataWithMissingKeys2(null, "Wash the dishes", null);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestMap).patch("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> assertMap = request.expectedDataWithAllKeys(10, "Wash the dishes", true);
        response.then().assertThat().statusCode(200).body("title", equalTo(assertMap.get("title")),
                "userId", equalTo(assertMap.get("userId")),
                "completed", equalTo(assertMap.get("completed")));
    }
}
