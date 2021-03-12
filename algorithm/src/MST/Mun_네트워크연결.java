package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_네트워크연결 {
	public static int n, m;
	public static ArrayList<Edge>[] al;
	public static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		al = new ArrayList[n+1];
		for(int i=1; i<=n ;i++) {
			al[i] = new ArrayList<>();
		}
		check = new boolean[n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al[v1].add(new Edge(v2, weight));
			al[v2].add(new Edge(v1, weight));
		}
		prim();
	}
	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		int cnt = 0, result =0;
		pq.add(new Edge(1,0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(check[edge.nowV]) continue;
			check[edge.nowV] = true;
			result += edge.weight;
			cnt++;
			if(cnt == n) break;
			
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV]){
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
