package 디스조인트셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_친구비 {
	public static int[] parents, rank, count, each_cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		int k = Integer.parseInt(l1.split(" ")[2]);
		each_cost = new int[n+1];
		parents = new int[n+1];
		rank = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			each_cost[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			makeSet(i);
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			Union(v1, v2);
		}
		boolean[] used = new boolean[n+1];
		int val = 0;
		for(int i=1; i<=n; i++) {
			int v = findSet(i);
			if(!used[v]) {
				val += each_cost[v];
				used[v] = true;
			}
		}
		if(k <val) {
			System.out.println("Oh no");
		}else {
			System.out.println(val);
		}
	}
	public static void makeSet(int x) {
		parents[x] = x;
	}
	public static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}
		return parents[x] = findSet(parents[x]);
	}
	public static void Union(int x, int y) {
		int py = findSet(x);
		int px = findSet(y);
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
			each_cost[px] = Math.min(each_cost[py], each_cost[px]);
		}else {
			parents[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
			each_cost[py] = Math.min(each_cost[py], each_cost[px]);
		}
	}
}
