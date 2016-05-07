package com.onlineLecture.DateAndHour;

import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		// 일반 클래스 인스턴스처럼 만드는 것이 아닌
		// '추상클래스' 기 때문에 자기자신을 인스턴스로 만든다
		// 엄연히 따지면 자기자신을 인스턴스화 시키는 것이 아닌
		// 자식 클래스 'Gregorian Calender'의 클래스를 인스턴스화 하게 된다.
		// 이렇게 하는 이유는 자바의 버전업을 위해서라고 할 수도 있다.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		// 월의 대한 정보는 0~11 까지이다. +1 필수
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		
		// 12시로 표시
		System.out.println(cal.get(Calendar.HOUR));
		// 24시로 표시
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		// 분
		System.out.println(cal.get(Calendar.MINUTE));
		
		// 5시간 후으로 
		cal.add(Calendar.HOUR, 5);
		
		// -- 이 밑은 위에껄 복붙, 출력을 보면 5시간후 인걸 알 수 있다
		// 같은 방법으로 날짜도 가능하고 분 초 도 가능
		
		// 12시로 표시
		System.out.println(cal.get(Calendar.HOUR));
		// 24시로 표시
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		// 분
		System.out.println(cal.get(Calendar.MINUTE));
		
		
		
	}

}
