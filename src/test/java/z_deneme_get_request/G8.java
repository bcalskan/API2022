package z_deneme_get_request;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme_test_data.denemeJsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class G8 extends JsonPlaceHolderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get01() {
        spec.pathParams("first", "todos", "second", 2);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualData = response.as(HashMap.class);
        response.prettyPrint();

        Map<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        expectedData.put("StatusCode", 200);
        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");

        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("StatusCode"), response.getStatusCode());
        assertEquals(expectedData.get("Via"), response.getHeader("Via"));
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));
    }

    @Test
    public void get02() {
        spec.pathParams("first", "todos", "second", 2);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        response.prettyPrint();

        denemeJsonPlaceHolderTestData deneme = new denemeJsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap = deneme.expectedDataWithAllKeys(1, 2, "quis ut nam facilis et officia qui", false);
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");
        expectedDataMap.put("StatusCode", 200);


        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("id"),actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("StatusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));

    }

}
