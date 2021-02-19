package DP;

import java.util.Scanner;

public class Mun_피보나치함수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] p = new int[41][2];
		// 1. 테이블 채우기
		p[0][0] = 1; p[1][1] = 1;
		for(int i=2; i<41; i++) {
			p[i][0] = p[i-1][0] + p[i-2][0];
			p[i][1] = p[i-1][1] + p[i-2][1];
		}
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			System.out.println(p[num][0] + " " + p[num][1]);
		}
	}
}
