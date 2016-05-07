package com.onlineLecture.DateAndHour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();
		//System.out.println(date.toString());

		//내가 원하는 폼으로 바꿀수 있다.
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(ft.format(date));
		
		//현재시간을 long 타입으로 변환
		System.out.println(date.getTime());
		
		
		long today = System.currentTimeMillis();
		System.out.println(today);
		
	}

}
