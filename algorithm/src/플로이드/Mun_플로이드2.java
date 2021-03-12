package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_플로이드2 {
	public static int n;
	public static int[][] arr, path;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m =Integer.parseInt(br.readLine());

		arr = new int[n+1][n+1];
		path = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}

		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[v1][v2] = Math.min(arr[v1][v2],weight);
			path[v1][v2] = v2;
		}
		floyd();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j] ==Integer.MAX_VALUE?0+ " ":arr[i][j] +" " );
			}System.out.println();
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n ;j++) {
				if(arr[i][j] == 0 || arr[i][j] == Integer.MAX_VALUE) {
					System.out.println(0);
					continue;
				}
				int start = i;
				ArrayList<Integer> al =new ArrayList<>();
				while(start != j) {
					al.add(start);
					start = path[start][j];
				}
				al.add(j);
				System.out.print(al.size()+ " ");
				for(int k=0; k<al.size(); k++) {
					System.out.print(al.get(k)+ " ");
				}
				System.out.println();
			}
		}
	}
	public static void floyd() {

		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
						if(arr[i][j] > arr[i][k] + arr[k][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
							path[i][j] =path[i][k];
						}
					}
				}
			}
		}
	}
}
