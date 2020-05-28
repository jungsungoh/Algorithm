package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_탈주범검거 {
	static int[][] arr;
	static point hall;
	static int time, n, m, cnt;
	static boolean[][] visited;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// tc
		// 세로크기 n, 가로크기 m, 맨홀 세로위치 r, 가로위치 c, 탈출후 소요된 시간 l
		int TC= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String l1 = br.readLine();
			n = Integer.parseInt(l1.split(" ")[0]);
			m = Integer.parseInt(l1.split(" ")[1]);
			arr = new int[n][m];
			hall = new point(Integer.parseInt(l1.split(" ")[2]), Integer.parseInt(l1.split(" ")[3]));
			time = Integer.parseInt(l1.split(" ")[4]);
			for(int i=0; i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			visited = new boolean[n][m];
			cnt = 0;
			bfs();
			//System.out.println(cnt);
			System.out.println("#" + tc + " " +cnt);
		}
	}
	static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(hall.x, hall.y));
		visited[hall.x][hall.y]= true;
		cnt++;
		int dist = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s<size; s++) {
				point p = q.poll();
				if(dist == time) {
					return;
				}
				ArrayList<point> al = make_root(p.x, p.y);
				for(int k=0; k<al.size(); k++) {
					point np = al.get(k);
					if(np.x >=0 && np.x <n && np.y >=0 && np.y <m) {
						if(!visited[np.x][np.y] && arr[np.x][np.y]>0 ) {
							if(check(p.x, p.y, np.x, np.y)) {
								q.add(new point(np.x,np.y));
								visited[np.x][np.y]= true; 
								cnt++;
							}
						}
					}
				}
			}dist++;
//			System.out.println(dist);
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(visited[i][j]? "1" : "0");
//				}System.out.println();
//			}
//			System.out.println("==============");
		}
	}

	static ArrayList<point> make_root(int si, int sj){
		int w = arr[si][sj];
		ArrayList<point> al = new ArrayList<>();
		switch(w) {
		case 1:
			for(int k=0; k<4; k++) {
				int ni = si+di[k];
				int nj = sj+dj[k];
				al.add(new point(ni, nj));
			}
			break;
		case 2:
			al.add(new point(si+di[0], sj+dj[0]));
			al.add(new point(si+di[1], sj+dj[1]));
			break;
		case 3:
			al.add(new point(si+di[2], sj+dj[2]));
			al.add(new point(si+di[3], sj+dj[3]));
			break;
		case 4:
			al.add(new point(si+di[0], sj+dj[0]));
			al.add(new point(si+di[3], sj+dj[3]));
			break;
		case 5:
			al.add(new point(si+di[1], sj+dj[1]));
			al.add(new point(si+di[3], sj+dj[3]));
			break;
		case 6:
			al.add(new point(si+di[1], sj+dj[1]));
			al.add(new point(si+di[2], sj+dj[2]));
			break;
		case 7:
			al.add(new point(si+di[0], sj+dj[0]));
			al.add(new point(si+di[2], sj+dj[2]));
			break;
		}
		return al;
	}
	static boolean check(int si, int sj, int ni, int nj) {	
		//System.out.println(ni + " ni nj 여기 " + nj);
		ArrayList<point> al1 = make_root(ni,nj);
		for(int i=0; i<al1.size(); i++) {
			//System.out.println("ㅁ " + al1.get(i).x + " " + al1.get(i).y);
			if(al1.get(i).x == si && al1.get(i).y == sj)
				return true;
		}
		return false;
	}
	static class point{
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
