import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {


        Map<String ,Object> map = new HashMap<>();
        map.put("user","ZS");
        map.put("password","123455");
        map.put("rule","2");
        map.put("condition","130423870206007");

        Gson gson = new Gson();
        String data = gson.toJson(map);


//        String rule = "2";
//        String condition = "130423870206007";
//        String data = "{\"user\":\"ZS\",\"password\":\"123455\",\"rule\":\"" + rule + "\",\"condition\":\"" + condition + "\"}";



        System.out.println(data);

    }


}
