package Dp초심;

import java.util.Scanner;

public class Mun_우유도시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[][] arr =new int[1001][1001];
		
		point[][] d = new point[1001][1001];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		// d[i][j][맨마지막먹은우유];
		d[0][0]= new point(0,0,0);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 이전에 아무것도 안먹
				if(i-1 >=0) {		
					
				}
				if(j-1 >= 0 ) {
					
				}
			}
		}
		
		
		
		// 테이블 설정
		
		// 점화식구하기
		
		// 초기값 설정
	}
	public static class point{
		int x, y, last;

		public point(int x, int y, int last) {
			super();
			this.x = x;
			this.y = y;
			this.last = last;
		}
		
	}
}
