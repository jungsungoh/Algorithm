package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_마법사상어와토네이도 {
	public static int n, allsum = 0 ;
	public static int[][] tonado, arr;
	public static int[] percent = {1,1,7,7,2,2,10,10,5};
	public static int[][] dx = {{-1,1,-1,1,-2,2,-1,1,0,0},{0,0,1,1,1,1,2,2,3,2},{-1,1,-1,1,-2,2,-1,1,0,0},{0,0,-1,-1,-1,-1,-2,-2,-3,-2}};
	public static int[][] dy = {{0,0,-1,-1,-1,-1,-2,-2,-3,-2},{1,-1,1,-1,2,-2,1,-1,0,0},{0,0,1,1,1,1,2,2,3,2},{-1,1,1,-1,2,-2,1,-1,0,0}};
	public static int[] di = {0,1,0,-1};
	public static int[] dj = {-1,0,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
		make_tonado();
		
		System.out.println(allsum);
	}
	public static void make_tonado() {
		tonado = new int[n][n];
		int startx = n/2, starty = n/2;
		int idx = 1, length = 1, k = 0, flag = 0; 
		int cnt = 0;
		while(true) {
			for(int j=0; j<length; j++) {
				tonado[startx][starty] = idx++;
				if(startx == 0 && starty==0) {
					flag = 1;
					break;
				}
				// 흩날리기
				spread(startx,starty,k);
//				for(int p=0; p<n; p++) {
//					for(int p2=0; p2<n; p2++) {
//						System.out.print(arr[p][p2] + " ");
//					}System.out.println();
//				}
//				System.out.println("============");
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
	// 좌, 상, 우, 하
	public static void spread(int si, int sj, int dir) {
//		int[] percent = {1,1,7,7,2,2,10,10,5};
//		if(dir == 0) { 
//			int[] dx = {-1,1,-1,1,-2,2,-1,1,0};
//			int[] dy = {0,0,-1,-1,-1,-1,-2,-2,-3};
//		}else if(dir==1) {
//			int[] dx = {0,0,-1,-1,-1,-1,-2,-2,-3};
//			int[] dy = {-1,1,1,-1,2,-2,1,-1,0};
//		}else if(dir ==2) {
//			int[] dx = {-1,1,-1,1,-2,2,-1,1,0};
//			int[] dy = {0,0,1,1,1,1,2,2,3};
//		}else if(dir ==3) {
//			int[] dx = {0,0,1,1,1,1,2,2,3};
//			int[] dy = {1,-1,1,-1,2,-2,1,-1,0};
//		}
		int sum = 0, dis =0;
		int yang = arr[si][sj];
		for(int k=0; k<9; k++) {
			int ni = si + dx[dir][k];
			int nj = sj + dy[dir][k];
			if(ni>=0 && ni<n && nj>=0 && nj<n) {
				arr[ni][nj] += (yang*(percent[k]/100));
			}else {
				dis += (yang*(percent[k]/100));
			}
			sum += (yang*(percent[k]/100));
		}
		
		int ni = si + dx[dir][9];
		int nj = sj + dy[dir][9];
		if(ni>=0 && ni<n && nj>=0 && nj<n) {
			arr[ni][nj] += (yang-sum);
		}else {
			dis += (yang-sum);
		}
		arr[si][sj] = 0;
		
		allsum += dis;
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
