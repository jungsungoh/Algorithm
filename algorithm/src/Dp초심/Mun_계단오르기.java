package Dp초심;

import java.util.Scanner;

public class Mun_계단오르기 {
	public static void main(String[] args) {
		
		// 테이블 만들기
		// D[i][j] = 현재까지 j개의 계단을 연속해서 밟고, i 번째 계단까지 올라섰을 때 점수 합의 최댓값, 단 i번째 계단은 반드시 밟아야함
		
		// 점화식
		// D[k][1] = max(D[k-2][1], D[k-2][2]) + S[k];
		// D[k][2] = D[k-1][1]+s[3] ;
		
		// 초기값 설정
		//d[1][1] = s[1] d[1][2] = 0
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] D = new int[n+1][3];
		
		D[1][1] = arr[1];
		for(int i=2; i<=n; i++) {
			D[i][1] = Math.max(D[i-2][1], D[i-2][2])+arr[i];
			D[i][2] = D[i-1][1] +arr[i];
		}
		System.out.println(Math.max(D[n][1], D[n][2]));
	}
}


