package testcompare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestUserComparable {
	public static void main(String[] args) {
		List<User> userList =new ArrayList<>();

		userList.add(new User("zhangsan", 18));
		userList.add(new User("lisi", 20));
		// 不能为空
		userList.add(new User(null, 22));
		userList.add(new User("lisi", 25));
		userList.add(new User("wangwu", 16));

		userList.stream().sorted(Comparator.comparing(User::getName))
				.sorted(Comparator.comparing(User::getAge).reversed())
				.forEach(System.out::println);


	}


}
