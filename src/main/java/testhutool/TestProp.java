package testhutool;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.dialect.Props;

/**
 * @author liyanpeng
 * @date 2018/12/30
 */
public class TestProp {
	public static String name;
	public static Integer age;

	public static void init() {
		Props props = new Props("test.properties", CharsetUtil.CHARSET_UTF_8);

		name = props.getStr("name", "liyanpeng");
		age = props.getInt("age", 25);

	}
}
