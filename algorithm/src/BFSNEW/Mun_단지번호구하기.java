package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_단지번호구하기 {
	public static boolean[][] visited;
	public static int n;
	public static int[][] arr;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n  = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		visited = new boolean[n][n];
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					al.add(bfs(i,j));
				}
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
	public static int bfs(int si, int sj) {
		int cnt = 1;
		Queue<point> q = new LinkedList<>();
		q.add(new point(si,sj));
		visited[si][sj] = true;
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = p.x + di[k];
				int nj = p.y +dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<n) {
					if(!visited[ni][nj] && arr[ni][nj] == 1) {
						q.add(new point(ni, nj));
						visited[ni][nj] = true;
						cnt++;
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
