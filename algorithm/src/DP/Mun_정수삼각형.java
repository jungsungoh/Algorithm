package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int[][] d = new int[501][501];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		d[0][0] = arr[0][0];
		for(int i=1; i<n; i++) {
			d[i][0] = d[i-1][0]+arr[i][0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<i+1; j++) {
				d[i][j] = Math.max(d[i-1][j], d[i-1][j-1])+arr[i][j];
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(d[n-1][i], max);
		}
		System.out.println(max);
		// 1. 테이블 정의하기
		// d[n][i] = n번째 줄,i번쨰 열에 오는데 수의 합
		
		// 2. 점화식 세우기
		// d[i][j] = Math.max(d[i-1][j] , d[i-1][j+1])+arr[i][j];
		
		// 3. 초기값 설정하기.
		// d[i][0] = arr[i][0];
	}
}
