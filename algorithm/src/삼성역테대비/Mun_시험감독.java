package 삼성역테대비;

import java.util.Scanner;

public class Mun_시험감독 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] test_place = new int[n];
		for(int i=0; i<n; i++) {
			test_place[i] = sc.nextInt(); // 각 시험장 응시자 수
			
		}
		int b = sc.nextInt(); // 총감독관 관리가능
		int c = sc.nextInt(); // 부감독관 관리 가능
		
		for(int i=0; i<n; i++) {
			
			
			
		}
	}
}


// 총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다.
// 감독관은 총감독관과 부감독관으로 두 종류가 있다. 
// 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.


// 각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.

// 각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.