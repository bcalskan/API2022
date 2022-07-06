package get_requests;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Adamz" and last name is "Dear"
     */

    @Test
    public void get01() {
        //1. Step : Set the URL
        spec.pathParams("first", "booking").
                queryParams("firstname", "Aaron",
                        "lastname", "Chen");

        //2. Step : Set the expected data

        //3. Step : Set the request and get response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        // "bookingid": 1649

        //4. Step : Do Assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));


    }
}
