package delete_request5;

import base_Urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponseBodyPojo;
import pojos.DummyDeletePojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {
    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
 */

    @Test
    public void delete01() {
        spec.pathParams("first", "delete", "second", 2);

        Response response = given().spec(spec).contentType(io.restassured.http.ContentType.JSON).when().delete("/{first}/{second}");

        DummyDeletePojo expected = new DummyDeletePojo("success", "2", "Successfully! Record has been deleted");
        DummyDeletePojo actual = JsonUtil.convertJsonToJavaObject(response.asString(), DummyDeletePojo.class);

        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getData(), actual.getData());
        assertEquals(expected.getMessage(), actual.getMessage());

    }


}
