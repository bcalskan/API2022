package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String, String> bookingdatesSetUp(String checkin, String checkout) {
        Map<String, String> bookingdatesMap = new HashMap<String, String>();
        bookingdatesMap.put("checkin", checkin);
        bookingdatesMap.put("checkout", checkout);
        return bookingdatesMap;
    }

    public Map<String, Object> expectedDataSetUp(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdates) {
        Map<String, Object> expectedDataMap = new HashMap<String, Object>();
        expectedDataMap.put("firstname", firstname);
        expectedDataMap.put("lastname", lastname);
        expectedDataMap.put("totalprice", totalprice);
        expectedDataMap.put("depositpaid", depositpaid);
        expectedDataMap.put("bookingdates", bookingdates);
        return expectedDataMap;
    }
}
