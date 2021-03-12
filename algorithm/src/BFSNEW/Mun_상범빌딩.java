package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_상범빌딩 {
	public static int n, m, h, result= -1;
	public static char[][][] arr;
	public static point start, end;
	public static boolean[][][] visited;
	public static int[] di = {-1,1,0,0,0,0};
	public static int[] dj = {0,0,-1,1,0,0};
	public static int[] dh = {0,0,0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String l1 = br.readLine();
			result = -1;
			h = Integer.parseInt(l1.split(" ")[0]);
			n = Integer.parseInt(l1.split(" ")[1]);
			m = Integer.parseInt(l1.split(" ")[2]);
			if(h ==0 && n ==0 && m == 0) {
				return;
			}
			arr = new char[h][n][m];
			visited = new boolean[h][n][m];
			for(int k=0; k<h; k++) {
				for(int i=0; i<n;i ++) {
					String l2 = br.readLine();
					for(int j=0; j<m; j++) {
						arr[k][i][j] = l2.charAt(j);
						if(arr[k][i][j] == 'S') {
							start = new point(i,j,k,0);
						}else if(arr[k][i][j] =='E') {
							end = new point(i,j,k,0);
						}
					}
				}
				br.readLine();
			}
			bfs();
			if(result == -1) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in "+ result+" minute(s).");
			}
		}

	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(start);
		visited[start.h][start.x][start.y] = true;

		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.x == end.x && p.y == end.y && p.h == end.h) {
				result = p.time;
				return;
			}

			for(int k=0; k<6; k++) {
				int ni = p.x +di[k];
				int nj = p.y +dj[k];
				int nh = p.h +dh[k];

				if(ni>=0 && ni<n && nj>=0 && nj<m && nh>=0 && nh<h) {
					if(!visited[nh][ni][nj] && arr[nh][ni][nj] !='#') {
						q.add(new point(ni,nj,nh,p.time+1));
						visited[nh][ni][nj] = true;
					}
				}
			}
		}
	}
	public static void print() {
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					System.out.print(visited[k][i][j] + " ");
				}System.out.println();
			}
			System.out.println();
		}
	}
	public static class point{
		int x, y, h, time;

		public point(int x, int y, int h, int time) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
			this.time = time;
		}

	}
}
