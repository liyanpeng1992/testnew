import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class TestJsonFrom2 {
	public static void main(String[] args) {
		String s="{\"captureTimeBegin\":0,\"captureTimeEnd\":1527320959,\"systemID\":null}";
//		String s="{\"captureTimeBegin\":0,\"captureTimeEnd\":1527320959,\"systemID\":\"ZJJ\"}";
//		String s="{\"captureTimeBegin\":0,\"captureTimeEnd\":1527320959,\"systemID\":\"ZJJ\"}";
//		Map map = new Gson().fromJson(s, Map.class);
//		Object systemID = map.get("system");
//		System.out.println(systemID);
		//Json字符串中只有key没有Value是错误的，直接什么也不写不行，如果值为空必须写成null
//		TestJsonEntry jsonEntry = new Gson().fromJson(s, TestJsonEntry.class);
//		String systemID = jsonEntry.getSystemID();
//		System.out.println(systemID);


		JsonParser jsonParser = new JsonParser();
		JsonObject parse = (JsonObject)jsonParser.parse(s);
		System.out.println(parse.get("systemID"));

	}
}
