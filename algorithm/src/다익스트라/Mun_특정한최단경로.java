package 다익스트라;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mun_특정한최단경로 {
	public static int n, m, v1, v2;
	public static ArrayList<Edge>[] al;
	public static Edge[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		al = new ArrayList[n+1];
		D = new Edge[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();
			al[from].add(new Edge(to, value));
			al[to].add(new Edge(from, value));
		}
		v1 = sc.nextInt(); v2 = sc.nextInt();
		dijkstra(1, n);
		long tmp = D[v1].weight;
		long tmp2 = D[v2].weight;
		// 2가지 경우
		// 1. 1-> v1 -> v2 -> N
		// 2. 1-> v2 -> v1 -> N
		dijkstra(v1, n);
		long tmp3 = D[n].weight;
		long tmp5 = D[v2].weight;
		dijkstra(v2, n);
		long tmp4 = D[n].weight;
		long tmp6 = D[v1].weight;
		
		long result1 = tmp + tmp5 + tmp4;
		long result2 = tmp2 + tmp6 + tmp3;
		long result = Math.min(result1,  result2);
		if(result >= Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	public static int dijkstra(int start, int end) {
		D = new Edge[n+1];
		for(int i=1; i<=n; i++) {
			if(start == i) {
				D[i] = new Edge(i, 0);
			}else {
				D[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(D[start]);
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(edge.weight != D[edge.nowV].weight) continue;
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
		
	}
}
