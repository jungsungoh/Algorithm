package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mun_트리의부모찾기 {
	public static ArrayList<Integer>[] al;
	public static int n;
	public static boolean[] visited;
	public static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		al = new ArrayList[n+1];
		visited = new boolean[n+1];
		parents = new int[n+1];
		for(int i=1; i<=n ;i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(v2);
			al[v2].add(v1);
		}
		dfs(1);
		for(int i=2; i<=n; i++) {
			System.out.println(parents[i]);
		}
	}
	public static void dfs(int idx) {
		visited[idx] = true;
		
		for(int next : al[idx]) {
			if(!visited[next]) {
				parents[next] = idx;
				visited[next] = true;
				dfs(next);
			}
		}
	}
}
