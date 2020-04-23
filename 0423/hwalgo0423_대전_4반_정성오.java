package online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_인구이동 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int[][] arr, vi;
	static int n,l,h;
	static ArrayList<yunhap> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		l = Integer.parseInt(l1.split(" ")[1]);
		h = Integer.parseInt(l1.split(" ")[2]);
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		// 입력받기완료
		while(true) {
			vi = new int[n][n];
			al = new ArrayList<>();
			int p = 1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(vi[i][j] == 0) {
						yunhap y = new yunhap(p,1,arr[i][j],0);
						bfs(y,i,j,p);
						al.add(y);
						p++;
					}
				}
			}
			int flag = 0;
			for(int k=0; k<al.size(); k++) {
				if(al.get(k).cnt>1) {
					int val = al.get(k).sum / al.get(k).cnt;
					for(int i=0; i<n; i++) {
						for(int j=0; j<n; j++) {
							if(vi[i][j] == al.get(k).num) {
								arr[i][j] = val;
							}
						}
					}
					flag = 1;
				}
			}
			if(flag == 0) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	static void bfs(yunhap y,int si, int sj,int v) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		vi[si][sj] = v;
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<n) {
					int cha = Math.abs(arr[p.x][p.y]-arr[ni][nj]);
					if(vi[ni][nj] == 0) {
						if(cha>=l && cha <=h) {
							q.add(new point(ni,nj));
							y.cnt+=1;
							y.sum+=arr[ni][nj];
							vi[ni][nj] = v;
						}
					}
				}
			}
		}
	}
	static class point{
		int x, y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class yunhap{
		int num, cnt, sum ,val;

		public yunhap(int num, int cnt, int sum , int val) {
			super();
			this.num = num;
			this.cnt = cnt;
			this.sum = sum;
			this.val = val;
		}
	}
}
