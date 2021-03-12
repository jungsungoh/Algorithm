package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_유기농배추 {
	public static int[][] arr;
	public static int n, m;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC;tc++) {
			String l1 = br.readLine();
			n = Integer.parseInt(l1.split(" ")[1]);
			m =Integer.parseInt(l1.split(" ")[0]);
			int k = Integer.parseInt(l1.split(" ")[2]);
			arr= new int[n][m];
			visited = new boolean[n][m];

			for(int p =0;p<k; p++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				arr[j][i] = 1;
			}
			int cnt =0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void bfs(int si, int sj) {

		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		visited[si][sj] = true;

		while(!q.isEmpty()) {
			point p = q.poll();

			for(int k=0; k<4; k++) {
				int ni = p.x + di[k];
				int nj = p.y + dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj] && arr[ni][nj] == 1) {
						q.add(new point(ni,nj));
						visited[ni][nj] = true;
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
