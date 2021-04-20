package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_마법사상어와파이어스톰 {
	public static int n, Q;
	public static int[][] arr;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l1= br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		n = (int)Math.pow(2, n);
		Q =Integer.parseInt(l1.split(" ")[1]);
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] query = new int[Q];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<Q; i++) {
			query[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int m=0 ;m<Q;m++) {
			int query_val = (int)Math.pow(2, query[m]);
			for(int i=0; i<n; i+= query_val) {
				for(int j=0;j<n; j+= query_val) {
					check(i,j,query_val);
				}
			}
			melt();
		}
		int sum = 0;
		int cnt = 0;
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sum+=arr[i][j];
				if(arr[i][j] != 0 && !visited[i][j]) {
					cnt = Math.max(findresult(i, j), cnt);
				}
			}
		}
		System.out.println(sum);
		System.out.println(cnt);
	}
	
	
	public static int findresult(int si, int sj) {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		visited[si][sj] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<n) {
					if(!visited[ni][nj] && arr[ni][nj] != 0) {
						q.add(new point(ni,nj));
						visited[ni][nj] = true;
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	
	
	public static void check(int si, int sj,int query) {
		int[][] tmp = new int[query][query];
		for(int i=si; i<si+query; i++) {
			for(int j=sj; j<sj+query; j++) {
				tmp[i-si][j-sj] = arr[i][j];
			}
		}
		tmp = rotate(tmp);
		for(int i=si; i<si+query; i++) {
			for(int j=sj; j<sj+query; j++) {
				arr[i][j] = tmp[i-si][j-sj];
			}
		}
	}
	
	public static int[][] rotate(int[][] temp) {
		int[][] tmp = new int[temp.length][temp[0].length];
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[0].length; j++) {
				tmp[i][j] = temp[temp.length-1-j][i];
			}
		}
		return tmp;
	}
	public static void melt() {
		ArrayList<point> decre = new ArrayList<>();
		for(int i=0; i<n ;i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] != 0) {
					int cnt = 0;
					for(int k=0; k<4; k++) {
						int ni = i +di[k];
						int nj = j + dj[k];
						if(ni>=0 &&ni<n && nj>=0 && nj<n) {
							if(arr[ni][nj] != 0) {
								cnt++;
							}
						}
					}
					if(cnt <3) {
						decre.add(new point(i,j));
					}
				}
			}
		}
		for(int i=0; i<decre.size(); i++) {
			point p = decre.get(i);
			arr[p.x][p.y]--; 
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


// 파이어스톰을 시전하려면 시전할 때마다 단계 L을 결정해야 한다. 파이어스톰은 먼저 격자를 2L × 2L 크기의 부분 격자로 나눈다.
// 그 후, 모든 부분 격자를 시계 방향으로 90도 회전시킨다. 

// 이후 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양이 1 줄어든다.
// . (r, c)와 인접한 칸은 (r-1, c), (r+1, c), (r, c-1), (r, c+1)이다. 아래 그림의 칸에 적힌 정수는 칸을 구분하기 위해 적은 정수이다.


// 재귀를 이용해 격자를 나누자
//  90 도회전

// 상하좌우 체크