package DP;

import java.util.Scanner;

public class Mun_123더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC =sc.nextInt();
		int[] d = new int[11];
		d[1] = 1; d[2] = 2;d[3] = 4;
		
		for(int i=4; i<=10; i++) {
			d[i] = d[i-1]+d[i-2] + d[i-3];
		}
		for(int tc=1; tc<=TC; tc++) {
			int num = sc.nextInt();
			System.out.println(d[num]);
		// 1. 테이블 정의하기
		// D[i] = i를 1,2,3의 합으로 만드는 방법 수
		
		
		// 2. 점화식 세우기
		// D[i] = D[i-1] + D[i-2] +D[i-3];
		
		
		// 3. 초기값 설정
		// D[0] = 0 D[1] = 1 D[2] = 2 D[3] = 
		}
	}
}
