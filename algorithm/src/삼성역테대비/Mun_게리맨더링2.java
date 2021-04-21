package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_게리맨더링2 {
	public static int n,sol = Integer.MAX_VALUE, total;
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr  = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				total += arr[i][j];
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				for(int d1 =1; d1 <=n ; d1++) {
					for(int d2 = 1; d2<=n; d2++) {
						if(i+d1+d2 <=n && j-d1 >=1 && j-d1 <j && j+d2 > j && j+d2<=n) {
							makeEdge(i,j,d1, d2);
						}
					}
				}
			}
		}
		System.out.println(sol);
	}


	// 경계선 구하기
	public static void makeEdge(int x, int y, int d1, int d2) {
		int[][] temp= new int[n+1][n+1];

		// 2. 경계선 만들기
		for(int i=0; i<=d1; i++) {
			int ni = x+i, nj = y-i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				temp[ni][nj] = 5;
			}
		}
		for(int i=0; i<=d2; i++) {
			int ni = x+i, nj = y+i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				temp[ni][nj] = 5;
			}
		}
		for(int i=0; i<=d2; i++) {
			int ni = x+d1+i, nj = y-d1+i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				temp[ni][nj] = 5;
			}
		}
		for(int i=0; i<=d1; i++) {
			int ni = x+d2+i, nj = y+d2-i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				temp[ni][nj] = 5;
			}
		}

		for(int i=x+1 ; i <x+d1+d2; i++) {
			boolean start = false;
			for(int j=1; j <=n; j++ ) {
				if(i>=1 && i<=n && j>=1 && j<=n) {
					if(start) {
						if(temp[i][j] == 5) {
							break;
						}
						temp[i][j] = 5;
					}
					if(!start && temp[i][j] == 5) {
						start = true;
					}
				}
			}
		}
		int[] sum = new int[5];
		for(int i=1; i<x+d1;i++) {
			for(int j=1; j<=y; j++) {
				if(i>=1 && i<=n && j>=1 && j<=n && temp[i][j] != 5) {
					temp[i][j] = 1;
					sum[0]+=arr[i][j];
				}
			}
		}
		for(int i=1; i<=x+d2; i++) {
			for(int j=n; j>y; j--) {
				if(i>=1 && i<=n &&j>=1 && j<=n && temp[i][j] != 5) {
					temp[i][j] = 2;
					sum[1]+=arr[i][j];
				}
			}
		}
		for(int i=x+d1; i<=n; i++) {
			for(int j=1; j<y-d1+d2; j++) {
				if(i>=1 && i<=n && j>=1 &&j<=n && temp[i][j] != 5) {
					temp[i][j] = 3;
					sum[2]+=arr[i][j];
				}
			}
		}
		for(int i=n; i>x+d2; i--) {
			for(int j=y-d1+d2; j<=n; j++) {
				if(i>=1 && i<=n && j>=1 && j<=n && temp[i][j] != 5) {
					temp[i][j] = 4;
					sum[3]+=arr[i][j];
				}
			}
		}
		sum[4] = total;

		for(int i=0; i<4; i++) {
			sum[4] -= sum[i];
		}
		Arrays.sort(sum);

		sol = Math.min(sol, sum[4]-sum[0]);
	}
}


// N×N인 격자로 나타낼 수 있다
// 격자의 각 칸은 구역을 의미하고, r행 c열에 있는 구역은 (r, c)로 나타낼 수 있다.

// 역을 다섯 개의 선거구로 나눠야 하고, 각 구역은 다섯 선거구 중 하나에 포함되어야 한다. 



// 1. 경계선 구하기 (경계선 and 안쪽은 전부 5번선거구)
// 2. 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
// 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
// 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
// 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N