package DP;

import java.util.Scanner;

public class Mun_이친수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[91][2];
		
		d[1][0] = 0; d[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			d[i][0] = d[i-1][0] +d[i-1][1];
			d[i][1] = d[i-1][0];
		}
		System.out.println(d[n][0]+d[n][1]);
		// 1. 테이블 정의하기
		// d[i][0] = I자리 이친수이며, 마지막 값이 0 인 이친수의 개수
		// d[i][1] = I자리 이친수이며, 마지막 값이 1 인 이친수의 개수.
		
		// 2. 점화식 세우기
		// d[i][0] = d[i-1][0] + d[i-1][1];
		// d[i][1] = d[i-1][0]
		
		// 3. 초기값 설정하기.
		// d[1][0] = 1 // d[0][0] = 0
	}
}
