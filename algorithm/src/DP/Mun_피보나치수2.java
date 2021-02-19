package DP;

import java.util.Scanner;

public class Mun_피보나치수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] d = new long[91];
		int n = sc.nextInt();
		
		d[0] = 0; d[1] = 1;
		
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		System.out.println(d[n]);
		// 1. 테이블 정의하기
		// d[i] = n번째 피보나치 수열
		// 2. 점화식 세우기
		// d[i] = d[i-1] + d[i-2];
		// 3. 초기값 설정하기.
		// d[0] =0 , d[1] = 1
	}
}
