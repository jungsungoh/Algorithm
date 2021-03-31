package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mun_puyopuyo {
	public static int n, m;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static Queue<point> bomb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[12][6];
		n = 12;
		m = 6;
		for(int i=0; i<12; i++) {
			String s = br.readLine();
			for(int j=0; j<6;j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		int cnt =0;
		visited = new boolean[n][m];
		while(true) {
			int flag = 0;
			for(int i =0 ;i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j] !='.') {
						visited = new boolean[n][m];
						bomb = new LinkedList<>();
						bfs(i,j);
						if(bomb.size() >=4) {
							int size = bomb.size();
							for(int k=0; k<size; k++) {
								point p = bomb.poll();
								arr[p.x][p.y]= '.'; 
							}
							flag = 1;
						}
					}
				}
			}
			if(flag == 1) {
				drop();
				cnt++;
			}else {
				break;
			}
		}
		System.out.println(cnt);
	}
	public static void drop() {
		Stack<Character> st = new Stack<>();
		for(int j=0; j<m; j++) {
			for (int i = 0; i < 12; i++) { 
				if (arr[i][j] != '.') 
					st.push(arr[i][j]); 
			} 
			for (int i = 11; i >= 0; i--) { 
				if (st.isEmpty()) 
					arr[i][j] = '.'; 
				else arr[i][j] = st.pop(); 
			}

		}
	}
	public static void bfs(int si, int sj) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj));
		bomb.add(new point(si,sj));
		visited[si][sj] = true;
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int k=0; k<4; k++) {
				int ni = p.x + di[k];
				int nj = p.y+dj[k];
				if(ni>=0 && ni<n && nj>=0 && nj<m) {
					if(!visited[ni][nj] && arr[ni][nj] == arr[si][sj]) {
						q.add(new point(ni,nj));
						visited[ni][nj] = true;
						bomb.add(new point(ni,nj));
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
	public static void print() {
		for(int i=0; i<12; i++) {
			for(int j=0; j<6; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		System.out.println("======================");
	}
}


// 필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
// 뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.
// 뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.

// 아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 
// 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.
// 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.
