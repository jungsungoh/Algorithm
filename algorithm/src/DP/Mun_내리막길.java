package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_내리막길 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[1]);
		int m = Integer.parseInt(l1.split(" ")[0]);
		
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] d = new int[n][m];
		d[0][0] = 1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
			}
		}
		
	}
}
