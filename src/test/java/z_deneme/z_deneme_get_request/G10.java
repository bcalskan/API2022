package z_deneme.z_deneme_get_request;

import base_Urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import z_deneme.z_deneme_test_data.DenemeGoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class G10 extends GoRestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                {
            https://gorest.co.in/public/v1/users/2986
       {
        "meta": null,
        "data": {
        "id": 2986,
        "name": "Msgr. Lila Mahajan",
        "email": "msgr_mahajan_lila@ledner-howell.io",
        "gender": "female",
        "status": "active"
            }
        }
     */

    @Test
    public void get01() {
        spec.pathParams("first", "users", "second", 2986);

        DenemeGoRestTestData dnm = new DenemeGoRestTestData();
        Map<String, Object> innerExpectedMap = dnm.innerMapWithAllKeys(2986, "Msgr. Lila Mahajan", "msgr_mahajan_lila@ledner-howell.io", "female", "active");
        Map<String, Object> outerExpectedMap = dnm.outerMapWithAllKeys(null,innerExpectedMap);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        Map<String,Object> actualMap = response.as(HashMap.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(outerExpectedMap.get("meta"),actualMap.get("meta"));
        assertEquals(innerExpectedMap.get("id"),((Map)actualMap.get("data")).get("id"));
        assertEquals(innerExpectedMap.get("name"),((Map)actualMap.get("data")).get("name"));
        assertEquals(innerExpectedMap.get("email"),((Map)actualMap.get("data")).get("email"));
        assertEquals(innerExpectedMap.get("gender"),((Map)actualMap.get("data")).get("gender"));
        assertEquals(innerExpectedMap.get("status"),((Map)actualMap.get("data")).get("status"));




    }

}
