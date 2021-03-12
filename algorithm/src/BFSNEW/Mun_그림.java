package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_그림 {
	public static int n,m, max = 0;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int[][] arr;
	public static boolean[][] visited;
	public static ArrayList<point> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		al = new ArrayList<>();
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					al.add(new point(i,j));
				}
			}
		}
		int cnt = 0;
		for(int i=0; i< al.size(); i++) {
			point p = al.get(i);
			if(!visited[p.x][p.y]) {
				cnt++;
				bfs(p.x, p.y);
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
	public static void bfs(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		visited[si][sj] = true;
		int size = 1;
		while(!q.isEmpty()) {
			point p =q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = p.x+ di[k];
				int nj= p.y + dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj] && arr[ni][nj] == 1) {
						q.add(new point(ni, nj));
						visited[ni][nj] = true;
						size++;
					}
				}
			}
		}
		if(max< size) {
			max = size;
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
