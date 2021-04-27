package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_상어중 {
	public static int n, m;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
	public static void bfs(int si, int sj, int type) {
		boolean[][] visited = new boolean[n][n];
		Queue<point>  q = new LinkedList<>();
		q.add(new point(si,sj,type));
		visited[si][sj] = true;
		connect c = new connect(si,sj,0,0);
		while(!q.isEmpty()) {
			point p = q.poll();
			
			
			
			
		}
	}
	public static class point{
		int x, y, type;

		public point(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	public static class connect implements Comparable<connect>{
		int x, y, all_cnt, rainbow_cnt;

		public connect(int x, int y, int all_cnt, int rainbow_cnt) {
			super();
			this.x = x;
			this.y = y;
			this.all_cnt = all_cnt;
			this.rainbow_cnt = rainbow_cnt;
		}

		@Override
		public int compareTo(connect o) {
			// TODO Auto-generated method stub
			if(this.all_cnt == o.all_cnt) {
				if(this.rainbow_cnt == o.rainbow_cnt) {
					if(this.x == o.x) {
					}
					return Integer.compare(o.x, this.x);
				}
				return Integer.compare(o.rainbow_cnt, this.rainbow_cnt);
			}
			
			return Integer.compare(o.all_cnt,this.all_cnt);
		}
		
		
	}
	public static void rotate(int[][] tmp) {
		int[][] temp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				temp[i][j] = tmp[j][n-1-i];
			}
		}
	}
}
