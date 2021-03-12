package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_확장게임 {
	public static int n,m, num;
//	public static ArrayList<player>[] players;
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
	
	}
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String l1 = br.readLine();
//		n = Integer.parseInt(l1.split(" ")[0]);
//		m = Integer.parseInt(l1.split(" ")[1]);
//		num = Integer.parseInt(l1.split(" ")[2]);
//		players = new player[num+1];
//		visited = new boolean[n][m];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for(int i=1; i<=num; i++) {
//			players[i] = new ArrayList<>();
//			players[i].add(s = Integer.parseInt(st.nextToken());
//		}
//		arr = new char[n][m];
//
//		for(int i=0; i<n; i++) {
//			String l2 = br.readLine();
//			for(int j=0; j<m; j++) {
//				arr[i][j] = l2.charAt(j);
//				if(Character.isDigit(arr[i][j])) {
//					players[arr[i][j]-'0'].x = i;
//					players[arr[i][j]-'0'].y = j;
//					players[arr[i][j]-'0'].num = arr[i][j]-'0';
//				}
//			}
//		}
//		bfs();
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(arr[i][j] + " ");
//			}System.out.println();
//		}
//	}
//	public static void bfs() {
//		Queue<player> q = new LinkedList<>();
//		for(int i=1; i<=num; i++) {
//			q.add(players[i]);
//			visited[players[i].x][players[i].y] = true;
//		}
//
//		while(!q.isEmpty()) {
//			for(int t=1; t<= num; t++) {
//				for(int s= 0; s<players[t].s; s++) {
//					player p = q.poll();
//
//					for(int k=0; k<4; k++) {
//						int ni = p.x+di[k];
//						int nj= p.y+dj[k];
//
//						if(ni>=0 && ni<n && nj>=0 && nj<m) {
//							if(!visited[ni][nj] && arr[ni][nj] == '.') {
//								arr[ni][nj] = (char)(p.num+'0');
//								visited[ni][nj] = true;
//								q.add(new player(p.x,p.y,p.s,p.num));
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//	public static class point{
//		int x, y;
//
//		public point(int x, int y) {
//			super();
//			this.x = x;
//			this.y = y;
//		}
//	}
//	public static class player{
//		int x, y, s, num;
//		public player() {};
//		public player(int x, int y, int s, int num) {
//			super();
//			this.x = x;
//			this.y = y;
//			this.s = s;
//			this.num = num;
//		}
//	}
}
// 게임은 라운드로 이루어져 있고, 
// 각 라운드마다 플레이어는 자기 턴이 돌아올 때마다 성을 확장해야 한다. 
// 제일 먼저 플레이어 1이 확장을 하고, 그 다음 플레이어 2가 확장을 하고, 이런 식으로 라운드가 진행된다.
// 각 턴이 돌아왔을 때, 플레이어는 자신이 가지고 있는 성을 비어있는 칸으로 확장한다. 
// 플레이어 i는 자신의 성이 있는 곳에서 Si칸 만큼 이동할 수 있는 모든 칸에 성을 동시에 만든다. 
// 위, 왼쪽, 오른쪽, 아래로 인접한 칸으로만 이동할 수 있으며, 벽이나 다른 플레이어의 성이 있는 곳으로는 이동할 수 없다. 성을 다 건설한 이후엔 다음 플레이어가 턴을 갖는다.