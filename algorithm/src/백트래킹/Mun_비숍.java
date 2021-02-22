package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_비숍 {
	public static int cnt = 0, n, max = 0;
	public static int[][] arr;
	public static boolean[] leftD, rightD;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		leftD = new boolean[40];
		rightD = new boolean[40];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		vishop(0);
		System.out.println(max);
		
	}
	
	public static void vishop(int cnt) {
		
		max = Math.max(cnt, max);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1 && !leftD[i+j] && !rightD[i-j + n-1]) {
					leftD[i+j] = true;
					rightD[i-j+ n-1] = true;
					vishop(cnt++);
					leftD[i+j] = false;
					rightD[i-j +n-1] = false;
				}
			}
		}
	}
}
