package z_deneme_get_request;

import base_Urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class G11 extends GoRestBaseUrl {
     /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Sen. Shreya Guha", "Bhooshit Mishra", "Rati Deshpande" are among the users
        And
            The female users are more than or equals to male users
     */

    @Test
    public void get01() {
        spec.pathParam("first", "users");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("meta.pagination.limit", equalTo(10),
                "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                "data.id", hasSize(10),
                "data.status", hasItem("active"),
                "data.name", hasItems("Sen. Shreya Guha", "Bhooshit Mishra", "Rati Deshpande"));

        //Bayan ve erkek sayısını karşılaştıralım
        //1. Yol: Tüm cinisyetli çekip bayan sayısı ile karşılaştıralım.
        JsonPath json = response.jsonPath();
        List<String> femaleList = json.getList("data.findAll{it.gender=='female'}.gender");
        List<String> maleList = json.getList("data.findAll{it.gender=='male'}.gender");
        System.out.println("Bayan sayisi = "+femaleList.size());
        System.out.println("Erkek sayisi = "+maleList.size());


    }
}
