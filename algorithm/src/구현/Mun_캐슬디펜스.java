package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_캐슬디펜스 {
	public static int n,m,d, sol;
	public static int[][] arr,temp;
	public static boolean[] used;
	public static boolean[][] visited;
	public static int[] result;
	public static int[] di = {-1,0,0};
	public static int[] dj = {0,-1,1};
	public static ArrayList<point> al, enemy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		d = Integer.parseInt(l1.split(" ")[2]);

		arr = new int[n+1][m];
		result = new int[3];
		al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					al.add(new point(i,j));
				}
			}
		}
		for(int i=0; i<m; i++) {
			arr[n][i] = 2;
		}
		combi(0,0);
		System.out.println(sol);
	}
	public static int moving() {
		Queue<point> q = new LinkedList<>();
		int cnt = 0;
		while(enemy.size()>0) {
			for(int i=0; i<3; i++) {
				point target = null;
				int min = Integer.MAX_VALUE;
				for(int j=0; j<enemy.size(); j++) {
					point p = enemy.get(j);
					int dist = Math.abs(p.x-n) + Math.abs(p.y-result[i]);
					if(min>dist) {
						min = dist;
						target = p;
					}
				}
				if(min <=d) {
					q.add(target);
				}
			}
			while(!q.isEmpty()) {
				point p = q.poll();
				int size = enemy.size(); 
				for(int s =0; s<size; s++) {
					point e = enemy.get(s);
					if(e.x == p.x && e.y == p.y) {
						enemy.remove(s);
						cnt++;
						break;
					}
				}
			}
			int size = enemy.size();
			ArrayList<point> temp2 = new ArrayList<>();
			for(int i=0; i<size; i++) {
				point p =enemy.get(i);
				temp[p.x][p.y]= 0;
				if(p.x +1 <n) {
					temp[p.x+1][p.y]= 1; 
					temp2.add(new point(p.x+1, p.y));
				}
			}
			enemy = temp2;
		}
		return cnt;
	}

	public static void combi(int idx, int target) {
		if(result.length == idx) {
			temp = new int[n+1][m];
			enemy = new ArrayList<>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					temp[i][j] = arr[i][j];
					if(temp[i][j] == 1) {
						enemy.add(new point(i, j));
					}
				}
			}

			int val =  moving();
			sol = Math.max(sol,  val);
			return;
		}
		if(target == arr[n].length) {
			return;
		}
		result[idx] = arr[n][target];
		combi(idx+1, target+1);
		combi(idx, target+1);

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
