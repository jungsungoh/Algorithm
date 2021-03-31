package Dp초심;

import java.util.Scanner;

public class Mun_RGB거리 {
	public static void main(String[] args) {
		// 테이블 정의하기
		// D[i] = i번째 집까지 칠하는데 필요한 비용의 최소값. D[i][0] = 빨강, D[i][1] = 초록, D[i][2] = 파랑
		
		// 점화식 구하기
		// D[k][0] = Math.max(D[k-1][1], D[k-1][2]) + arr[0][i]
		
		// 초기값 설정
		// D[1][0] = arr[0][0] , D[1][1] = arr[1][0], D[1][2] = arr[2][0];
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] arr = new int[n+1][3];
		int[][] D = new int[n+1][3];
		
		for(int i=1; i<=n; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		D[1][0] = arr[1][0];D[1][1] = arr[1][1]; D[1][2] = arr[1][2];
		
		for(int i=2; i<=n; i++) {
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + arr[i][0];
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + arr[i][1];
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + arr[i][2];
		}
		
		int result = Math.min(D[n][0], D[n][1]);
		result = Math.min(result, D[n][2]);
		
		System.out.println(result);
	}
}
