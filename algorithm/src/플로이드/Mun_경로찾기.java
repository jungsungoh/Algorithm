package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_경로찾기 {
	public static int[][] arr;
	public static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) arr[i][j] = Integer.MAX_VALUE;
			}
		}
		floyd();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == Integer.MAX_VALUE || arr[i][j] == 0) {
					System.out.print(0 + " ");
				}else {
					System.out.print(1 + " ");
				}
			}System.out.println();
		}
		
	}
	public static void floyd() {

		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
						arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
					}
				}
			}
		}
	}
}
