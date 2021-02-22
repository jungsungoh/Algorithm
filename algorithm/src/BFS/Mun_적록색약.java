package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_적록색약 {
	public static int n;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int cnt1 = 0;
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(i,j,arr[i][j],0);
					cnt1++;
				}
			}
		}
		int cnt2 = 0;
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(i,j,arr[i][j],1);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " +cnt2);

	}
	public static void bfs(int si, int sj, char ch, int flag) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si,sj));
		visited[si][sj] = true;

		while(!q.isEmpty()) {
			point p = q.poll();
			for(int k=0; k<4; k++) {
				int ni = p.x +di[k];
				int nj = p.y + dj[k];
				if(ni >=0 && ni <n && nj>=0 && nj<n) {
					if(!visited[ni][nj] ) {
						if(flag == 0 && arr[ni][nj] == ch) {
							q.add(new point(ni,nj));
							visited[ni][nj] = true;
						}else if(flag == 1 && ((ch == 'R' || ch =='G') && (arr[ni][nj] == 'R' || arr[ni][nj] == 'G') || (ch == 'B' && arr[ni][nj] == 'B'))){
							q.add(new point(ni,nj));
							visited[ni][nj] = true;
						}
					}
				}
			}
		}
	}
	public static class point{
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
