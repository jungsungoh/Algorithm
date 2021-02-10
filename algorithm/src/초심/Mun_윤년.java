package 초심;

import java.util.Scanner;

public class Mun_윤년 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num % 400 == 0) {
			System.out.println("1");
		}else if(num % 4 ==0 && num%100 != 0){
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
}
