package com.onlineLecture.DateAndHour;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {

	public static void main(String[] args) {
		Date date = new Date();
		//System.out.println(date.toString());

		//���� ���ϴ� ������ �ٲܼ� �ִ�.
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println(ft.format(date));
		
		//����ð��� long Ÿ������ ��ȯ
		System.out.println(date.getTime());
		
		
		long today = System.currentTimeMillis();
		System.out.println(today);
		
	}

}
