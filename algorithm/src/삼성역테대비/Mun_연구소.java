package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_연구소 {
	public static int n,m, max= 0;
	public static int[][] arr;
	public static int[] result;
	public static ArrayList<point> virus;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split( " ")[1]);
		arr = new int[n][m];
		virus = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					virus.add(new point(i,j));
				}
			}
		}
		result = new int[3];
		combi(0,0);
		System.out.println(max);
		
	}
	public static void combi(int idx, int target) {
		if(idx == result.length) {
			int[][] temp = new int[n][m];
			for(int i=0; i<n; i++) {
				temp[i] = Arrays.copyOf(arr[i],m);
			}
			for(int i=0; i<result.length; i++) {
				int si = result[i]/m;
				int sj = result[i]%m;
				if(temp[si][sj] != 0) {
					return;
				}else {
					temp[si][sj] = 1;
				}
			}
			bfs(temp);
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j] == 0) {
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
			return;
		}
		if(target == n*m) {
			return;
		}
			
		result[idx] = target;
		combi(idx+1, target+1);
		combi(idx, target+1);
		
	}
	
	public static void bfs(int[][] temp) {
		Queue<point> q = new LinkedList<>();
		boolean[][] visited =new boolean[n][m];
		for(int i=0; i<virus.size(); i++) {
			point vi = virus.get(i);
			q.add(vi);
			visited[vi.x][vi.y] = true;
		}
		
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int k=0; k<4; k++) {
				int ni = p.x + di[k];
				int nj = p.y + dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj] && temp[ni][nj] ==0) {
						visited[ni][nj] = true;
						temp[ni][nj] = 2;
						q.add(new point(ni,nj));
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


// 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

// 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 


// 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
// , 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳

// 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다.
// 연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값

// 벽세우기 => 조합 (0 인것 중에 3개)
