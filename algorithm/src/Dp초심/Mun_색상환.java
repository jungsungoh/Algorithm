package Dp초심;

import java.util.Scanner;

public class Mun_색상환 {

	// 테이블 정의하기
	// d[i][j] = i번째 색이 있을때 j 개의 색을 선택할 수 있는 경우의  수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  =sc.nextInt();
		int k = sc.nextInt();
		
		
		int[][] d = new int[n+1][k+1];
		
		
		for(int i=1; i<=n; i++) {
			d[i][1] = i; // i 개중에 1개를 선택한 경우
			d[i][0] = 1; // i개중에 0개를 선택하는 경우
		}
		
		
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=k; j++) {
				d[i][j] = (d[i-2][j-1] + d[i-1][j])%1000000003;
			}
		}
		int answer = (d[n-3][k-1] + d[n-1][k]) %1000000003;
		System.out.println(answer);
	}
}
