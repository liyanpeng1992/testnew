import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;


import java.util.*;

public class TestMulMap {
    public static void main(String[] args) {
       Multimap<Integer, Integer> multimap = LinkedHashMultimap.create();
        List<Map<String,Integer>> list = new ArrayList<>();
        Map<String,Integer> map1= new HashMap<String, Integer>(){{
            put("time",2345);
            put("used",30);
        }};
        Map<String,Integer> map2= new HashMap<String, Integer>(){{
            put("time",2445);
            put("used",15);
        }};
        Map<String,Integer> map3= new HashMap<String, Integer>(){{
            put("time",2645);
            put("used",18);
        }};
        Map<String,Integer> map4= new HashMap<String, Integer>(){{
            put("time",5345);
            put("used",30);
        }};



        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        for (Map<String,Integer> m: list
             ) {
            Integer time = m.get("time");
            Integer used = m.get("used");
            multimap.put(time/1000,used);
        }


        System.out.println(multimap);

       List<Map<String,Integer>> result=new ArrayList<>();

        for (Integer key:multimap.keySet()
             ) {
            Collection<Integer> values = multimap.get(key);
            int sum=0;
            for (Integer n:values
                 ) {
                sum+=n;
            }
            Map<String,Integer> m=new HashMap<>();
            m.put("time", key);
            m.put("used",sum/values.size());
            result.add(m);
        }

        System.out.println(result);
    }



}
