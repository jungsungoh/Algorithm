package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_게리맨더링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr  = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sol = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {

				for(int p =1; p <=n ; p++) {
					for(int p2 = 1; p2<=n; p2++) {
						if(i+p+p2 <=n && j-p >=1 && j-p <j && j+p2 > j && j+p2<=n) {
							int[][] temp = new int[n+1][n+1];
							makeEdge(temp,i,j,p, p2);
							
							
							int[] sum = new int[6];
							for(int t=1; t<=n; t++) {
								for(int s=1; s<=n; s++) {
									sum[temp[t][s]] += arr[t][s];
								}
							}
							int max = 0;
							int min = Integer.MAX_VALUE;
							for(int k=1; k<=5; k++) {
								max = Math.max(max,sum[k]);
								min = Math.min(min,  sum[k]);
							}
							int result = Math.abs(max-min);
							sol = Math.min(sol, result);
						}
					}
				}
			}
		}
		System.out.println(sol);



	}


	// 경계선 구하기
	public static void makeEdge(int[][] arr, int si, int sj, int d1, int d2) {
		int n = arr.length-1;

		for(int i=0; i<=d1; i++) {
			int ni = si+i, nj = sj-i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				arr[ni][nj] = 5;
			}
		}
		for(int i=0; i<=d2; i++) {
			int ni = si+i, nj = sj+i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				arr[ni][nj] = 5;
			}
		}
		for(int i=0; i<=d2; i++) {
			int ni = si+d1+i, nj = sj-d1+i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				arr[ni][nj] = 5;
			}
		}
		for(int i=0; i<=d1; i++) {
			int ni = si+d2+i, nj = sj+d2-i;
			if(ni >=1 && ni<=n && nj>=1 && nj<=n) {
				arr[ni][nj] = 5;
			}
		}
		for(int i=1; i<=n; i++) {
			int lidx = 0, ridx = n;
			while(true) {
				// 서로 교차하면 종료
				if(lidx >= ridx) break;
				else if(arr[i][lidx] == 5 && arr[i][ridx] == 5) {
					for(int j = lidx+1 ; j<ridx; j++) {
						arr[i][j] = 5;
					}
					break;
				}else if(arr[i][lidx] == 5 && arr[i][ridx] != 5) {
					ridx--;
				}else if(arr[i][lidx] != 5 && arr[i][ridx] == 5) {
					lidx++;
				}else {
					lidx++;
					ridx--;
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i>=1 && i<si+d1 && j>=1 && j<sj && arr[i][j] != 5) {
					arr[i][j] = 1;
				}else if(i>=1 && i<si+d2 && j>sj && j<=n  && arr[i][j] != 5) {
					arr[i][j] = 2;
				}else if(si+d1 <= i && i<=n && 1 <= j && j<sj-d1+d2  && arr[i][j] != 5) {
					arr[i][j] = 3;
				}else if(si+d2 <=i && i <=n && sj-d1+d2 <=j && j<=n  && arr[i][j] != 5) {
					arr[i][j] = 4;
				}
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		System.out.println("============");


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