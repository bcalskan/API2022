package z_deneme.z_deneme_get_object_mapper;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetObjectMapper14 extends JsonPlaceHolderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos/198
        When
         I send GET Request to the URL
      Then
         Status code is 200
         And response body is like {
                               "userId": 10,
                               "id": 198,
                               "title": "quis eius est sint explicabo",
                               "completed": true
                             }
     */


    @Test
    public void get1ObjectMapper() {

        spec.pathParams("first", "todos", "second", 198);

        String expectedData = "{\n" +
                " \"userId\": 10,\n" +
                " \"id\": 198,\n" +
                " \"title\": \"quis eius est sint explicabo\",\n" +
                " \"completed\": true\n" +
                " }";

        Map<String, Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualBodyMap = JsonUtil.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"), actualBodyMap.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualBodyMap.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualBodyMap.get("completed"));
    }


    @Test
    public void get2ObjectMapper() {
        spec.pathParams("first", "todos", "second", 198);

        String expectedData = "{\n" +
                " \"userId\": 10,\n" +
                " \"id\": 198,\n" +
                " \"title\": \"quis eius est sint explicabo\",\n" +
                " \"completed\": true\n" +
                " }";

        JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);

        Response response = given().spec(spec).when().get("/{first}/{second}");

        JsonPlaceHolderPojo actualBodyPojo = JsonUtil.convertJsonToJavaObject(response.asString(), JsonPlaceHolderPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataPojo.getUserId(),actualBodyPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualBodyPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualBodyPojo.getCompleted());


    }


}
