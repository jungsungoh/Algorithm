package DP;

import java.util.Scanner;

public class Mun_피보나치수5 {
	public static void main(String[] args) {
		
		// 테이블
		// d[k] = k번쨰 피보나치수
		
		// d[i] = d[i-1]+d[i-2];
		// d[0] = 0, d[1] = 1, d[2] = 2;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int[21];
		
		d[0] = 0;
		d[1] = 1;
		d[2] = 1;
		for(int i=3; i<=n; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		System.out.println(d[n]);
	}
}
