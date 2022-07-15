package z_deneme_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class G1 {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/193
    When
        User sends a GET Request to the URL
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01() {
        String url = "https://restful-booker.herokuapp.com/booking/193";
        Response response = given().when().get(url);
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        System.out.println(response.statusCode());
        System.out.println(response.contentType());
        System.out.println(response.statusLine());
        System.out.println(response.getTime());
    }
}
