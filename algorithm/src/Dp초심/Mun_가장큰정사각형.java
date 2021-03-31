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
		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = l2.charAt(j)-'0';
			}
		}
		int[][] D = new int[n][m];
		D[0][0] = arr[0][0];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
			}
		}
	}
}
