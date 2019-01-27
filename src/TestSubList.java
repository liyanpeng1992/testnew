

import java.util.ArrayList;
import java.util.List;

public class TestSubList {
	public static void main(String[] args) {



		List<Integer> resultsList = new ArrayList<>();
		resultsList.add(0);
		resultsList.add(1);
		resultsList.add(2);
		resultsList.add(3);
		resultsList.add(4);
		resultsList.add(5);
		resultsList.add(6);
		List<Integer> subList = resultsList.subList(0, 5);
		System.out.println(subList);
		resultsList.subList(5,resultsList.size()).clear();
		System.out.println(resultsList);
	}
}
