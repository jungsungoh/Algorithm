package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_톱니바퀴 {
	public static int[][] clock;
	public static int[] how;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		clock = new int[5][8];
		how = new int[5];
		for(int i=1; i<=4; i++) {
			String l1 = br.readLine();
			for(int j=0; j<8;j++) {
				clock[i][j]= l1.charAt(j)-'0';
			}
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			how = new int[5];
			rotate(idx, dir, -1);
			for(int j=1; j<5; j++) {
				if(how[j] != 0) {
					dorotate(j,how[j]);
				}
			}
		}
		int sum = 0;
		for(int i=1; i<=4; i++) {
			sum += (clock[i][0]*Math.pow(2, (i-1)));
		}
		System.out.println(sum);
	}
	
	public static void rotate(int idx, int dir, int from) {
		how[idx] = dir;
		// 2, 6
		if(from != idx+1 && idx >=1 && idx<=3 && clock[idx][2] != clock[idx+1][6]) { // 오른쪽
			rotate(idx+1, dir==1?-1:1, idx);
		}
		if(from != idx-1 && idx>=2 && idx<=4 && clock[idx][6] != clock[idx-1][2]) { // 왼쪽
			rotate(idx-1, dir==1?-1:1, idx);
		}
		
	}
	public static void dorotate(int idx, int dir) {
		if(dir == 1) {
			int tmp = clock[idx][7];
			for(int i=7; i>0; i--) {
				clock[idx][i] = clock[idx][i-1];
			}
			clock[idx][0] = tmp;
		}else if(dir == -1) {
			int tmp = clock[idx][0];
			for(int i=0; i<7; i++) {
				clock[idx][i] = clock[idx][i+1];
			}
			clock[idx][7] = tmp;
		}
	}
}

// 총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다.
// 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.
// 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다.
// 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.
// 톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 

//서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다. 
// 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, 
// B는 A가 회전한 방향과 반대방향으로 회전하게 된다. 