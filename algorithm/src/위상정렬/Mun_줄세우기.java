package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_줄세우기 {
	public static int n, m;
	public static int[] pointed_cnt;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		pointed_cnt = new int[n+1];
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(v2);
			pointed_cnt[v2]++;
		}
		topol_sort();
	}
	public static void topol_sort() {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result =  new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(pointed_cnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			for(int next : al[cur]) {
				pointed_cnt[next]--;
				if(pointed_cnt[next] == 0) {
					q.add(next);
				}
			}
		}
		if(result.size() != n) {
			System.out.println(0);
		}
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	
}
