package BFSNEW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun_나이트의이동 {
	public static point start, end;
	public static boolean[][] visited;
	public static int n, result;
	public static int[] di = {-2,-1,1,2, 2, 1 , -1, -2};
	public static int[] dj = {1 , 2,2,1, -1, -2, -2,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++) {
			n = sc.nextInt();

			visited = new boolean[n][n];
			start = new point(sc.nextInt(), sc.nextInt(), 0);
			end = new point(sc.nextInt(), sc.nextInt(), 0);
			result = 0;
			bfs();
			System.out.println(result);
		}
	}
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(start.x, start.y, 0));
		visited[start.x][start.y] = true;

		while(!q.isEmpty()) {
			point p = q.poll();

			if(p.x == end.x && p.y == end.y) {
				result = p.time;
				return;
			}

			for(int k=0; k<8; k++) {
				int ni = p.x + di[k];
				int nj = p.y + dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<n) {
					if(!visited[ni][nj] ) {
						q.add(new point(ni,nj, p.time+1));
						visited[ni][nj] = true;
					}
				}
			}
		}
	}
	public static class point{
		int x, y, time;

		public point(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}
}
