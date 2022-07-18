package z_deneme.z_deneme_post_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme.z_deneme_test_data.DenemeHerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post2 extends HerOkuAppBaseUrl {
     /*
         Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like
            {
                "bookingid": 5315,
                "booking": {
                    "firstname": "John",
                    "lastname": "Doe",
                    "totalprice": 11111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2021-09-09",
                        "checkout": "2021-09-21"
                    }
                }
             }
     */

    @Test
    public void post01() {
        spec.pathParams("first", "booking");

        DenemeHerOkuAppTestData denemeExpectedData = new DenemeHerOkuAppTestData();
        Map<String, Object> denemeExpectedDataMap = denemeExpectedData.bookingdates("2021-09-09", "2021-09-21");

        Map<String, Object> denemeExpectedDataMapAll = denemeExpectedData.expectedDataWithAllKeys("John", "Doe", 11111, true, denemeExpectedDataMap);


        Response response = given().spec(spec).contentType(io.restassured.http.ContentType.JSON).body(denemeExpectedDataMapAll).when().post("/{first}");
        Map<String, Object> actualDataMap = response.as(HashMap.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(denemeExpectedDataMapAll.get("firstname"),((Map)actualDataMap.get("booking")).get("firstname"));
        assertEquals(denemeExpectedDataMapAll.get("lastname"),((Map)actualDataMap.get("booking")).get("lastname"));
        assertEquals(denemeExpectedDataMapAll.get("totalprice"),((Map)actualDataMap.get("booking")).get("totalprice"));
        assertEquals(denemeExpectedDataMapAll.get("depositpaid"),((Map)actualDataMap.get("booking")).get("depositpaid"));

        assertEquals(denemeExpectedDataMap.get("checkin"),((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(denemeExpectedDataMap.get("checkout"),((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));
    }

}
