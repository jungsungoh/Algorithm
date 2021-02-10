package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_백조의호수 {
	static boolean[][] visited;
	static int n, m;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		
		arr = new char[n][m];
		
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = l2.charAt(j);
			}
		}
		
		
		
		
	}
	public static void bfs(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		visited[si][sj] = true;
		
	}
	public static class point{
		int x , y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
