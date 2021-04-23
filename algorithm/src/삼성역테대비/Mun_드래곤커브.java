package 삼성역테대비;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Mun_드래곤커브 {
	public static int[] di = {0,-1,0,1};
	public static int[] dj = {1, 0, -1, 0};
	public static boolean[][] map;
	public static void main(String[] args) {
		
		map = new boolean[101][101];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for(int i=0; i<n; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			draw(x, y, storedir(d,g));
		}
		check();
	}
	public static ArrayList<Integer> storedir(int d, int g) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(d);
		Stack<Integer> st = new Stack<>();
		for(int c=0; c<g; c++) {
			int size = al.size();
			for(int i=0; i<size; i++) {
				st.add(al.get(i));
			}
			while(!st.isEmpty()) {
				al.add((st.pop()+1)%4);
			}
		}
		return al;
	}
	public static void draw(int x, int y, ArrayList<Integer> al) {
		map[x][y] = true;
		int ni = x, nj = y;
		int size = al.size();
		for(int i=0; i<size; i++) {
			int dir = al.get(i);
			ni += di[dir];
			nj += dj[dir];
			map[ni][nj] = true;
		}
	}
	public static void check() {
		int cnt = 0;
		for(int i=0; i<map.length-1; i++) {
			for(int j=0; j<map[0].length-1; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
}


// 드래곤 커브는 다음과 같은 세 가지 속성으로 이루어져 있으며, 이차원 좌표 평면 위에서 정의된다. 
// 좌표 평면의 x축은 → 방향, y축은 ↓ 방향이다.

// 1. 시작 점
// 2.시작 방향
// 3.세대


// 즉, K(K > 1)세대 드래곤 커브는 K-1세대 드래곤 커브를 끝 점을 기준으로 90도 시계 방향 회전 시킨 다음, 그것을 끝 점에 붙인 것이다.