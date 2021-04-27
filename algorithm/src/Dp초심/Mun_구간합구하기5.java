package Dp초심;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_구간합구하기5 {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		
		int[][] arr =new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] d = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + arr[i][j];
			}
		}
		
		for(int i=0; i<m; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sum += (d[x2][y2] - d[x2][y1-1] - d[x1-1][y2]+d[x1-1][y1-1]);
			System.out.println(sum);
		}
	}
}
