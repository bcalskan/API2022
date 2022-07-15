package z_deneme_test_data;

import java.util.HashMap;
import java.util.Map;

public class denemeJsonPlaceHolderTestData {


    public Map<String, Object> expectedDataWithAllKeys(Integer userId, Integer id, String title, Boolean completed) {
        Map<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("userId", userId);
        expectedData.put("id", id);
        expectedData.put("title", title);
        expectedData.put("completed", completed);

        return expectedData;
    }



    //   {
    //    "firstname": "Luca",
    //    "lastname": "Wilson",
    //    "totalprice": 792,
    //    "depositpaid": false,
    //    "bookingdates": {
    //        "checkin": "2022-07-14",
    //        "checkout": "2022-07-21"
    //    },
    //    "additionalneeds": "Dinner"
    //}


}
