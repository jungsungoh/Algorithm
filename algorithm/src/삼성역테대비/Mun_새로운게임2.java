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
	public static ArrayList<horse>[][] status;
	public static int[] di = {0,0,0,-1,1};
	public static int[] dj = {0,1,-1,0,0};
	public static Queue<horse> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);

		arr = new int[n][n];
		status = new ArrayList[n][n];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				status[i][j] = new ArrayList<>();
			}
		}
		q = new LinkedList<>();
		for(int k =1; k<=m; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			status[v1-1][v2-1].add(new horse(v1-1,v2-1,k, dir));
			q.add(new horse(v1-1, v2-1, k, dir));
		}
		int flag = 0, turn = 1;
		while(true) {
			if(turn>1000) {
				System.out.println(-1);
				return;
			}
			int size = q.size();
			for(int s = 0; s<size; s++) {
				moving(q.poll());
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
		if(ni>=0 && ni<n && nj>=0 && nj<n && arr[ni][nj] !=2) {
			if(arr[ni][nj] == 0) { // 흰색
				movingWhite(h, ni, nj);
			}else if(arr[ni][nj] == 1) {
				movingRed(h, ni, nj);
			}
			if(status[ni][nj].size() >=4) {
				check = 1;
				return;
			}
		}else {
			movingblue(h);
		}
	}
	
	public static void movingWhite(horse h, int ni, int nj) {
		int idx = -1;
		for(int i=0; i<status[h.x][h.y].size(); i++) {
			horse find = status[h.x][h.y].get(i);
			if(find.idx == h.idx) {
				idx = i;
				break;
			}
		}
		int size = status[h.x][h.y].size();
		for(int i=idx; i<size;i++) {
			horse find = status[h.x][h.y].get(idx);
			status[h.x][h.y].remove(idx);
			status[ni][nj].add(new horse(ni,nj,find.idx,find.dir));
		}
		q.add(new horse(ni,nj, h.idx, h.dir));
	}
	
	public static void movingRed(horse h, int ni, int nj) {
		int idx = -1;
		for(int i=0; i<status[h.x][h.y].size(); i++) {
			horse find = status[h.x][h.y].get(i);
			if(find.idx == h.idx) {
				idx = i;
				break;
			}
		}
		Stack<horse> st = new Stack<>();
		int size = status[h.x][h.y].size();
		for(int i=idx; i<size;i++) {
			horse find = status[h.x][h.y].get(idx);
			status[h.x][h.y].remove(idx);
			st.push(new horse(ni,nj,find.idx,find.dir));
		}
		while(!st.isEmpty()) {
			status[ni][nj].add(st.pop());
		}
		q.add(new horse(ni,nj,h.idx, h.dir));
	}
	public static void movingblue(horse h) {
		if(h.dir == 1) h.dir =2;
		else if(h.dir == 2) h.dir =1;
		else if(h.dir ==3) h.dir=4;
		else if(h.dir ==4) h.dir =3;
		int ni = h.x +di[h.dir];
		int nj = h.y +dj[h.dir];
		if(ni>=0 && ni<n && nj>=0 && nj<n && arr[ni][nj] !=2) {
			// 이동
			if(arr[ni][nj] == 0) { // 흰색
				movingWhite(h, ni, nj);
			}else if(arr[ni][nj] == 1) {
				movingRed(h,ni,nj);
			}
			if(status[ni][nj].size() >=4) {
				check = 1;
				return;
			}
		}else {
			// 이동안하고 가만히 있음
			ArrayList<horse> al = status[h.x][h.y];
			int size = al.size();
			for(int i=0; i<size; i++) {
				horse find = al.get(i);
				if(find.idx == h.idx) {
					al.remove(i);
					status[h.x][h.y].add(i, new horse(h.x, h.y, h.idx, h.dir));
					break;
				}
			}
			q.add(new horse(h.x,h.y,h.idx,h.dir));
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


// 로운 게임은 크기가 N×N인 체스판에서 진행되고, 사용하는 말의 개수는 K개이다.

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
