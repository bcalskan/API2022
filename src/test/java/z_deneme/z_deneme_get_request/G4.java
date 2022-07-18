package z_deneme.z_deneme_get_request;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class G4 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get01() {
        spec.pathParams("first", "todos");
        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}");
        response.then().assertThat().statusCode(200).contentType("application/json").body("title", hasItem("quis eius est sint explicabo"),
                "id", hasSize(200),
                "userId", hasItems(2, 7, 9));

    }
}
