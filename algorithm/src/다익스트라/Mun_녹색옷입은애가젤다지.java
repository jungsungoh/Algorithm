package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_녹색옷입은애가젤다지 {
	public static int[][] arr;
	public static int n;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 1;
		while(true) {			
			n = Integer.parseInt(br.readLine());
			if(n ==0) break;
			arr = new int[n][n];
			visited = new int[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			bfs();
			System.out.println("Problem "+idx+": " + visited[n-1][n-1]);
			idx++;
		}
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0));
		visited[0][0] = arr[0][0];

		while(!q.isEmpty()) {
			point p = q.poll();

			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				if(ni>=0 && ni< n && nj>=0 &&nj <n) {
					if(visited[ni][nj] > visited[p.x][p.y]+ arr[ni][nj] ) {
						visited[ni][nj] = visited[p.x][p.y]+ arr[ni][nj];
						q.add(new point(ni,nj));
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
