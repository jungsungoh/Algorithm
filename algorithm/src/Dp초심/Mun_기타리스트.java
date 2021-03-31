package Dp초심;

import java.util.Scanner;

public class Mun_기타리스트 {
	public static void main(String[] args) {
		// 테이블 정의
		// D[i] i번째 곡을 연주할 수 있는 볼륨 중 최대 값.
		
		// 점화식 구하기
		// D[i] = D[i-1] + 5 (max 값보다 작은가? ) D[i-1] -5 (0보다 큰가?)
		
		// 초기값 설정
		// d[0] = S, N은 곡의 개수 m 은 max
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s =sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
//		int[][] d = new int[101];
//		d[0][0] = s; 
//		for(int i=1; i<=n ;i++) {
//			int val1 = d[i-1];
//			
//		}
	}
}
