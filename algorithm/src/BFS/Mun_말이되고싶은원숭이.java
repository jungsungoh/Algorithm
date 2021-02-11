package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_말이되고싶은원숭이 {
	public static int k, n, m,result;
	public static int[][] arr;
	public static boolean[][][] visited;
	public static int[] di = {-1,1,0,0,-2,-1,1,2,2,1,-1,-2};
	public static int[] dj = {0,0,-1,1,1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String l1 = br.readLine();
		m = Integer.parseInt(l1.split(" ")[0]);
		n = Integer.parseInt(l1.split(" ")[1]);

		arr = new int[n][m];
		visited = new boolean[n][m][k+1];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = -1;
		bfs();
		System.out.println(result);


	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0,0));
		visited[0][0][0] = true;

		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s =0; s<size ; s++) {
				point p = q.poll();
				if(p.x == n-1 && p.y == m-1) {
					result = dist;
					return;
				}
				for(int t = 0; t<di.length ; t++) {
					if(t>=4 && p.cnt>=k) { 
						break;
					}
					int ni = p.x +di[t];
					int nj = p.y +dj[t];
					if(ni >=0 && ni<n && nj>=0 && nj < m) {
						int tmp = t>=4? p.cnt+1 : p.cnt;
						if(!visited[ni][nj][tmp] && arr[ni][nj] == 0) {
							q.add(new point(ni,nj,tmp));
							visited[ni][nj][tmp] = true;
						}
					}
				}
			}dist++;
		}
	}
	public static class point{
		int x, y, cnt;

		public point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}
}
