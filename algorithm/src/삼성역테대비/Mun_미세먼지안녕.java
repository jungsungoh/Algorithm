package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mun_미세먼지안녕 {
	public static int n,m,t;
	public static int[][] arr;
	public static point[] cleaner;
	public static ArrayList<point> dust;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		t = Integer.parseInt(l1.split(" ")[2]);
		
		arr = new int[n][m];
		
		cleaner = new point[2];
		dust = new ArrayList<>();
		int idx = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) {
					cleaner[idx++] = new point(i,j,0);
				}else if(arr[i][j] != 0 && arr[i][j] != -1) {
					dust.add(new point(i,j,arr[i][j]));
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<t; i++) {
			spread();
			clean();
			dust = new ArrayList<>();
			cnt = 0;
			for(int k=0;k<n; k++) {
				for(int j=0; j<m; j++) {
					if(arr[k][j] != 0 && arr[k][j] != -1) {
						dust.add(new point(k,j, arr[k][j]));
						cnt += arr[k][j];
					}
				}
			}
		}
		System.out.println(cnt);
		
	}
	public static void spread() {
		for(int i=0; i<dust.size(); i++) {
			point p = dust.get(i);
			int cnt = 0;
			int spreadm = p.sum/5;
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m && arr[ni][nj] != -1) {
					arr[ni][nj] += spreadm;
					cnt++;
				}
			}
			arr[p.x][p.y]-= spreadm*cnt; 
		}
	}
	public static void clean() {
		// 위쪽
		int sx = cleaner[0].x;
		for(int i = sx-1; i>0; i--) {
			arr[i][0] = arr[i-1][0];
		}
		for(int i=0; i<m-1; i++) {
			arr[0][i] = arr[0][i+1];
		}
		for(int i=0; i<sx; i++) {
			arr[i][m-1] = arr[i+1][m-1];
		}
		for(int i=m-1; i>0; i--) {
			arr[sx][i] = arr[sx][i-1];
		}
		arr[sx][1] = 0;
		
		// 아래쪽
		sx = cleaner[1].x;
		for(int i = sx+1; i<n-1; i++) {
			arr[i][0] = arr[i+1][0];
		}
		for(int i = 0; i<m-1; i++) {
			arr[n-1][i] = arr[n-1][i+1];
		}
		for(int i=n-1; i>sx; i--) {
			arr[i][m-1] = arr[i-1][m-1];
		}
		for(int i=m-1; i>0; i--) {
			arr[sx][i] = arr[sx][i-1];
		}
		arr[sx][1] = 0;
	}
	public static class point{
		int x, y, sum;

		public point(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}
}


// 공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다.
// 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.


// 1초 동안 아래 적힌 일이 순서대로 일어난다.

// 1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
// - (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
// - 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
// - 확산되는 양은 Ar,c/5이고 소수점은 버린다.
// - (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
/*
 * 어레이리스트에 먼지 담기
 *  좌우 상하 나눌 수 있는 칸 개수 구하기
 *  나누기
 * 
 */



// 2.공기청정기가 작동한다.
// - 공기청정기에서는 바람이 나온다.
// - 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
// - 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
// - 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.