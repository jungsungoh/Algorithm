package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_정복자 {
	public static int n, m, t;
	public static ArrayList<Edge>[] al;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		t = Integer.parseInt(l1.split( " ")[2]);
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al[v1].add(new Edge(v2, weight));
			al[v2].add(new Edge(v1, weight));
		}
		mst();
		
 		
	}
	public static void mst() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[n+1];
		
		pq.add(new Edge(1, 0));
		int cnt = 0, sum = 0;
		int time =-1;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(check[edge.nowV]) continue;
			check[edge.nowV]= true;
			cnt++;
			sum = sum + edge.weight;
			if(time >=1) {
				sum += time*t;
			}
			time++;
			if(cnt == n) {
				break;
			}
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV]) {
					pq.add(next);
				}
			}
			
		}
		System.out.println(sum);
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
