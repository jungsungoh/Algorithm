package 삼성역테대비;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_컨베이어벨트위의로봇 {
	public static int n, k;
	public static int[][] belt, power;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt(); // 내구도 0 개수
		belt = new int[2][n+1];
		power = new int[2][n+1];
		
		for(int i=1; i<=n; i++) {
			power[0][i] = sc.nextInt();
		}
		for(int j=n; j>=1; j--) {
			power[1][j] = sc.nextInt();
		}
		int time = 1;
		while(true) {
			// 벨트 회전
			// 1
			print(power);
			System.out.println("---------------------------------");
			print(belt);
			System.out.println("===================");
			rotate(power);
			//2 
			robotmove(belt);
			//3 
			if(belt[0][1] != 1) {
				belt[0][1] = 1;
			}
			//4 
			int cnt = 0;
			for(int j=0; j<2; j++) {
				for(int i=1; i<=n; i++) {
					if(power[j][i] == 0) {
						cnt++;
					}
				}
			}
			if(cnt>=k) {
				break;
			}
			time++;
		}
		System.out.println(time);
	}
	public static void rotate(int[][] changearr) {
		
		int downidx = changearr[0][n];
		for(int i=n; i>0; i--) {
			changearr[0][i] = changearr[0][i-1];
		}
		int upidx = changearr[1][1];
		for(int i=1; i<n; i++) {
			changearr[1][i] = changearr[1][i+1];
		}
		changearr[1][n] = downidx;
		changearr[0][1] = upidx;
	}
	public static void robotmove(int[][] arr) {
		
		if(arr[1][1] == 1) {
			arr[1][1] = 0;
		}
		for(int i= 1; i<n; i++) {
			if(arr[1][i+1] == 1 && arr[1][i] == 0 && power[1][i+1] != 0) {
				arr[1][i] = arr[1][i+1];
			}
		}
		if(arr[1][n] ==0 && power[1][n] != 0) {
			arr[1][n] = arr[0][n];
			arr[0][n] = 0;
			power[1][n] -=1;
		}
		for(int i=n; i>=1 ; i--) {
			if(arr[0][i] ==0 && power[0][i] != 0 ) {
				arr[0][i] = arr[0][i-1];
				arr[0][i-1] = 0;
				power[0][i]-=1;
			}
		}
	}
	public static void print(int[][] arr) {
		for(int i=0; i<2 ;i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
}
