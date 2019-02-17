import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TestJsonArray {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");

		int start = 2;
		int rows = 3;
		int sum = start + rows;
		//测试Json字符串转List
		String jsonList = new Gson().toJson(list);
		List list1 = new Gson().fromJson(jsonList, List.class);


//		List<String> strings = list1.subList(start, sum);

		List<String> strings = list.subList(start, list.size());


		System.out.println(strings);


	}


}
