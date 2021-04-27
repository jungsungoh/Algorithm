package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_상어초 {
	public static int n;
	public static student[] std;
	public static int[][] arr;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		std = new student[n*n+1];
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=1; i<=n*n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			std[idx]  = new student(idx, new HashMap<>());
			for(int k=0; k<4; k++) {
				std[idx].m.put(Integer.parseInt(st.nextToken()), true);
			}
			al.add(idx);
		}
		
		arr =new int[n][n];
		for(int i=0; i<al.size(); i++) {
			check(std[al.get(i)]);
		}
		int sum = 0;
		for(int i= 0; i<al.size(); i++) {
			int val = bfs(std[al.get(i)]);
			sum+= val;
		}
		System.out.println(sum);
	}
	public static int bfs(student std1) {
		int cnt = 0;
		int x = std1.i, y = std1.j;
		for(int i=0; i<4; i++) {
			int ni = x+di[i];
			int nj = y + dj[i];
			if(ni>=0 && ni<n && nj>=0 && nj<n) {
				if(std1.m.containsKey(arr[ni][nj])) {
					cnt++;
				}
			}
		}
		if(cnt ==0) {
			return 0;
		}else if(cnt==1) {
			return 1;
		}else if(cnt ==2) {
			return 10;
		}else if(cnt==3) {
			return 100;
		}else if(cnt ==4) {
			return 1000;
		}else {
			return -1;
		}
		
	}
	public static void check(student std1) {
		
		PriorityQueue<point> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 0) {
					int cnt = 0, blank_cnt = 0;
					for(int k=0; k<4; k++) {
						int ni = i+di[k];
						int nj = j+dj[k];
						if(ni>=0 && ni<n && nj>=0 && nj<n ) {
							if(std1.m.containsKey(arr[ni][nj])) {
								cnt++;
							}else if(arr[ni][nj] == 0){
								blank_cnt++;
							}
						}
					}
					pq.add(new point(i,j,cnt,blank_cnt));
				}
			}
		}
		point p = pq.poll();
		arr[p.x][p.y]= std1.x; 
		std[std1.x].i = p.x;
		std[std1.x].j = p.y;
	}
	public static class point implements Comparable<point>{
		int x, y, cnt, blank_cnt;
		
		public point(int x, int y, int cnt, int blank_cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.blank_cnt = blank_cnt;
		}

		@Override
		public int compareTo(point o) {
			if(o.cnt == this.cnt) {
				if(o.blank_cnt == this.blank_cnt) {
					if(this.x == o.x) {
						return Integer.compare(this.y, o.y);
					}
					return Integer.compare(this.x, o.x);
				}
				return Integer.compare(o.blank_cnt, this.blank_cnt);
			}
			return Integer.compare(o.cnt, this.cnt);
		}
		
	}
	public static class student{
		int x, i, j;
		Map<Integer, Boolean> m;
		public student(int x, Map<Integer, Boolean> m) {
			super();
			this.x = x;
			this.m = m;
		}

	}
}
