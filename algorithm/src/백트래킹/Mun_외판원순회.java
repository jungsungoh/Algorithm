package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_외판원순회 {
	public static int n, result = Integer.MAX_VALUE;
	public static int[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			travel(i,0,0, i);
		}
		System.out.println(result);
	}
	public static void travel(int idx, int cnt, int value, int start) {
		if(value > result) {
			return;
		}
		if(cnt==n && idx == start) {
			value += arr[idx][start];
			result = Math.min(result, value);
			return;
		}
		
		
		for(int i=0; i<n; i++) {
			if(!visited[i] && arr[idx][i] > 0) {
				visited[i] = true;
				travel(i, cnt+1, value + arr[idx][i], start);
				visited[i] = false;
			}
		}
	}
}
