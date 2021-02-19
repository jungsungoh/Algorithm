package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_색종이만들기 {
	public static int[][] arr;
	public static int bc, wc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(n,0,0);
		System.out.println(wc + " " + bc);
		
	}
	public static void func(int n, int r, int c) {
		int v1 = arr[r][c];
		int flag =0;
		for(int i=r; i<n+r; i++) {
			for(int j=c; j<n+c; j++) {
				if(arr[i][j] != v1) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) break;
		}
		
		if(flag == 0) {
			if(v1 == 1) bc++;
			if(v1 == 0) wc++;
			return;
		}
		
		int half = n/2;
		func(half, r, c);
		func(half, r + half, c);
		func(half, r, c + half);
		func(half, r + half, c + half);
		
	}
}
