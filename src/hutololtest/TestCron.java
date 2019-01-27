package hutololtest;


import java.util.Timer;
import java.util.TimerTask;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;


public class TestCron {

	private static final String NAME = "lee";

	public static void main(String[] args) {

		new Timer("timer - ").schedule(new TimerTask() {
			@Override
			public void run() {
				getCol();
			}
			//	延迟 delay 执行并每隔period 执行一次
		}, 0, 3000);
	}


	public static void getCol() {
		String temp = FileUtil.readString("test.txt", CharsetUtil.CHARSET_UTF_8);
		if (!temp.equals(NAME)) {
			Console.log("获取到文件内容为 {}", temp);
		} else {
			Console.log("名字相同");
		}


	}


}
