package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mun_스도쿠 {
	public static int n;
	public static int[][] arr;
	public static ArrayList<point> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = 9;
		arr  = new int[n][n];

		al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) {
					al.add(new point(i,j));
				}
			}
		}
	}
	public static void dfs(int idx) {


		for(int k=0; k<al.size(); k++) {
			

		}
	}

	public static void check(int si, int sj) {

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int pi = 3*i; int pj = 3*j;
				if(si >= pi && si<pi+3 && sj>=pj && sj<pj+3) {
					for(int ni = pi; ni <pi+3; ni++) {
						for(int nj=pj; nj<pj+3; nj++) {
							
						}
					}
				}
			}
		}
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
