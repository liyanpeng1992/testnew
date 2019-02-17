package gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonNull {
    public static void main(String[] args) {
        JsonParser parser = new JsonParser();

        String res = "{\"name\": {},\"province\": [{\"name\": \"黑龙江\",\"cities\": {\"city\": [\"哈尔滨\", \"大庆\"]}}, {\"name\": \"广东\",\"cities\": {\"city\": [\"广州\", \"深圳\", \"珠海\"]}}, {\"name\": \"台湾\",\"cities\": {\"city\": [\"台北\", \"高雄\"]}}, {\"name\": \"新疆\",\"cities\": {\"city\": [\"乌鲁木齐\"]}}]}";

//        res.replaceAll("null","");
        JsonObject json = (JsonObject) parser.parse(res);

        System.out.println(json.getAsJsonObject("name"));
        //第一种，直接没有name这个选项   第二种有name，但是name值为空
        if (json.getAsJsonObject("name").size()==0) {
            System.out.println("111111");
        }
        if (json.get("name")==null||json.get("name").isJsonNull() ||json.get("name").getAsString().isEmpty())

        if (json.get("name")==null||json.get("name").isJsonNull() ||json.get("name").getAsJsonArray().size()==0)

        if (json.get("name")==null||json.get("name").isJsonNull() ||json.get("name").getAsJsonObject().size()==0)




        if (json.get("name").isJsonNull()) {
            System.out.println("22222");
        }


        System.out.println("Done");

    }
}
