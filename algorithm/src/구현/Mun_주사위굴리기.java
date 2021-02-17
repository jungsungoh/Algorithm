package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_주사위굴리기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		int si = Integer.parseInt(l1.split(" ")[2]);
		int sj = Integer.parseInt(l1.split(" ")[3]);
		int command = Integer.parseInt(l1.split(" ")[4]);
		int[] di = {0, 0,0,-1,1};
		int[] dj = {0, 1,-1,0,0};
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] row = new int[2][3];
		int flag = 0;
		int top = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice d = new dice();
		for(int i=0; i<command; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int ni = si+di[dir];
			int nj = sj+dj[dir];
			if(!(ni>=0 && ni<n && nj>=0 && nj<m)) {
				continue;
			}
			if(dir == 1) d.moveEast();
			else if(dir==2) d.moveWest();
			else if(dir==3) d.moveNorth();
			else if(dir==4) d.moveSouth();
			
			if(arr[ni][nj] == 0) {
				arr[ni][nj] = d.bottom;
			}else {
				d.bottom = arr[ni][nj];
				arr[ni][nj] = 0;
			}
			si = ni;
			sj = nj;
			System.out.println(d.top);
		}
	}
	public static class dice{
		int top, bottom, left,right,front,back;

		public void moveEast() {
			int tmp = top;
			top = left;
			left = bottom;
			bottom = right;
			right = tmp;
		}
		
		public void moveWest() {
			int tmp = top;
			top = right;
			right = bottom;
			bottom = left;
			left = tmp;
		}
		
		public void moveSouth() {
			int tmp = top;
			top =  back;
			back = bottom;
			bottom = front;
			front = tmp;
		}
		public void moveNorth() {
			int tmp = top;
			top = front;
			front = bottom;
			bottom = back;
			back = tmp;
		}
	}
}
