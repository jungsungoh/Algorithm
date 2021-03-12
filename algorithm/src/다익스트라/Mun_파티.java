package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_파티 {
	public static int n, m, k;
	public static ArrayList<Edge>[] al2, real;
	public static Edge[] D, D2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		k = Integer.parseInt(l1.split(" ")[2]);
		al2 = new ArrayList[n+1];
		real = new ArrayList[n+1];
		for(int i=1 ;i<=n; i++) {
			al2[i] = new ArrayList<>();
			real[i] = new ArrayList<>();
		}
		D = new Edge[n+1];
		D2 = new Edge[n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al2[from].add(new Edge(to, weight));
			real[to].add(new Edge(from, weight));
		}

		int result = 0;
		dijkstra(al2, k, D);
		dijkstra(real, k, D2);
		for(int i=1 ; i<=n; i++) {
			int temp = D[i].weight + D2[i].weight;
			result = Math.max(result, temp);
		}
		System.out.println(result);
		
	}
	
	public static void dijkstra(ArrayList<Edge>[] al, int start, Edge[] D) {
		for(int i=1; i<=n; i++) {
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
			if(edge.weight != D[edge.nowV].weight) continue;
			for(Edge next : al[edge.nowV]) {
				if(D[next.nowV].weight > D[edge.nowV].weight + next.weight) {
					D[next.nowV].weight = D[edge.nowV].weight + next.weight;
					pq.add(D[next.nowV]);
				}
			}
		}
		
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
