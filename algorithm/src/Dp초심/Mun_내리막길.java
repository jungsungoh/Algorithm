package Dp초심;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_내리막길 {
	public static int n, m;
	public static int[][] arr, d;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = new int[m + 1][n + 1]; 
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				d[i][j] = -1;
			}
		}
		int result = dfs(1,1);
		System.out.println(result);
	}
	public static int dfs(int x, int y) {
		if(x==m && y==n) {
			return 1;
		}
		
		if(d[x][y] != -1) {
			return d[x][y];
		}
		
		
		d[x][y] = 0;
		for(int k=0; k<4; k++) {
			int ni = x + di[k];
			int nj = y + dj[k];
			if(ni>=1 && ni<=m && nj>=1 && nj<=n) {
				if(arr[x][y] > arr[ni][nj]) {
					d[x][y] += dfs(ni,nj);
				}
			}
		}
		return d[x][y];
	}
}
