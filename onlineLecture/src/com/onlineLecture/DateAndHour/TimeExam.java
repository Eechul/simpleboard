package com.onlineLecture.DateAndHour;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExam {

	public static void main(String[] args) {
		// ���� ��¥�� �ð��� ���� ��ü�� ����
		LocalDateTime timePoint = LocalDateTime.now();
		System.out.println(timePoint);
		
		//��¥
		LocalDate ld1 = LocalDate.of(2012, Month.DECEMBER, 12);
		System.out.println(ld1);
		
		// �ð�
		LocalTime lt1 = LocalTime.of(17, 18);
		System.out.println(lt1);
		LocalTime lt2 = LocalTime.parse("10:15:30");
		System.out.println(lt2);
		
		// �ڹ� Date API , Time API�� �̷��͵��� �����ϰ� ����.
		LocalDate theDate = timePoint.toLocalDate();
		System.out.println(theDate);
		Month month = theDate.getMonth();
		System.out.println(timePoint.getMonth());
		System.out.println(month.getValue());
		System.out.println(timePoint.getHour());
		
	}

}
