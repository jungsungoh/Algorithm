package Dp초심;

import java.util.Scanner;

public class Mun_자두나무 {
	public static void main(String[] args) {
		// 1. 테이블 정의하기
		// d[i][j] = i시간에 j번 움직였을때 먹을 수 있는 자두 최대 개수
		// 2. 점화식 구하기
		// d[i][j] = Math.max(d[i-1][j-1], d[i][j]
		// 3. 초기값 설정



		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int w = sc.nextInt();
		int[] arr = new int[t+1];
		
		for(int i=1; i<=t; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[][] d = new int[t+1][w+1];
		if(arr[1] == 1) {
			d[1][0] = 1;
		}else {
			d[1][1] = 1;
		}

		for(int i=2; i<=t; i++) {
			for(int j=0; j<=w; j++) {
				if(j ==0) {
					if(arr[i]==1) {
						d[i][0] = d[i-1][0] +1;
					}else if(arr[i] == 2){
						d[i][0] = d[i-1][0];
					}
				}else {
					// 1번
					if(j%2 == 0) {
						if(arr[i] ==1) {
							d[i][j] = Math.max(d[i-1][j-1], d[i-1][j])+1;
						}else {
							d[i][j] = d[i-1][j];
						}
					}else {
						if(arr[i] ==2) {
							d[i][j] = Math.max(d[i-1][j-1], d[i-1][j])+1;
						}else {
							d[i][j] = d[i-1][j];
						}
					}
				}
			}
		}
		
		int sol = 0;
		for(int i=0; i<=w; i++) {
			sol = Math.max(sol,  d[t][i]);
		}
		System.out.println(sol);
	}
}
