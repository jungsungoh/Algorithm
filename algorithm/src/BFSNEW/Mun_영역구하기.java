package BFSNEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_영역구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		int h = Integer.parseInt(l1.split(" ")[2]);
		
		int[][] arr = new int[n][m];
		for(int k=0; k<h; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = m-1- Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = m-1 -Integer.parseInt(st.nextToken());
			
			for(int i=y1; i<y2; i++) {
				for(int j=x1; j<x2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}
}
