package utils;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    //1. Method: Json datasini Java objesine cevirir (De-Serialization)
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls) {//Generetic Method
        T javaResult = null;
        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaResult;
    }


    //2. Method: Java objesini Json dataya cevirir(De-Serialization)

}
