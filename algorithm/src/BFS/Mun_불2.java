package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_불2 {
	public static ArrayList<point> fire;
	public static char[][] arr;
	public static int n, m, result = 0;
	public static int[][] visited, visited2;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			String l1 = br.readLine();
			n = Integer.parseInt(l1.split(" ")[1]);
			m = Integer.parseInt(l1.split(" ")[0]);

			arr = new char[n][m];
			point dog = null;
			fire = new ArrayList<>();
			for(int i=0; i<n; i++) {
				String l2 = br.readLine();
				for(int j=0; j<m; j++) {
					arr[i][j] = l2.charAt(j);
					if(arr[i][j] == '@') {
						dog = new point(i ,j );
					}else if(arr[i][j] == '*') {
						fire.add(new point(i,j));
					}
				}
			}
			visited = new int[n][m];
			visited2 = new int[n][m];
			result = 0;
			bfs();
			bfs2(dog.x, dog.y);
			if(result == 0) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(result-1);
			}
		}
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		for(int i=0; i<fire.size(); i++) {
			point f = fire.get(i);
			q.add(new point(f.x, f.y));
			visited[f.x][f.y]= 1; 
		}
		int dist = 2;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s= 0; s<size; s++) {
				point p = q.poll();
				for(int k=0; k<4; k++) {
					int ni = p.x +di[k];
					int nj = p.y + dj[k];

					if(ni >=0 && ni<n && nj>=0 && nj<m) {
						if(visited[ni][nj] == 0 && arr[ni][nj] != '#') {
							q.add(new point(ni,nj));
							visited[ni][nj] = dist;
						}
					}
				}
			}dist++;
		}
	}
	public static void bfs2(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		visited2[si][sj]= 1; 
		int dist = 2;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s= 0; s<size; s++) {
				point p = q.poll();
				for(int k=0; k<4; k++) {
					int ni = p.x +di[k];
					int nj = p.y + dj[k];

					if(ni >=0 && ni<n && nj>=0 && nj<m) {
						if(visited2[ni][nj] == 0 && (visited[ni][nj] == 0|| visited[ni][nj] > dist)&& arr[ni][nj] == '.') {
							q.add(new point(ni,nj));
							visited2[ni][nj] = dist;
						}
					}else {
						result = dist;
						return;
					}
				}
			}dist++;
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
