package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Mun_문제집 {
	public static int n, m;
	public static ArrayList<Integer>[] al;
	public static int[] pointed_cnt;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		pointed_cnt = new int[n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(v2);
			pointed_cnt[v2]++;
		}
		topol_sort();
		System.out.println(sb.toString());
	}
	public static void topol_sort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(pointed_cnt[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur + " ");
			
			for(int next : al[cur]) {
				pointed_cnt[next]--;
				if(pointed_cnt[next]==0) {
					pq.add(next);
				}
			}
			
		}
	}
}
// 1번부터 N번까지 총 N개의 문제로 되어 있는 문제집을 풀려고 한다. 문제는 난이도 순서로 출제되어 있다
//1.N개의 문제는 모두 풀어야 한다.
//2.먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
//3.가능하면 쉬운 문제부터 풀어야 한다.