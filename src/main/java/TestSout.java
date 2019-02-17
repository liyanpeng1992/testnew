import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TestSout {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("a", "a");
        map.put("b", "b");
        map.put("c", null);
        map.put("", null);
        map.put(null, "d");
        map.put(null, "e");


        StringBuilder sb = new StringBuilder();
        int count = 0;
        System.out.println(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()
                ) {
            count++;
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.isNotEmpty(value)) {
                sb.append(key + ":" + value);
                sb.append("\n");

            }
        }
        System.out.println(sb);
        System.out.println(count);
    }

}
