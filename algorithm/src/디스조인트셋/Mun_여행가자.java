package 디스조인트셋;

import java.util.Scanner;

public class Mun_여행가자 {
	public static int[] parents, rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parents = new int[n+1];
		rank = new int[n+1];
		for(int i=1; i<=n; i++) {
			makeSet(i);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int idx = sc.nextInt();
				if(idx == 1) {
					union(i+1, j+1);
				}
			}
		}
		int par = -1;
		boolean flag = true;
		for(int i=1; i<=m; i++) {
			int to = sc.nextInt();
			int findval = findSet(to);
			if(i == 1) {
				par = findval;
			}else {
				if(par != findval) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	public static void makeSet(int x) {
		parents[x] = x;
	}
	public static int findSet(int x) {
		if(x == parents[x]) return x;
		return parents[x] = findSet(parents[x]);
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}else {
			parents[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
