package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_연구소 {
	public static int n, m, max=0;
	public static int[][] arr;
	public static boolean[][] visited;
	public static ArrayList<point> virus;
	public static int[] di  = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		
		arr = new int[n][m];
		virus = new ArrayList<>();
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					virus.add(new point(i,j));
				}
			}
		}
		combi(0,0);
		System.out.println(max);
	}
	public static void combi(int idx, int cnt) {
		int si = idx/m, sj = idx%m;
		if(cnt ==3) {
			int[][] tmp = new int[n][m];
			for(int i=0; i<n; i++) {
				tmp[i] = Arrays.copyOf(arr[i], arr[i].length);
			}
			//bfs(tmp);
			int result = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(tmp[i][j] == 0) {
						result++;
					}
					System.out.print(tmp[i][j] + " ");
				}System.out.println();
			}
			System.out.println("================");
			max = Math.max(max, result);
			return;
		}
		if(arr[si][sj] != 0 || idx == n*m) {
			return;
		}
		arr[si][sj] =1;
		combi(idx+1, cnt+1);
		arr[si][sj] = 0;
		combi(idx+1, cnt);
		
		
	}
	public static void bfs(int[][] tmp) {
		Queue<point> q = new LinkedList<>();
		visited = new boolean[n][m];
		for(int i=0; i<virus.size(); i++) {
			point p = virus.get(i);
			q.add(new point(p.x, p.y));
			visited[p.x][p.y]= true; 
		}
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj] && tmp[ni][nj] == 0) {
						q.add(new point(ni, nj));
						visited[ni][nj] = true;
						tmp[ni][nj] = 2;
					}
				}
			}
		}
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


// 일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 
// 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
// 이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 
// 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
// . 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 


// 1. 조합
// 2. bfs
// 3. 안전영역 세기