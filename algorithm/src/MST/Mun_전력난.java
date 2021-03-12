package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_전력난 {
	public static int n, m, start = -1;
	public static ArrayList<Edge>[] al;
	public static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String l1 = br.readLine();
			n = Integer.parseInt(l1.split(" ")[0]);
			m = Integer.parseInt(l1.split(" ")[1]);
			if(n == 0 && m == 0) return;
			al = new ArrayList[n];
			start = -1;
			check = new boolean[n];
			for(int i=0; i<n; i++) {
				al[i] = new ArrayList<>();
			}
			int sum = 0;
			for(int i=0; i<m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				sum+= weight;
				if(start == -1) {
					start = v1;
				}
				al[v1].add(new Edge(v2,weight));
				al[v2].add(new Edge(v1,weight));
			}
			int val = prim();
			System.out.println(sum-val);
		}
	}
	public static int prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(start,0));
		int cnt = 0;
		int result = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();

			if(check[edge.nowV]) continue;
			check[edge.nowV] = true;
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
		return result;
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
