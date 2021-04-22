package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_원판돌리기 {
	public static int n, m,t;
	public static onefan[] fan;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		t = Integer.parseInt(l1.split(" ")[2]);
		fan = new onefan[n+1];

		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			fan[i] = new onefan(i, new int[m+1]);
			for(int j=1; j<=m; j++) {
				fan[i].num[j] = Integer.parseInt(st.nextToken());
			}
		}
		// 원판 만들기
		// 회전
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int k1 = Integer.parseInt(st.nextToken());

			for(int k=1; k<=n; k++) {
				if(k%x1 == 0) {
					rotate(fan[k], d1, k1);
				}
			}
			if(!check()) {
				avgminus();
			}
		}

		int sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				sum +=fan[i].num[j]; 
			}
		}
		System.out.println(sum);
	}


	public static void avgminus() {
		int sum = 0, cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(fan[i].num[j] > 0) {
					sum += fan[i].num[j];
					cnt++;
				}
			}
		}
		if(cnt >=1) {
			double avg = (double)sum/cnt;
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(fan[i].num[j] > 0) {
						if((double)fan[i].num[j] > avg) {
							fan[i].num[j]--;
						}else if((double)fan[i].num[j] < avg){
							fan[i].num[j]++;
						}
					}
				}
			}
		}
	}
	public static void rotate(onefan fan, int di, int ki) {
		if(di == 0) { // 시계방향
			int[] temp = fan.num;
			for(int k=0; k<ki; k++) {
				int val = temp[m];
				for(int i=m; i>1 ;i--) {
					temp[i] = temp[i-1];
				}
				temp[1] = val;
			}
		}else { // 반대계방향
			int[] temp = fan.num;
			for(int k=0; k<ki; k++) {
				int val = temp[1];
				for(int i=1; i<m; i++) {
					temp[i] = temp[i+1];
				}
				temp[m] = val; 
			}
		}
	}
	public static boolean check() {
		Queue<point> q = new LinkedList<>();
		int flag = 0;
		visited = new boolean[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!visited[i][j] && fan[i].num[j] > 0) {
					q.add(new point(i, j, fan[i].num[j]));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						point p = q.poll();
						for(int k=0; k<4; k++) {
							int ni = p.x + di[k];
							int nj = p.y + dj[k];
							if(ni>=1 && ni<=n && nj >=1 && nj<=m) {
								if(!visited[ni][nj] && fan[ni].num[nj] == p.value) {
									flag = 1;
									visited[ni][nj] = true;
									q.add(new point(ni, nj, fan[ni].num[nj]));
									fan[ni].num[nj] = 0; 
									fan[i].num[j] = 0;
								}
							}
						}
						if(p.y == 1) {
							if(p.value == fan[p.x].num[m]) {
								q.add(new point(p.x, m,fan[p.x].num[m]));
								fan[p.x].num[m] = 0;
								visited[p.x][m] = true;
								flag = 1;
							}
						} 
						if(p.y == m) {
							if(p.value == fan[p.x].num[1]) {
								q.add(new point(p.x, 1,fan[p.x].num[1]));
								fan[p.x].num[1] = 0;
								visited[p.x][1] = true;
								flag = 1;
							}
						}

					}
				}
			}
		}
		if(flag ==1) {
			return true;
		}else {
			return false;
		}
	}
	public static class point{
		int x, y, value;

		public point(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}
	public static class onefan{
		int idx;
		int[] num;
		public onefan(int idx, int[] num) {
			super();
			this.idx = idx;
			this.num = num;
		}
	}
}