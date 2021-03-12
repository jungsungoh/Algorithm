package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_라인프렌즈 {
	public static int n;
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		point[] friend = new point[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			friend[i] = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(!(friend[i].y < friend[j].x || friend[i].x> friend[j].y)) {
					arr[i][j] = 1; arr[j][i] = 1;
				}
			}
		}
		
		floyd();
//		System.out.println();
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j] ==Integer.MAX_VALUE?0+ " ": arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken())-1;
			int v2 = Integer.parseInt(st.nextToken())-1;
			System.out.println(arr[v1][v2]==Integer.MAX_VALUE?-1:arr[v1][v2]); 
		}
	}
	public static void floyd() {
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
						if(arr[i][j] > arr[i][k] + arr[k][j]) {
							arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
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
