package com.java.first;

import java.util.Locale;

public class CircleArea {

	public static void main(String[] args) {
		int r = 5;
		double val = 2*Math.PI * r;
		val = Double.parseDouble(String.format(Locale.KOREAN, "%.2f", val));
		System.out.println("반지름이 5cm인 원의 넓이는 " + val + "cm입니다.");
	}

}
