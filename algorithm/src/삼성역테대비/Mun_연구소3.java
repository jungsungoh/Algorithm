package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_연구소3 {
	public static int n, m, sol = Integer.MAX_VALUE;
	public static int[][] arr;
	public static ArrayList<point> al;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l1 = br.readLine();
		n= Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);

		result = new int[m];
		arr = new int[n][n];
		al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]=  Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					al.add(new point(i,j,true,false));
				}
			}
		}
		combi(0,0);
		System.out.println(sol==9999?"-1":sol);
	}
	public static void combi(int idx, int target) {
		if(result.length == idx) {
			int time = bfs(result);
			sol = Math.min(time, sol);
			return;
		}
		if(al.size() == target) {
			return;
		}

		result[idx] = target;
		combi(idx+1, target+1);
		combi(idx, target+1);
	}
	public static int bfs(int[] result) {
		int[][] temp = new int[n][n];
		for(int i=0; i<n; i++) {
			temp[i] = Arrays.copyOf(arr[i], n);
		}
		Queue<point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		for(int i=0; i<result.length; i++) {
			point p = al.get(result[i]);
			q.add(p);
			visited[p.x][p.y]= true; 
			temp[p.x][p.y]= 2; 
		}
		int time = 0;
		if(check(temp)) {
			return time;
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				point p = q.poll();
				for(int k=0; k<4; k++) {
					int ni = p.x + di[k];
					int nj = p.y + dj[k];
					if(ni>=0 && ni<n && nj>=0 && nj<n) {
						if(!visited[ni][nj] && arr[ni][nj] !=1) {
							q.add(new point(ni,nj, true, false));
							visited[ni][nj] = true;
							temp[ni][nj]= 2; 
						}
					}
				}
			}
			time++;
			if(check(temp)) {
				return time;
			}
		}
		return 9999;
	}
	public static boolean check(int[][] temp) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(temp[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static class point{
		int x, y;
		boolean isvirus, isactive;
		public point(int x, int y, boolean isvirus, boolean isactive) {
			super();
			this.x = x;
			this.y = y;
			this.isvirus = isvirus;
			this.isactive = isactive;
		}

	}
}

// 바이러스는 활성 상태와 비활성 상태가 있다
// 가장 처음에 모든 바이러스는 비활성 상태이고, 
// 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다. 
// 승원이는 연구소의 바이러스 M개를 활성 상태로 변경하려고 한다.

// 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.
// 0은 빈 칸, 1은 벽, 2는 바이러스의 위치이다.


// 바이러스 개수 조합 m개 + BFS
// 바이러스 클래스 만들기
// 비활성에 도착하면 비활성애도 같이 큐에 넣기
