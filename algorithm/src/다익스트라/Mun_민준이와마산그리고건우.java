package 다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mun_민준이와마산그리고건우 {
	public static ArrayList<Edge>[] al;
	public static Edge[] D;
	public static int v, m, p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		m = sc.nextInt();
		p = sc.nextInt();
		
		al = new ArrayList[v+1];
		
		for(int i=1 ;i<=v; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			al[from].add(new Edge(to, weight));
			al[to].add(new Edge(from, weight));
		}
		
		long dist1 = dijstra(1, v);
		long dist2 = dijstra(1, p);
		long dist3 = dijstra(p, v);
		if(dist1 < dist2 + dist3) {
			System.out.println("GOOD BYE");
		}else {
			System.out.println("SAVE HIM");
		}
	}
	public static int dijstra(int start, int end) {
		D = new Edge[v+1];
		for(int i=1; i<=v; i++) {
			if(i == start) {
				D[i] = new Edge(i, 0);
			}else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(D[start]);
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(D[edge.nowV].weight != edge.weight) continue;
			for(Edge next : al[edge.nowV]) {
				if(D[next.nowV].weight > D[edge.nowV].weight + next.weight) {
					D[next.nowV].weight = D[edge.nowV].weight + next.weight;
					pq.add(D[next.nowV]);
				}
			}
		}
		return D[end].weight;
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
		@Override
		public String toString() {
			return String.valueOf(this.weight);
			
		}
	}
}
