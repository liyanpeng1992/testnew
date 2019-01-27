package gsontest;

import com.google.gson.Gson;

import java.util.Map;

public class TestGonsObject {
	public static void main(String[] args) {
		String s = "testString";
//		JsonParser jsonParser = new JsonParser();
//		try {
//			JsonObject parse = (JsonObject)jsonParser.parse(s);
//			System.out.println(parse);
//		}catch (Exception e){
//			System.out.println("不是Json字符串");
//		}
		Map map = new Gson().fromJson(s, Map.class);
		System.out.println(map);


	}
}
