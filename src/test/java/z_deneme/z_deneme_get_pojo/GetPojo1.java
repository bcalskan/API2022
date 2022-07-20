package z_deneme.z_deneme_get_pojo;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme.z_deneme_pojos.DenemeHerOkuInnerDataPojo;
import z_deneme.z_deneme_pojos.DenemeHerOkuOuterDataPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetPojo1 extends HerOkuAppBaseUrl {
     /*
    Given
            https://restful-booker.herokuapp.com/booking/185
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
{
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void getPojo1() {
        spec.pathParams("first", "booking", "second", 185);

        DenemeHerOkuInnerDataPojo bookingDatesPojo = new DenemeHerOkuInnerDataPojo("2013-02-23", "2014-10-23");
        DenemeHerOkuOuterDataPojo body = new DenemeHerOkuOuterDataPojo("Sally", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        DenemeHerOkuOuterDataPojo responseBodyClass = response.as(DenemeHerOkuOuterDataPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(body.getFirstname(),responseBodyClass.getFirstname());
        assertEquals(body.getLastname(),responseBodyClass.getLastname());
        assertEquals(body.getTotalprice(),responseBodyClass.getTotalprice());
        assertEquals(body.getDepositpaid(),responseBodyClass.getDepositpaid());
        assertEquals(body.getBookingdates().getCheckin(),responseBodyClass.getBookingdates().getCheckin());
        assertEquals(body.getBookingdates().getCheckout(),responseBodyClass.getBookingdates().getCheckout());



    }


}
