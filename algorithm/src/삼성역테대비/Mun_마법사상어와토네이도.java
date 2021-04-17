package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_마법사상어와토네이도 {
	public static int[][] percent = {{0, 0, 2, 0, 0},{0,10,7,1,0},{5,-1,-3,-2,0},{0,10,7,1,0},{0,0,2,0,0}};
	public static int n ;
	public static int[][] tonado;
	public static int[] di = {0,1,0,-1};
	public static int[] dj = {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		make_tonado();
	}
	public static void make_tonado() {
		tonado = new int[n][n];
		int startx = n/2, starty = n/2;
		int idx = 1, length = 1, k = 0, flag = 0; 
		int cnt = 0;
		while(true) {
			for(int j=0; j<length; j++) {
				tonado[startx][starty] = idx++;
				if(idx == n*n+1) {
					flag = 1;
					break;
				}
				startx+= di[k];
				starty+= dj[k];
			}
			if(flag ==1) {
				break;
			}
			k = (k+1)%4;
			cnt++;
			if(cnt == 2) {
				length++;
				cnt = 0;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(tonado[i][j] + " ");
			}System.out.println();
		}
	}
	public static int[][] rotate(int[][] arr, int dir) {
		int[][] temp = new int[5][5];
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				switch(dir) {
				case 0:
					temp[i][j] = arr[n-1-j][i];
					break;
				case 1:
					temp[i][j] = arr[n-1-i][n-1-j];
					break;
				case 2:
					temp[i][j] = arr[j][n-1-i];
					break;
				case 3:
					temp[i][j] = arr[i][j];
					break;
				}
			}
		}
		return temp;
	}
	public static void calc(int si, int sj, int dir) {
		int[][] temp = new int[5][5];
		if(dir == 0) {	
			temp = rotate(percent,2);
		}else if(dir == 1) {
			temp = rotate(percent, 0);
		}else if(dir == 2){
			temp = rotate(percent, 1);
		}else if(dir == 3) {
			
		}
		
	}
}

// N×N인 격자로 나누어진 모래밭에서 연습하려고 한다
// A[r][c]는 (r, c)에 있는 모래의 양을 의미한다.

// 토네이도를 시전하면 격자의 가운데 칸부터 토네이도의 이동이 시작된다. 
//  토네이도는 한 번에 한 칸 이동한다.
// 좌 하 우 상 반복
// 이동 2번마다 1씩증가

// 토네이도가 한 칸 이동할 때마다 모래는 다음과 같이 일정한 비율로 흩날리게 된다.
// 토네이도가 x에서 y로 이동하면, y의 모든 모래가 비율과 α가 적혀있는 칸으로 이동한다. 



// 회전

// 비율 배열 만들기
// 배열회전, 방향에 따라 같은 행,열 위치의 비율 만큼 준다
