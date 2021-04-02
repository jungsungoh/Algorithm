package 플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_행성연결 {
	public static int n;
	public static ArrayList<Edge>[] al;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				int weight = Integer.parseInt(st.nextToken());
				if(i != j) {
					al[i].add(new Edge(j,weight));
					al[j].add(new Edge(i, weight));
				}
			}
		}
		mst();
		
	}
	public static void mst() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1,0));
		boolean[] check = new boolean[n+1];
		int cnt = 0;
		long result = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(check[edge.nowV]) continue;
			
			check[edge.nowV]= true;
			cnt++;
			result += edge.weight;
			if(cnt == n) {
				break;
			}
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV]) {
					pq.add(next);
				}
			}
		}
		System.out.println(result);
			
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
