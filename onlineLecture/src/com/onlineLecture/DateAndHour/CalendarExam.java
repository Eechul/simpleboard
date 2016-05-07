package com.onlineLecture.DateAndHour;

import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		// �Ϲ� Ŭ���� �ν��Ͻ�ó�� ����� ���� �ƴ�
		// '�߻�Ŭ����' �� ������ �ڱ��ڽ��� �ν��Ͻ��� �����
		// ������ ������ �ڱ��ڽ��� �ν��Ͻ�ȭ ��Ű�� ���� �ƴ�
		// �ڽ� Ŭ���� 'Gregorian Calender'�� Ŭ������ �ν��Ͻ�ȭ �ϰ� �ȴ�.
		// �̷��� �ϴ� ������ �ڹ��� �������� ���ؼ���� �� ���� �ִ�.
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		// ���� ���� ������ 0~11 �����̴�. +1 �ʼ�
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		
		// 12�÷� ǥ��
		System.out.println(cal.get(Calendar.HOUR));
		// 24�÷� ǥ��
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		// ��
		System.out.println(cal.get(Calendar.MINUTE));
		
		// 5�ð� ������ 
		cal.add(Calendar.HOUR, 5);
		
		// -- �� ���� ������ ����, ����� ���� 5�ð��� �ΰ� �� �� �ִ�
		// ���� ������� ��¥�� �����ϰ� �� �� �� ����
		
		// 12�÷� ǥ��
		System.out.println(cal.get(Calendar.HOUR));
		// 24�÷� ǥ��
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		// ��
		System.out.println(cal.get(Calendar.MINUTE));
		
		
		
	}

}
