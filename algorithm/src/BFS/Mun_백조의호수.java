package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_백조의호수 {
	static boolean[][] visited,dvisited;
	static int n, m;
	static char[][] arr;
	static Queue<point> q;
	static point duck;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);

		arr = new char[n][m];



		q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = l2.charAt(j);
				if(arr[i][j] =='L') {
					duck = new point(i,j);
				}
				if(arr[i][j] =='X') {
					q.add(new point(i,j));
				}
			}
		}
		int time = 0;
		while(true) {
			time++;
			melt();
			//print();
			dvisited = new boolean[n][m];
			boolean flag = isposs(duck);
			if(flag) {
				break;
			}

		}
		System.out.println(time);
	}
	public static void melt() {
		int size = q.size();
		Queue<point> q2 = new LinkedList<>();
		for(int i=0; i<size; i++){
			point p = q.poll();
			int flag = 0;
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(arr[ni][nj] == '.') {
						q2.add(new point(p.x, p.y));
						flag = 1;
						break;
					}
				}
			}
			if(flag == 0) {
				q.add(new point(p.x,p.y));
			}
		}
		while(!q2.isEmpty()) {
			point p = q2.poll();
			arr[p.x][p.y]= '.'; 
		}
	}
	public static boolean isposs(point d) {
		Queue<point> duck = new LinkedList<>();
		duck.add(new point(d.x, d.y));
		dvisited[d.x][d.x]= true; 

		while(!duck.isEmpty()) {
			point p =duck.poll();
			if(!(p.x == d.x && p.y == d.y) && arr[p.x][p.y]== 'L' ) {
				return true;
			}

			for(int k=0; k<4; k++) {
				int ni = p.x + di[k];
				int nj = p.y + dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!dvisited[ni][nj] && (arr[ni][nj] =='.' || arr[ni][nj] == 'L')) {
						dvisited[ni][nj] = true;
						duck.add(new point(ni, nj));
					}
				}
			}
		}
		return false;
	}

	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
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
