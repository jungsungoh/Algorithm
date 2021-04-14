package 디스조인트셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_로봇조림 {
	public static int[] parents, rank, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parents = new int[100005];
		rank = new int[100005];
		cnt = new int[100005];
		for(int i=0; i<parents.length; i++) {
			makeSet(i);
		}
		
		for(int i=0; i<n; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			if(com.equals("I")) {
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				Union(num1, num2);
			}else if(com.equals("Q")) {
				int num = Integer.parseInt(st.nextToken());
				System.out.println(cnt[findSet(num)]);
			}
		}
		for(int i=1; i<4; i++) {
			System.out.println(findSet(i) + " " + cnt[i]);
		}
	}
	public static void makeSet(int x) {
		parents[x] = x;
		cnt[x] = 1;
	}
	public static int findSet(int x) {
		if(parents[x] ==x) return x;
		
		return parents[x] = findSet(parents[x]);
	}
	public static void Union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
			cnt[py] = cnt[py]+1;
		}else {
			parents[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
			cnt[px] = cnt[px]+1;
		}
	}
	
	
}
