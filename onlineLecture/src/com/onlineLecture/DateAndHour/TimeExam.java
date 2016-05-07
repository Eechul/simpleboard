package com.onlineLecture.DateAndHour;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExam {

	public static void main(String[] args) {
		// 현재 날짜와 시간을 가진 객체를 생성
		LocalDateTime timePoint = LocalDateTime.now();
		System.out.println(timePoint);
		
		//날짜
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
		System.out.println(ld1);
		
		// 시간
		LocalTime lt1 = LocalTime.of(17, 18);
		System.out.println(lt1);
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
		
		// 자바 Date API , Time API는 이런것들을 제공하고 있음.
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);
		Month month = theDate.getMonth();
		System.out.println(timePoint.getMonth());
		System.out.println(month.getValue());
		System.out.println(timePoint.getHour());
		
	}

}
