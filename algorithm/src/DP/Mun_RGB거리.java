package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][3];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] d = new int[n+1][3];
		
		d[1][0] = arr[1][0];
		d[1][1] = arr[1][1];
		d[1][2] = arr[1][2];
		
		for(int i=2; i<=n;i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) +arr[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + arr[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + arr[i][2];
		}
		
		int val = Math.min(Math.min(d[n][0],d[n][1]),d[n][2]);
		System.out.println(val);
		// 1. 테이블 정의하기
		// D[i][0] = i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 빨간색
		// D[i][1] = i번째 집까지 칠할때 비용의 최솟값, i번째 집은 초록색
		// D[i][2] = i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 파랑색.
		
		
		// 2. 점화식 세우기
		// D[k][0] = min(D[k-1][1], D[k-1][2]) + R[k];
		// D[k][1] = min(D[k-1][0], D[k-1][2]) + G[k];
		// D[k][2] = min(D[k-1][0], D[k-1][1]) + B[k];
		
		
		// 3. 초기값 설정.
		// D[1][0] = R[k];
		// D[1][1] = G[k];
		// D[1][2] = B[k];
	}
}
