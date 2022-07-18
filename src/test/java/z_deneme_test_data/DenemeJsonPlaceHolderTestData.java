package z_deneme_test_data;

import java.util.HashMap;
import java.util.Map;

public class DenemeJsonPlaceHolderTestData {


    public Map<String, Object> expectedDataWithAllKeys(Integer userId, String title, Boolean completed) {
        Map<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("userId", userId);
        expectedData.put("title", title);
        expectedData.put("completed", completed);

        return expectedData;
    }

    public Map<String, Object> expectedDataWithMissingKeys(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedDataMissingKeysMap = new HashMap<String, Object>();
        expectedDataMissingKeysMap.put("userId",userId);
        expectedDataMissingKeysMap.put("title",title);
        expectedDataMissingKeysMap.put("completed",completed);

        return expectedDataMissingKeysMap;
    }

    public Map<String, Object> expectedDataWithMissingKeys2(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedDataMissingKeysMap = new HashMap<String, Object>();

        if (userId != null){
            expectedDataMissingKeysMap.put("userId",userId);
        }
        if (title != null){
            expectedDataMissingKeysMap.put("title",title);
        }
        if (completed != null){
            expectedDataMissingKeysMap.put("completed",completed);
        }

        return expectedDataMissingKeysMap;
    }

}
