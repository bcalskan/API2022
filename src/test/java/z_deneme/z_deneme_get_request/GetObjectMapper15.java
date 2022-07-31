package z_deneme.z_deneme_get_request;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;

public class GetObjectMapper15 extends HerOkuAppBaseUrl {
     /*
        Given
               https://restful-booker.herokuapp.com/booking/22
        When
            I send GET Request to the URL
      Then
            Status code is 200
           {
                "firstname": "Oliver",
                "lastname": "Smith",
                "totalprice": 100,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2022-07-18",
                    "checkout": "2022-07-19"
                },
                "additionalneeds": "Breakfast"
            }
     */

    @Test
    public void get1ObjectMapper() {
        spec.pathParams("first", "booking", "second", 22);

        String expectedData = "{\n" +
                "                \"firstname\": \"Oliver\",\n" +
                "                \"lastname\": \"Smith\",\n" +
                "                \"totalprice\": 100,\n" +
                "                \"depositpaid\": true,\n" +
                "                \"bookingdates\": {\n" +
                "                    \"checkin\": \"2022-07-18\",\n" +
                "                    \"checkout\": \"2022-07-19\"\n" +
                "                },\n" +
                "                \"additionalneeds\": \"Breakfast\"\n" +
                "            }";

        BookingPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

        Response response = given().spec(spec).when().get("/{first}/{second}");

        BookingPojo actualDataPojo = JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(expectedDataPojo.getFirstname(),actualDataPojo.getFirstname());
        softAssert.assertEquals(expectedDataPojo.getLastname(),actualDataPojo.getLastname());
        softAssert.assertEquals(expectedDataPojo.getTotalprice(),actualDataPojo.getTotalprice());
        softAssert.assertEquals(expectedDataPojo.getDepositpaid(),actualDataPojo.getDepositpaid());
        softAssert.assertEquals(expectedDataPojo.getBookingdates().getCheckin(),actualDataPojo.getBookingdates().getCheckin());
        softAssert.assertEquals(expectedDataPojo.getBookingdates().getCheckout(),actualDataPojo.getBookingdates().getCheckout());
    }


}
