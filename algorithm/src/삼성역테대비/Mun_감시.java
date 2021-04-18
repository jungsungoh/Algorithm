package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_감시 {
	public static int[] di = {0,1,0,-1};
	public static int[] dj = {-1,0,1,0};
	public static int n, m, result = Integer.MAX_VALUE;
	public static int[][] arr;
	public static ArrayList<CCTV> cctv;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		arr = new int[n][m];
		cctv = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] >=1 && arr[i][j] <=5) {
					cctv.add(new CCTV(i,j,arr[i][j]));
				}
			}
		}
		dfs(arr, 0);
		System.out.println(result);
	}

	public static void cctv(int[][] temp, int si, int sj, int dir) {
		int ni = si, nj = sj;
		temp[ni][nj] = 9;
		while(true) {
			ni += di[dir];
			nj += dj[dir];
			if(!(ni>=0 &&ni<n && nj>=0 && nj<m) || arr[ni][nj] == 6) return;
			temp[ni][nj] = 9;
		}
	}
	public static void dfs(int[][] map, int idx) {
		if(idx == cctv.size()) {
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 0) {
						cnt++;
					}
				}
			}
			result = Math.min(result, cnt);
			return;
		}
		CCTV tv = cctv.get(idx);
		switch(tv.type) {
		case 1:
			for(int k=0; k<4; k++) {
				int[][] vmap = new int[n][m];
				for(int i=0; i<n; i++) {
					vmap[i] = Arrays.copyOf(map[i], m);
				}
				cctv(vmap,tv.x, tv.y, k);
				dfs(vmap,idx+1);
			}
			break;
		case 2:
			for(int k=0; k<2; k++) {
				int[][] vmap = new int[n][m];
				for(int i=0; i<n; i++) {
					vmap[i] = Arrays.copyOf(map[i], m);
				}
				cctv(vmap,tv.x,tv.y,k);
				cctv(vmap,tv.x,tv.y,k+2);
				dfs(vmap,idx+1);
			}
			break;
		case 3:
			for(int k=0; k<4; k++) {
				int[][] vmap = new int[n][m];
				for(int i=0; i<n; i++) {
					vmap[i] = Arrays.copyOf(map[i], m);
				}
				cctv(vmap,tv.x,tv.y,k);
				cctv(vmap,tv.x,tv.y,(k+1)%4);
				dfs(vmap, idx+1);
			}
		case 4:
			for(int k=0; k<4; k++) {
				int[][] vmap = new int[n][m];
				for(int i=0; i<n; i++) {
					vmap[i] = Arrays.copyOf(map[i], m);
				}
				cctv(vmap,tv.x,tv.y, k);
				cctv(vmap,tv.x,tv.y, (k+1)%4);
				cctv(vmap,tv.x,tv.y, (k+2)%4);
				dfs(vmap,idx+1);
			}
			break;
		case 5:
			int[][] vmap = new int[n][m];
			for(int i=0; i<n; i++) {
				vmap[i] = Arrays.copyOf(map[i], m);
			}
			cctv(vmap, tv.x,tv.y, 0);
			cctv(vmap, tv.x,tv.y, 1);
			cctv(vmap, tv.x,tv.y, 2);
			cctv(vmap, tv.x,tv.y, 3);
			dfs(vmap,idx+1);
			break;
		}

	}
	public static class CCTV{
		int x, y, type;

		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
}

// N×M 크기의 직사각형으로 나타낼 수 있다.
// 사무실에는 총 K개의 CCTV가 설치되어져 있는데, CCTV는 5가지 종류가 있다. 
// 각 CCTV가 감시할 수 있는 방법은 다음과 같다.

// 사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다.
// CCTV가 감시할 수 없는 영역은 사각지대라고 한다.


// CTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.


// 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호이다. 
// CCTV는 CCTV를 통과할 수 있다. 

// CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기를 구하는 프로그램을 작성하시오.
