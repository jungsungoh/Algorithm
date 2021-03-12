package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_벽부수고이동하기 {
	public static boolean[][][] visited;
	public static int[][] arr;
	public static int n, m, result;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		arr = new int[n][m];
		visited = new boolean[n][m][2];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		bfs();
		if(result == 0) System.out.println(-1);
		else {
			System.out.println(result);
		}
		
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0,1,0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.x == n-1 && p.y == m-1) {
				result = p.dist;
				return;
			}
			
			for(int k=0; k<4; k++) {
				int ni = p.x + di[k];
				int nj = p.y + dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj][p.br]) {
						if(arr[ni][nj] == 0) {
							q.add(new point(ni,nj,p.dist+1, p.br));
							visited[ni][nj][p.br]= true; 
						}else if(p.br ==0 && arr[ni][nj] == 1) {
							q.add(new point(ni,nj,p.dist+1, p.br+1));
							visited[ni][nj][p.br+1] = true;
						}
					}
				}
			}
		}
	}
	public static class point {
		int x, y, dist, br;

		public point(int x, int y, int dist, int br) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.br = br;
		}
		
	}
}
