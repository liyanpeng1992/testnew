package gsontest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class Gson2JsonTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2",null);

        Gson gson = new Gson();
        String s1 = gson.toJson(map);
        String  s= "{\"k2\":}";
        JsonParser jsonParser = new JsonParser();
        JsonObject parse = (JsonObject)jsonParser.parse(s);
        if (parse.get("k2").isJsonNull()){
            System.out.println("1111111");
        }

//        String k2 = parse.get("k2").getAsString();
//        String replace = k2.replace("u", "xx");
//        System.out.println(k2);
    }
}
