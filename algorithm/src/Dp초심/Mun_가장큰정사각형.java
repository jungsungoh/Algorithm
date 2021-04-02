package Dp초심;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mun_가장큰정사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m =Integer.parseInt(l1.split(" ")[1]);
		int[][] arr = new int[n][m];
		int[][] d = new int[1001][1001];

		int max = 0;
		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = l2.charAt(j)-'0';
				if(arr[i][j] == 1) {
					d[i][j] =1;
					max = 1;
				}
			}
		}

		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(arr[i-1][j] == 1 && arr[i-1][j-1] == 1 && arr[i][j-1] ==1) {
					d[i][j] = Math.min(Math.min(d[i-1][j-1], d[i][j-1]), d[i-1][j])+1;
				}
				max = Math.max(d[i][j], max);
			}
		}

		System.out.println(max*max);
	}
}
