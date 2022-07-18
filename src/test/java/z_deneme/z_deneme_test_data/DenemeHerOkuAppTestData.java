package z_deneme.z_deneme_test_data;

import java.util.HashMap;
import java.util.Map;

public class DenemeHerOkuAppTestData {

    public Map<String, Object> bookingdates(String checkin, String checkout){
        Map<String,Object> bookingdatesMap = new HashMap<String,Object>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);

        return bookingdatesMap;
    }

    public Map<String, Object> expectedDataWithAllKeys(String firstname, String lastname, Integer totalprice, Boolean depositpaid,Map<String,Object> bookingdates){
        Map<String,Object> expectedDataMap = new HashMap<String, Object>();
        expectedDataMap.put("firstname",firstname);
        expectedDataMap.put("lastname",lastname);
        expectedDataMap.put("totalprice",totalprice);
        expectedDataMap.put("depositpaid",depositpaid);
        expectedDataMap.put("bookingdates",bookingdates);

        return expectedDataMap;
    }

}
