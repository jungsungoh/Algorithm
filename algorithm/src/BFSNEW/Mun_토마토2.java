package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Mun_토마토2 {
	public static int n,m, h;
	public static int[][][] arr;
	public static ArrayList<point> al;
	public static boolean[][][] visited;
	public static int[] di = {-1,1,0,0,0,0};
	public static int[] dj = {0,0,-1,1,0,0};
	public static int[] dh = {0,0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		
		n = Integer.parseInt(l1.split(" ")[1]);
		m = Integer.parseInt(l1.split(" ")[0]);
		h = Integer.parseInt(l1.split(" ")[2]);
		arr = new int[h][n][m];
		visited = new boolean[h][n][m];
		al = new ArrayList<>();
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if(arr[k][i][j] == 1) {
						al.add(new point(i, j, k));
					}
				}
			}
		}
		int day = bfs();
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[k][i][j] == 0) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		System.out.println(day-1);
	}
	public static int bfs() {
		Queue<point> q = new LinkedList<>();
		for(int i=0; i<al.size(); i++) {
			point p = al.get(i);
			q.add(new point(p.x, p.y , p.h));
			visited[p.h][p.x][p.y] = true;
		}
		int dist = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				point p = q.poll();
				
				for(int k=0; k<6; k++) {
					int ni = p.x + di[k];
					int nj = p.y+ dj[k];
					int nh = p.h + dh[k];
					if(ni>=0 && ni<n && nj>=0 && nj<m && nh>=0 && nh<h) {
						if(!visited[nh][ni][nj] && arr[nh][ni][nj] == 0) {
							q.add(new point(ni,nj,nh));
							arr[nh][ni][nj] = 1;
							visited[nh][ni][nj] = true;
						}
					}
				}
				
			}dist++;
		}
		return dist;
	}
	public static class point{
		int x, y, h;

		public point(int x, int y, int h) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
}
