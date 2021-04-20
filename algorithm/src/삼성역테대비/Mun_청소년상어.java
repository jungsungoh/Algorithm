package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_청소년상어 {
	public static int[] di = {0,-1,-1,0,1,1,1,0,-1};
	public static int[] dj = {0,0,-1,-1,-1,0,1,1,1};
	public static fish[][] arr;
	public static fish shark;
	public static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new fish[4][4];

		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				arr[i][j]= new fish(i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
			}
		}
		// 상어 넣기
		arr[0][0] = new fish(0,0,-1,arr[0][0].dir, arr[0][0].num);
		shark = arr[0][0];
		movingfish(arr);
		//movingShark(arr, shark);
		System.out.println(sum);
	}
	// 물고기 이동
	// 물고기는 번호가 작은 물고기부터 순서대로 이동한다.
	// 물고기는 한 칸을 이동할 수 있고, 이동할 수 있는 칸은 빈 칸과 다른 물고기가 있는 칸, 이동할 수 없는 칸은 상어가 있거나, 공간의 경계를 넘는 칸이다.
	// 각 물고기는 방향이 이동할 수 있는 칸을 향할 때까지 방향을 45도 반시계 회전시킨다. 만약, 이동할 수 있는 칸이 없으면 이동을 하지 않는다. 그 외의 경우에는 그 칸으로 이동을 한다.
	//  물고기가 다른 물고기가 있는 칸으로 이동할 때는 서로의 위치를 바꾸는 방식으로 이동한다.
	public static void movingfish(fish[][] arr2) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Map<Integer, fish> map = new HashMap<>();
		// 물고기들만 pq에 넣는다. 상어나 빈자리는 않넣음
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(arr2[i][j] != null && arr2[i][j].num > 0) {
					pq.add(arr2[i][j].num);
					map.put(arr2[i][j].num, arr2[i][j]);
				}
			}
		}

		int size = pq.size();
		for(int s=0; s<size; s++) {
			int p = pq.poll();
			fish f1 = map.get(p);
			for(int k=0 ;k<8; k++) {
				int ni = f1.x + di[f1.dir];
				int nj = f1.y + dj[f1.dir];
				if(ni>=0 && ni<4 && nj>=0 && nj<4 && (arr2[ni][nj] == null || arr2[ni][nj].num > -1)) {
					if(arr2[ni][nj] == null) {
						arr2[ni][nj] = new fish(ni, nj,f1.num,f1.dir,0);
						map.put(f1.num,arr2[ni][nj]);
						arr2[f1.x][f1.y]= null; 
					}else if(arr2[ni][nj] != null) {
						System.out.println(f1.num + " " + arr2[ni][nj].num);
						fish newfish = new fish(f1.x,f1.y,arr2[ni][nj].num,arr2[ni][nj].dir, 0);
						map.put(arr2[ni][nj].num, newfish);
						fish myfish = new fish(ni, nj, f1.num, f1.dir,0);
						arr2[ni][nj] = myfish;
						map.put(f1.num,myfish);
					}
					break;
				}
				f1.dir = f1.dir+1;
				if(f1.dir == 9) {
					f1.dir =1;
				}
				
			}
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(arr2[i][j] == null) {
					System.out.print(0 + " ");
				}else {
					System.out.print(arr2[i][j].num + " ");
				}
			}System.out.println();
		}
		System.out.println("===========");
	}
	public static void movingShark(fish[][] arr2, fish sk) {
		System.out.println(sk.sum);
		sum = Math.max(sum, sk.sum);
		movingfish(arr2);
		
		for(int dist =1; dist < 4; dist++) {
			int ni = sk.x +di[sk.dir]*dist;
			int nj = sk.y +dj[sk.dir]*dist;
			if(ni>=0 && ni<4 && nj>=0 && nj<4 && (arr2[ni][nj] != null && arr2[ni][nj].num >0)) {
				fish[][] temp = new fish[4][4];
				for(int i=0; i<4; i++) {
					temp[i] = Arrays.copyOf(arr2[i], 4);
				}
				temp[sk.x][sk.y] = null; 
				fish newshark = new fish(ni,nj,-1,temp[ni][nj].dir, sk.sum+temp[ni][nj].num);
				temp[ni][nj]= newshark; 
				movingShark(temp, newshark);
			}
		}

	}
	public static class fish implements Comparable<fish>{
		int x, y, num, dir, sum;

		public fish(int x, int y, int num, int dir, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.sum = sum;
		}
		@Override
		public int compareTo(fish o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.num, o.num);
		}
	}
}

// 한 칸에는 물고기가 한 마리 존재한다. 각 물고기는 번호와 방향을 가지고 있다.
// 번호는 1보다 크거나 같고, 16보다 작거나 같은 자연수이며, 두 물고기가 같은 번호를 갖는 경우는 없다.

// 방향은 8가지 방향(상하좌우, 대각선) 중 하나이다.
// 시작점 : 청소년 상어는 (0, 0)에 있는 물고기를 먹고, (0, 0)에 들어가게 된다. => 상어의 방향은 (0, 0)에 있던 물고기의 방향과 같다. 이후 물고기가 이동한다.





// 상어의 이동
// 물고기의 이동이 모두 끝나면 상어가 이동한다. 
// 상어는 방향에 있는 칸으로 이동할 수 있는데, 한 번에 여러 개의 칸을 이동할 수 있다. 
// 상어가 물고기가 있는 칸으로 이동했다면, 그 칸에 있는 물고기를 먹고, 그 물고기의 방향을 가지게 된다. 
// 이동하는 중에 지나가는 칸에 있는 물고기는 먹지 않는다. 
// 물고기가 없는 칸으로는 이동할 수 없다. 상어가 이동할 수 있는 칸이 없으면 공간에서 벗어나 집으로 간다.


// 상어가 이동한 후에는 다시 물고기가 이동하며, 이후 이 과정이 계속해서 반복된다.
// 상어가 먹을 수 있는 물고기 합의 최대 값.