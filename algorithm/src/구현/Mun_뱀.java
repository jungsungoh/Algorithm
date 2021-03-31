package 구현;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Mun_뱀 {
	public static int[] di = {0,1,0,-1};
	public static int[] dj = {1,0,-1,0};
	public static int[][] arr;
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		arr = new int[n+1][n+1];
		arr[1][1] = 2;
		for(int i=0; i<k; i++) {
			int si = sc.nextInt();
			int sj = sc.nextInt();
			arr[si][sj] = 1;
		}
		int T = sc.nextInt();
		Map<Integer, Character> m = new HashMap<>();
		ArrayList<point> snake = new ArrayList<>();
		snake.add(new point(1,1));
		for(int t= 0; t<T; t++ ) {
			m.put(sc.nextInt(), sc.next().charAt(0));
		}

		int result = -1;
		int dir = 0, time = 0;
		while(true) {
			time++;
			point p = snake.get(snake.size()-1);
			int ni = p.x + di[dir];
			int nj = p.y + dj[dir];
			if(ni >=1 && ni<=n && nj>=1 && nj<=n && arr[ni][nj] !=2) {
				if(m.containsKey(time)) {
					char turn = m.get(time);
					if(turn == 'L') {
						if((dir-1) <0) {
							dir = 3;
						}else {
							dir = (dir-1)%4;
						}
					}else {
						dir = (dir+1)%4;
					}
				}
				snake.add(new point(ni, nj));
				if(arr[ni][nj] == 1) {
					arr[ni][nj] = 0;
				}else {
					point t = snake.get(0);
					arr[t.x][t.y] = 0;
					snake.remove(0);
					
				}
				arr[ni][nj] = 2;
			}else {
				result = time;
				break;
			}
		}
		System.out.println(result);
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
// 게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 
// 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

// 뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

// 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
// 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
// 사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.