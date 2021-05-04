package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mun_택배 {
	public static int[][] path;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);

		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) arr[i][j] = 0;
				else {
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		path  =new int[n][n];
		for(int i=0; i<m; i++) {
			String l2 = br.readLine();
			int v1 = Integer.parseInt(l2.split(" ")[0])-1;
			int v2 = Integer.parseInt(l2.split(" ")[1])-1;
			int weight = Integer.parseInt(l2.split(" ")[2]);
			arr[v1][v2] = weight;
			arr[v2][v1] = weight;

			path[v1][v2] = v1;
			path[v2][v1] = v2;
		}
		floyd(arr);
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) System.out.print("- ");
				else {
					System.out.print(path[i][j] + " ");

				}
			}
			System.out.println();
		}
	}
	public static void floyd(int[][] arr) {
		int n = arr.length;
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
						if(arr[i][k] + arr[k][j] < arr[i][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
							path[i][j] = path[k][j];
						}
					}
				}
			}
		}
	}
}
