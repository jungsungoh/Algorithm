package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_그림 {
	public static int[][] arr;
	public static int n,m;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		
		arr = new int[n][m];
		ArrayList<point> al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					al.add(new point(i,j));
				}
			}
		}
		visited = new boolean[n][m];
		int max = 0;
		int num = 0;
		for(int i=0; i<al.size(); i++) {
			point p = al.get(i);
			if(!visited[p.x][p.y]) {
				num++;
				max = Math.max(bfs(p.x,p.y), max);
			}
		}
		System.out.println(num);
		System.out.println(max);
	}
	public static int bfs(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si,sj));
		visited[si][sj] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y +dj[k];
				
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj] && arr[ni][nj] == 1){
						q.add(new point(ni,nj));
						cnt++;
						visited[ni][nj] = true;
					}
				}
			}
		}
		return cnt;
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
