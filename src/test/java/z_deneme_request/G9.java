package z_deneme_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class G9 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/90
        When
            I send GET Request to the url
        Then
            Response body should be like that;
      {
    "firstname": "Luca",
    "lastname": "Wilson",
    "totalprice": 792,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-07-14",
        "checkout": "2022-07-21"
    },
    "additionalneeds": "Dinner"
}
     */

    @Test
    public void get01() {
        spec.pathParams("first","booking","second",90);

        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2022-07-14");
        bookingdatesMap.put("checkout","2022-07-21");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname","Luca");
        expectedData.put("lastname","Wilson");
        expectedData.put("totalprice",792);
        expectedData.put("depositpaid",false);
        expectedData.put("bookingdates",bookingdatesMap);
        expectedData.put("additionalneeds","Dinner");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectedData.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"),actualDataMap.get("Dinner"));

        assertEquals(bookingdatesMap.get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));

    }
}
