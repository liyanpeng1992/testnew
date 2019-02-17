package testhutool;

import cn.hutool.core.lang.Console;
import cn.hutool.system.SystemUtil;

public class TestAuto {
	public static void main(String[] args) {
		// TestProp.init();
		// String name = TestProp.name;
		// Integer age = TestProp.age;
		// for (int i = 0; i < 10; i++) {
		// 	Console.log("我的名字是{},年龄是{}", name, age);
		// 	ThreadUtil.sleep(5, TimeUnit.SECONDS);
		// }

		String s = SystemUtil.get(SystemUtil.OS_NAME);
		Console.print("系统名称是{}",s);

	}
}
