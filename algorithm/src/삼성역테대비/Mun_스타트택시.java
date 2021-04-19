package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_스타트택시 {
	public static int n,m, gas;
	public static ArrayList<client> Client;
	public static int[][] arr;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static point taxi;
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]); 
		m =Integer.parseInt(l1.split(" ")[1]);
		gas = Integer.parseInt(l1.split(" ")[2]); // 초기 연료의 양
		Client = new ArrayList<>();
		arr = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		taxi = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
		int t = 0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			Client.add(new client(t++,n1,n2,d1,d2, 0));
		}
		finddist();
		
	}
	public static void finddist() {
		int flag = 0;
		while(true) {
			if(Client.size() == 0) break;
			PriorityQueue<client> pq = new PriorityQueue<>();
			int dist = 0;
			for(int i=0; i<Client.size(); i++) {
				client c = Client.get(i);
				dist = bfs(c.startx, c.starty, taxi);
				pq.add(new client(c.idx,c.startx,c.starty, c.endx, c.endy, dist));
			}
			client c = pq.poll();
			Client.remove(c);
			gas -= c.dist;
			if(gas <= 0) {
				flag = 1;
				break;
			}
			point dest = new point(c.endx, c.endy,0);
			dist = bfs(c.startx, c.starty, dest);
			gas -= dist;
			if(gas <= 0) {
				flag = 1;
				break;
			}
			gas += (dist*2);
			taxi.x = c.endx;
			taxi.y = c.endy;
		}
		if(flag == 1) {
			System.out.println(-1);
		}else {
			System.out.println(gas);
		}
	}

	public static int bfs(int si, int sj, point target) {
		boolean[][] visited = new boolean[n+1][n+1];
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj, 0));
		visited[si][sj] = true;
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.x == target.x && p.y == target.y ) {
				return p.dist;
			}

			for(int k=0; k<4; k++) {
				int ni = p.x+di[k];
				int nj = p.y+dj[k];
				if(ni>=1 && ni<=n && nj>=1 && nj<=n) {
					if(!visited[ni][nj] && arr[ni][nj] != 1) {
						q.add(new point(ni,nj,p.dist+1));
						visited[ni][nj] = true;
					}
				}
			}
		}
		return Integer.MAX_VALUE;


	}
	public static class point{
		int x, y, dist;
		public point(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	public static class client implements Comparable<client>{
		int idx, startx,starty, endx, endy, dist;
		public client(int idx,int startx, int starty, int endx, int endy, int dist) {
			super();
			this.idx = idx;
			this.startx = startx;
			this.starty = starty;
			this.endx = endx;
			this.endy = endy;
			this.dist = dist;
		}
		@Override
		public int compareTo(client o) {
			// TODO Auto-generated method stub
			if(this.dist == o.dist) {
				if(this.startx == o.startx) {
					return Integer.compare(this.starty, o.starty);
				}else {
					return Integer.compare(this.startx, o.startx);
				}
			}else {
				return Integer.compare(this.dist, o.dist);
			}
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof client) {
				client c = (client)obj;
				return c.idx == this.idx;
			}
			return false;
		}
	}
}

// 스타트 택시는 특이하게도 손님을 도착지로 데려다줄 때마다 연료가 충전되고, 
// 연료가 바닥나면 그 날의 업무가 끝난다.
// 택시 기사 최백준은 오늘 M명의 승객을 태우는 것이 목표이


// 각 칸은 비어 있거나 벽이 놓여 있다. 택시가 빈칸에 있을 때, 상하좌우로 인접한 빈칸 중 하나로 이동할 수 있다. 
// 알고리즘 경력이 많은 백준은 특정 위치로 이동할 때 항상 최단경로로만 이동한다.

// M명의 승객은 빈칸 중 하나에 서 있으며, 다른 빈칸 중 하나로 이동하려고 한다. 
// 여러 승객이 같이 탑승하는 경우는 없다. 


// 따라서 백준은 한 승객을 태워 목적지로 이동시키는 일을 M번 반복해야 한다. 각 승객은 스스로 움직이지 않으며, 
// 출발지에서만 택시에 탈 수 있고, 목적지에서만 택시에서 내릴 수 있다.

// 백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
// 런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다. 
// 택시와 승객이 같은 위치에 서 있으면 그 승객까지의 최단거리는 0이다. 


// 연료는 한 칸 이동할 때마다 1만큼 소모된다.
// 한 승객을 목적지로 성공적으로 이동시키면, 그 승객을 태워 이동하면서 소모한 연료 양의 두 배가 충전된다.

// 이동하는 도중에 연료가 바닥나면 이동에 실패하고, 그 날의 업무가 끝난다.
//승객을 목적지로 이동시킨 동시에 연료가 바닥나는 경우는 실패한 것으로 간주하지 않는다.

