package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_나만안되는연애 {
	public static int n, m;
	public static boolean[] gender;
	public static ArrayList<Edge>[] al;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		gender = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n; i++) {
			String ch = st.nextToken();
			if(ch.equals("M")) {
				gender[i] = true;
			}else {
				gender[i] =false;
			}
		}
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		int start = Integer.MAX_VALUE;
		for(int i=1; i<=m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st2.nextToken());
			int v2 = Integer.parseInt(st2.nextToken());
			int weight = Integer.parseInt(st2.nextToken());
			al[v1].add(new Edge(v2,weight));
			al[v2].add(new Edge(v1,weight));
			start = Math.min(start,  v1);
		}
		mst(start);
	}
	public static void mst(int start) {
		boolean[] check = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int cnt = 0, result = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(check[edge.nowV] ) continue;
			cnt++;
			result += edge.weight;
			check[edge.nowV]= true; 
			if(cnt == n) {
				break;
			}
			
			
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV] && gender[edge.nowV] != gender[next.nowV]) {
					pq.add(next);
					
				}
			}
		}
		if(cnt != n) {
			System.out.println(-1);
		}else {
			System.out.println(result);
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
