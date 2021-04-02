package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Mun_발전소설치 {
	public static int n, m;
	public static double limit, result = -1;
	public static node[] no;
	public static ArrayList<Edge>[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		limit = Double.parseDouble(br.readLine());
		no = new node[n+1];

		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			no[i] = new node(x, y);
		}

		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				long v1 = no[i].x - no[j].x;
				long v2 = no[i].y - no[j].y;
				double weight = Math.sqrt(Math.pow(v1, 2) + Math.pow(v2,  2));
				if(Double.compare(limit,weight) >=1) {
					al[i].add(new Edge(j,weight));
					al[j].add(new Edge(i,weight));
				}
			}
		}

		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(new Edge(v2, 0));
			al[v2].add(new Edge(v1, 0));
		}
		System.out.println(dijstra(1, n));
		
	}
	public static long dijstra(int start, int end) {
		Edge[] D = new Edge[n+1];
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
			
			if(D[edge.nowV].weight != edge.weight) continue;
			for(Edge next : al[edge.nowV]) {
				if(D[next.nowV].weight > D[edge.nowV].weight + next.weight) {
					D[next.nowV].weight = D[edge.nowV].weight + next.weight;
					pq.add(D[next.nowV]);
				}
			}
		}
		return (long) (D[n].weight * 1000);
	}
	public static class Edge implements Comparable<Edge>{
		int nowV;
		double weight;
		public Edge(int nowV, double weight) {
			super();
			this.nowV = nowV;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight, o.weight);
		}
	}
	public static class node{
		int x, y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
