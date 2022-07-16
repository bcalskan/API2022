package z_deneme_get_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class G6 extends HerOkuAppBaseUrl {

    /*
    Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;

            {
    "firstname": "GGS",
    "lastname": "FINCH",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    }
}
     */

    @Test
    public void get01() {
        spec.pathParams("first", "booking", "second", 555);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.then().assertThat().statusCode(200).contentType("application/json").
                body("firstname", equalTo("Norah"),
                        "lastname", equalTo("Girard"),
                        "totalprice", equalTo(509),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2022-07-08"),
                        "bookingdates.checkout", equalTo("2022-07-13"));


        //2.yol
        JsonPath j = response.jsonPath();
        assertEquals("Norah",j.getString("firstname"));
        assertEquals("Girard",j.getString("lastname"));
        assertEquals(509,j.getInt("totalprice"));
        assertEquals(false,j.getBoolean("depositpaid"));
        assertEquals("2022-07-08",j.getString("bookingdates.checkin"));
        assertEquals("2022-07-13",j.getString("bookingdates.checkout"));

    }


}
