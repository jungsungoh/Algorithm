package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_소문난칠공주 {
	public static char[][] arr;
	public static boolean[] visited;
	public static int result = 0;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<5; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		visited = new boolean[25];
		combi(0, 0, 0);
		System.out.println(result);
	}
	public static void combi(int idx, int cnt, int scnt) {
		if (cnt == 7) {  
			if (scnt >= 4) { 
				for(int i=0; i<25; i++) { 
					if(visited[i]) { 
						result += bfs(i/5, i%5)?1:0;
						break;
					}
				}
			}
			return;
		}
		if (idx == 25) 
			return;

		visited[idx] = true;
		combi(idx+1, cnt+1, scnt +(arr[idx/5][idx%5] == 'S' ? 1 : 0));
		visited[idx] = false;
		combi(idx+1, cnt, scnt);
	}
	public static boolean bfs(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		boolean[][] used = new boolean[5][5];
		used[si][sj] = true;
		int vCnt = 1;
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y +dj[k];
				if(ni>=0 && ni<5 && nj>=0 && nj<5) {
					if(!used[ni][nj] && visited[ni*5 +nj]) {
						q.add(new point(ni,nj));
						used[ni][nj] = true;
						vCnt++;
					}
				}
			}
		}
		return vCnt==7?true:false;
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
