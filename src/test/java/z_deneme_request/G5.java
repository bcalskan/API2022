package z_deneme_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class G5 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
     */

    @Test
    public void get01() {
        spec.pathParams("first", "booking").
                queryParams("firstname", "Aaron",
                        "lastname", "Chen");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains(" "));
    }
}
