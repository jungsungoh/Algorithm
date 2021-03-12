package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_미로만들기 {
	public static int n;
	public static int[][] arr;
	public static int[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new int[n][n];
		for(int i=0; i<n; i++) {
			String l1 = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = l1.charAt(j)-'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(visited[n-1][n-1]);
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = p.x +di[k];
				int nj = p.y +dj[k];
				if(ni>=0 && ni< n && nj>=0 && nj<n) {
					if(visited[ni][nj]> visited[p.x][p.y]&& arr[ni][nj] == 1) {
						q.add(new point(ni,nj));
						visited[ni][nj] = visited[p.x][p.y];
					}else if( visited[ni][nj]> visited[p.x][p.y]+1 && arr[ni][nj] == 0) {
						q.add(new point(ni,nj));
						visited[ni][nj] = visited[p.x][p.y]+1;
					}
				}
			}
		}
	}
	public static class point{
		int x,  y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
