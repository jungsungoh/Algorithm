package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_서강그라운드 {
	public static int n, m, r, max;
	public static ArrayList<Edge>[] al;
	public static int[] each_item;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		r = Integer.parseInt(l1.split(" ")[2]);
		
		al = new ArrayList[n+1];
		each_item = new int[n+1];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
			each_item[i] = Integer.parseInt(st2.nextToken());
		}
		
		
		for(int i=0; i<r; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al[v1].add(new Edge(v2, weight));
			al[v2].add(new Edge(v1, weight));
		}
		
		for(int i=1; i<=n; i++) {
			Dijkstra(i);
		}
		System.out.println(max);
	}
	public static void Dijkstra(int start) {
		Edge[] d = new Edge[n+1];
		
		for(int i=1; i<=n; i++) {
			if(i == start) {
				d[i] = new Edge(i, 0);
			}else {
				d[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(d[start]);
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(d[edge.nowV].weight != edge.weight) continue;
			
			for(Edge next : al[edge.nowV]) {
				if(d[next.nowV].weight > d[edge.nowV].weight + next.weight) {
					d[next.nowV].weight = d[edge.nowV].weight + next.weight;
					pq.add(d[next.nowV]);
				}
			}
		}
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			if(d[i].weight <=m) {
				cnt += each_item[i];
			}
		}
		max = Math.max(cnt,  max);
		
		
	}
	public static class Edge implements Comparable<Edge>{
		int nowV, weight;

		public Edge(int nowV, int weight) {
			super();
			this.nowV = nowV;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
}
