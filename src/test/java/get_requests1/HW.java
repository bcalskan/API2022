package get_requests1;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class HW extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/5  --> 195
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
            {
                "firstname": "Mary",
                "lastname": "Jackson",
                "totalprice": 111,
                "depositpaid": false,
                "bookingdates": { "checkin": "2017-05-23",
                                  "checkout":"2019-07-02" }
            }


            ----------------------
                          {
                  {
    "firstname": "\"Lauriana\"",
    "lastname": "\"Souza\"",
    "totalprice": 71,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-07-07",
        "checkout": "2022-07-13"
    },
    "additionalneeds": "\"Newspaper\""
}
    }
     */

    @Test
    public void get01() {
        //1. Step : Set the URL
        spec.pathParams("first", "booking", "second", 195).
                queryParams("firstname", "Lauriana", "lastname", "Souza");

        //2. Step : Set the expected data

        //3. Step : Set the request and get response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4. Step : Do Assertion
        response.then().assertThat().statusCode(200);
        assertTrue(response.asString().contains("lastname"));


    }
}
