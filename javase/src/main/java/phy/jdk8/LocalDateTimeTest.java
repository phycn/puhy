package phy.jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalDateTimeTest {
	public static void main(String[] args) {
		
		//获取当前时间
		LocalDateTime localDateTime = LocalDateTime.now();
		//格式化日期
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
		System.out.println(localDateTime.format(format));
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
	}
}
