package timestest;

import java.time.LocalDate;

import cn.hutool.core.lang.Console;

public class timesimple1 {
	public static void main(String[] args) {
		// 1.在Java 8中获取今天的日期
		LocalDate today = LocalDate.now();
		Console.log("今天的日期是 {}", today);

		// 2.获取年、月、日信息
		int year = today.getYear();
		int monthValue = today.getMonthValue();
		int dayOfMonth = today.getDayOfMonth();
		Console.log("{}年 {}月 {}日", year,monthValue,dayOfMonth);

		// 3.处理特定日期
		LocalDate dataOfBirth = LocalDate.of(1993,5,24);
		Console.log("生日是{}",dataOfBirth);

		// 4.判断两个日期是否相等
		LocalDate localDate = LocalDate.of(2019, 1, 27);
		if (localDate.equals(today)){
			Console.log("今天 {} 和new data {} 相等",today,localDate);
		}



	}
}
