package phy.jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalUnit;

public class LocalDateTimeTest {
	public static void main(String[] args) {
		
		//获取当前时间
		LocalDateTime localDateTime = LocalDateTime.now();
		//格式化日期
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
		System.out.println(localDateTime.format(format));

		// 当前日期
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));

		// 明天
		LocalDate tomorrow = localDate.plusDays(1);
		System.out.println(tomorrow);

		// 查看星期几
		DayOfWeek dayOfWeek = LocalDate.parse("2019-08-26").getDayOfWeek();
		System.out.println(dayOfWeek);

		// 是否闰年
		boolean leapYear = LocalDate.now().isLeapYear();
		System.out.println(leapYear);

		// 日期先后
		boolean before = LocalDate.now().isBefore(LocalDate.parse("2019-06-12"));
		System.out.println(before);

		LocalDate localDate1 = LocalDate.now();
		LocalDate localDate2 = localDate1.minusWeeks(1);

		// Period 修改给定的值或两个日期的差值
		Period period = Period.between(localDate1, localDate2);
		System.out.println(period.getDays());

		LocalTime localTime1 = LocalTime.of(10, 30);
		LocalTime localTime2 = localTime1.plusSeconds(30);

		// Duration 跟Period类似，处理时间
		Duration duration = Duration.between(localTime1, localTime2);
		System.out.println(duration.getSeconds());
	}
}
