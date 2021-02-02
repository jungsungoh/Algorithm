package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		int mom = sc.nextInt();
		int value = mom+100-key;
		
		System.out.println("비만수치는 "+value + "입니다");
		if(value > 0 )
		{
			System.out.println("당신은 비만이군요");
		}
	}

}
