package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_2048 {
	public static int[][] arr;
	public static int n,result;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(arr, 0);
		System.out.println(result);
	}
	 
	public static void dfs(int[][] temp, int cnt) {
		if(cnt == 5) {
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					max = Math.max(max, temp[i][j]);
				}
			}
			print(temp);
			result = Math.max(max,  result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int[][] tmp = new int[n][n];
			for(int j=0; j<n; j++) {
				tmp[j] = Arrays.copyOf(temp[j], n);
			}
			move(i, tmp);
			dfs(tmp,cnt+1);
		}
		
		
	}
	public static void print(int[][] printarr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(printarr[i][j] + " ");
			}System.out.println();
		}
		System.out.println("======================");
	}
	public static void move(int dir, int[][] tmp) { // 방향
		visited = new boolean[n][n];
		if(dir == 0) { // 위
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(tmp[i][j] != 0) {
						int ni = i, nj = j;
						while(true) {
							int si= ni, sj = nj;
							ni = ni + di[dir];
							nj = nj + dj[dir];
							if(ni>=0 && ni<n && nj>=0 && nj<n) {
								if(tmp[ni][nj] ==0) {
									tmp[ni][nj] = tmp[si][sj];
									tmp[si][sj] = 0;
								}else if(tmp[ni][nj] == tmp[si][sj]  && !visited[ni][nj]) {
									tmp[ni][nj]*=2;
									tmp[si][sj] = 0;
									visited[ni][nj] = true;
								}else {
									break;
								}
							}else {
								break;
							}
						}
					}
				}
			}
			
		}else if(dir == 1) { // 아래
			for(int i=n-1; i>=0 ; i--) {
				for(int j=0; j<n; j++) {
					if(tmp[i][j] != 0) {
						int ni = i, nj = j;
						while(true) {
							int si= ni, sj = nj;
							ni = ni + di[dir];
							nj = nj + dj[dir];
							if(ni>=0 && ni<n && nj>=0 && nj<n) {
								if(tmp[ni][nj] ==0) {
									tmp[ni][nj] = tmp[si][sj];
									tmp[si][sj] = 0;
								}else if(tmp[ni][nj] == tmp[si][sj]  && !visited[ni][nj]) {
									tmp[ni][nj]*=2;
									tmp[si][sj] = 0;
									visited[ni][nj] = true;
								}else {
									break;
								}
							}else {
								break;
							}
						}
					}
				}
			}
		}else if(dir == 2) { // 왼쪽
			for(int j=0; j<n; j++) {
				for(int i=0; i<n; i++) {
					if(tmp[i][j] != 0) {
						int ni = i, nj = j;
						while(true) {
							int si= ni, sj = nj;
							ni = ni + di[dir];
							nj = nj + dj[dir];
							if(ni>=0 && ni<n && nj>=0 && nj<n) {
								if(tmp[ni][nj] ==0) {
									tmp[ni][nj] = tmp[si][sj];
									tmp[si][sj] = 0;
								}else if(tmp[ni][nj] == tmp[si][sj]  && !visited[ni][nj]) {
									tmp[ni][nj]*=2;
									tmp[si][sj] = 0;
									visited[ni][nj] = true;
								}else {
									break;
								}
							}else {
								break;
							}
						}
					}
				}
			}
		}else if(dir == 3) {
			for(int j=n-1; j>=0 ; j--) {
				for(int i=0; i<n; i++) {
					if(tmp[i][j] != 0) {
						int ni = i, nj = j;
						while(true) {
							int si= ni, sj = nj;
							ni = ni + di[dir];
							nj = nj + dj[dir];
							if(ni>=0 && ni<n && nj>=0 && nj<n) {
								if(tmp[ni][nj] ==0) {
									tmp[ni][nj] = tmp[si][sj];
									tmp[si][sj] = 0;
								}else if(tmp[ni][nj] == tmp[si][sj]  && !visited[ni][nj]) {
									tmp[ni][nj]*=2;
									tmp[si][sj] = 0;
									visited[ni][nj] = true;
								}else {
									break;
								}
							}else {
								break;
							}
						}
					}
				}
			}
		}
		
	}
}
// nxn 크기의 보드
// 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동
// 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
// 한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다.
// 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다


// 최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.