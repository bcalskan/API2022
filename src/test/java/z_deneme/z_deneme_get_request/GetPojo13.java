package z_deneme.z_deneme_get_request;

import base_Urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme.z_deneme_pojos.DenemeGoRestInnerDataPojo;
import z_deneme.z_deneme_pojos.DenemeGoRestOuterDataPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class GetPojo13 extends GoRestBaseUrl {
    /*
        Given

        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
        https://gorest.co.in/public/v1/users/255
            Response body should be like
           {
    "meta": null,
    "data": {
        "id": 255,
        "name": "Dhanapati Menon DVM",
        "email": "dvm_dhanapati_menon@abernathy.co",
        "gender": "male",
        "status": "active"
    }
}
    */

    @Test
    public void getPojo2() {

        spec.pathParams("first", "users", "second", 255);

        DenemeGoRestInnerDataPojo innerData = new DenemeGoRestInnerDataPojo(255, "Dhanapati Menon DVM", "dvm_dhanapati_menon@abernathy.co", "male", "active");
        DenemeGoRestOuterDataPojo outerData = new DenemeGoRestOuterDataPojo(null, innerData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        DenemeGoRestOuterDataPojo actualBodyData = response.as(DenemeGoRestOuterDataPojo.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(outerData.getMeta(), actualBodyData.getMeta());
        assertEquals(outerData.getData().getId(), actualBodyData.getData().getId());
        assertEquals(outerData.getData().getName(), actualBodyData.getData().getName());
        assertEquals(outerData.getData().getEmail(), actualBodyData.getData().getEmail());
        assertEquals(outerData.getData().getGender(), actualBodyData.getData().getGender());
        assertEquals(outerData.getData().getStatus(), actualBodyData.getData().getStatus());


    }
}
