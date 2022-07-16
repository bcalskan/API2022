package z_deneme_test_data;

import java.util.HashMap;
import java.util.Map;

public class denemeGoRestTestData {
    //"meta": null,
    //        "data": {
    //        "id": 2986,
    //        "name": "Msgr. Lila Mahajan",
    //        "email": "msgr_mahajan_lila@ledner-howell.io",
    //        "gender": "female",
    //        "status": "active"
    //            }
    //        }

    public Map<String, Object> innerMapWithAllKeys(Integer id, String name, String email, String gender, String status) {
        Map<String, Object> innerMap = new HashMap<String, Object>();
        innerMap.put("id", id);
        innerMap.put("name", name);
        innerMap.put("email", email);
        innerMap.put("gender", gender);
        innerMap.put("status", status);

        return innerMap;
    }


    public Map<String, Object> outerMapWithAllKeys(Object meta, Map<String, Object> data) {
        Map<String, Object> outerMap = new HashMap<String, Object>();
        outerMap.put("meta", meta);
        outerMap.put("data", data);

        return outerMap;
    }


}
