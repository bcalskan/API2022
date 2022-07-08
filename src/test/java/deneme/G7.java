package deneme;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class G7 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get01() {
        spec.pathParams("first", "todos");
        Response response = given().spec(spec).when().get("/{first}");
        JsonPath j = response.jsonPath();
        response.then().assertThat().statusCode(200);

        List<String> ids = j.getList("findAll{it.id>190}.id");
        System.out.println(ids);
        assertTrue(10 == ids.size());

        List<Integer> userIds = j.getList("findAll{it.id<5}.userId");
        System.out.println(userIds);
        assertTrue(4 == userIds.size());

        List<String> titles = j.getList("findAll{it.id<5}.title");
        System.out.println(titles);
        assertTrue(titles.contains("delectus aut autem"));





    }


}
