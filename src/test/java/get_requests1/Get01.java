package get_requests1;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman manuel API testi icin kullanilir.
    2) API otomasyon testi icin Rest-Assured Library kullanilir
    3) Otomasyon kodlarinin yazimi icin izlenecek adimlar;
            a) Gereksinimleri anlamak
            b) Test case yazma
                 -Test case yazimi icin 'Gherkin language' kullanilir
                    'Gherkin' bazi keywordlere sahiptir;
                    x) Given : Ön kosullar
                    y) When : Aksiyonlar
                    z) Then : Dönütler
                    t) And : Coklu islemler

            c) Testing kodunun yazimi
                    i) Set the url
                    ii) Set the expected data (POST-PUT-PATCH)
                    iii) Type code to send request
                    iv) Do Assertion
     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/3
    When
        User sends a GET Request to the URL
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01() {
        //  i) Set the url
        String url = "https://restful-booker.herokuapp.com/booking/193";

        //  ii) Set the expected data (POST-PUT-PATCH)

        //  iii) Type code to send request
        Response response = given().when().get(url);
        //System.out.println(response); --> referans kodu verir
        //response.prettyPrint(); //--> düzgün yazdirir

        //  iv ) Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code nasil yazdirilir :
        System.out.println("Status Code : " + response.statusCode());

        // Content Type nasil yazdirilir
        System.out.println("Content Type : " + response.contentType());

        // Header nasil yazdirilir
        System.out.println("Header : " + response.header("User-Agent"));

        // Headers nasil yazdirilir
        System.out.println(response.headers());

        // Time nasil yazdirilir
        System.out.println(response.getTime());
    }
}
