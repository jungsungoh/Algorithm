package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_불 {
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static char[][] arr;
	public static int n, m;
	public static int[][] visited, visited2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		arr = new char[n][m];
		point fire = null, jih = null;
		visited = new int[n][m];
		visited2 = new int[n][m];
		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = l2.charAt(j);
				if(arr[i][j] == 'F') {
					fire = new point(i,j);
				}
				if(arr[i][j] == 'J') {
					jih = new point(i,j);
				}
			}
		}
		bfs(fire.x, fire.y);
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void bfs(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si,sj));
		visited[si][sj] = 0;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y +dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(visited[ni][nj]==0 && (arr[ni][nj] == '.' || arr[ni][nj] =='J')) {
						q.add(new point(ni,nj));
						visited[ni][nj] = visited[p.x][p.y]+1;
					}
				}
			}
		}
	}
	public static void bfs2(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si,sj));
		visited2[si][sj] = 0;
		
		while(!q.isEmpty()) {
			
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
