package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mun_새로운게임2 {
	public static int n, m, check = 0;
	public static int[][] arr;
	public static ArrayList<Integer>[][] status;
	public static int[] di = {0,0,0,-1,1};
	public static int[] dj = {0,1,-1,0,0};
	public static horse[] horse_status ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);

		arr = new int[n+1][n+1];
		status = new ArrayList[n+1][n+1];

		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				status[i][j] = new ArrayList<>();
			}
		}
		horse_status = new horse[m+1];
		for(int k =1; k<=m; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			status[v1][v2].add(k);
			horse_status[k] = new horse(v1, v2, k, dir);
		}
		int flag = 0, turn = 1;
		while(true) {
			if(turn>1000) {
				System.out.println(-1);
				return;
			}
			for(int s = 1; s<=m; s++) {
				moving(horse_status[s]);
				if(check == 1) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				break;
			}
			
			turn++;
		}
		System.out.println(turn);
	}
	public static void moving(horse h) {
		int ni = h.x + di[h.dir];
		int nj = h.y + dj[h.dir];
		if(ni >n || ni <1 || nj >n || nj < 1 || arr[ni][nj] == 2) {
			movingblue(h);
			ni = h.x +di[h.dir];
			nj = h.y +dj[h.dir];
		}
		if(ni>=1 && ni<=n && nj>=1 && nj<=n && arr[ni][nj] !=2) {
			if(arr[ni][nj] == 0) { // 흰색
				movingWhite(h, ni, nj);
			}else if(arr[ni][nj] == 1) {
				movingRed(h, ni, nj);
			}
			if(status[ni][nj].size() >=4) {
				check = 1;
				return;
			}
		}
	}

	public static void movingWhite(horse h, int ni, int nj) {
		ArrayList<Integer> from =status[h.x][h.y];
		ArrayList<Integer> to = status[ni][nj];
		int start= -1;
		for(int i=0; i<from.size(); i++) {
			if(from.get(i) == h.idx) {
				start = i;
				break;
			}
		}
		int size = from.size();
		for(int i=start; i<size;i++) {
			int h_num = from.get(i);
			to.add(h_num);
			horse_status[h_num].x = ni;
			horse_status[h_num].y = nj;
		}
		for(int i=size-1; i>=start; i--) {
			from.remove(i);
		}
	}

	public static void movingRed(horse h, int ni, int nj) {
		ArrayList<Integer> from =status[h.x][h.y];
		ArrayList<Integer> to = status[ni][nj];
		int start= -1;
		for(int i=0; i<from.size(); i++) {
			if(from.get(i) == h.idx) {
				start = i;
				break;
			}
		}
		int size = from.size();
		for(int i=size-1; i>=start;i--) {
			int h_num = from.get(i);
			to.add(h_num);
			horse_status[h_num].x = ni;
			horse_status[h_num].y = nj;
		}
		for(int i=size-1; i>=start; i--) {
			from.remove(i);
		}
	}
	public static void movingblue(horse h) {
		if(h.dir == 1) {
			horse_status[h.idx].dir = 2;
		}else if(h.dir == 2) {
			horse_status[h.idx].dir = 1;
		}else if(h.dir ==3) {
			horse_status[h.idx].dir = 4;
		}else if(h.dir ==4) {
			horse_status[h.idx].dir = 3;
		}
	}
	public static class horse{
		int x, y , idx, dir;

		public horse(int i, int j, int idx, int dir) {
			super();
			this.x = i;
			this.y = j;
			this.idx = idx;
			this.dir = dir;
		}
	}
}	


// 새로운 게임은 크기가 N×N인 체스판에서 진행되고, 사용하는 말의 개수는 K개이다.

// 말은 원판모양이고, 하나의 말 위에 다른 말을 올릴 수 있다. 
// 체스판의 각 칸은 흰색, 빨간색, 파란색 중 하나로 색칠되어있다.
// 게임은 체스판 위에 말 K개를 놓고 시작한다. 말은 1번부터 K번까지 번호가 매겨져 있고, 이동 방향도 미리 정해져 있다. 
// 이동 방향은 위, 아래, 왼쪽, 오른쪽 4가지 중 하나이다.

// ====

// 턴 한 번은 1번 말부터 K번 말까지 순서대로 이동시키는 것이다. 
//  한 말이 이동할 때 위에 올려져 있는 말도 함께 이동한다

// 말의 이동 방향에 있는 칸에 따라서 말의 이동이 다르며 아래와 같다. 
// 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.

// 흰색인 경우에는 그 칸으로 이동한다.
// 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
// A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.


//빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다

// 파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다.
// 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.


//  0은 흰색, 1은 빨간색, 2는 파란색이다.
