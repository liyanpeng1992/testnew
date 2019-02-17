package gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class gsonNullTest {
    public static void main(String[] args) {
        String test = "{\"name\":\"zhangsan\",\"age\":18}";

        JsonParser jsonParser = new JsonParser();
        JsonElement parse = jsonParser.parse(test);

        JsonObject asJsonObject = parse.getAsJsonObject();
        asJsonObject.getAsJsonArray("name");

    }

    private static boolean isStrEmpty(String key, JsonObject jsonObject) {

        return jsonObject.get(key) == null || jsonObject.get(key).isJsonNull() ;
    }

    private static boolean isArrEmpty(String key, JsonObject jsonObject) {

        return jsonObject.get(key) == null || jsonObject.get(key).isJsonNull() || jsonObject.getAsJsonArray().size() == 0;
    }

    private static boolean isObjEmpty(String key, JsonObject jsonObject) {

        return jsonObject.get(key) == null || jsonObject.get(key).isJsonNull() || jsonObject.getAsJsonObject().size() == 0;
    }

}
