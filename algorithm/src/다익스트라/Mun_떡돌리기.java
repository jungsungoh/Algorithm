package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_떡돌리기 {
	public static int n, m, x, y;
	public static ArrayList<Edge>[] al;
	public static Edge[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		x = Integer.parseInt(l1.split(" ")[2]);
		y = Integer.parseInt(l1.split(" ")[3]);
		
		al = new ArrayList[n];
		for(int i=0; i<n ;i++) {
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
		Dijkstra(y);
		Arrays.sort(d);
		int answer = 1;
		int totaldist = 0;
		for(int i=0; i<d.length; i++) {
			if(d[i].weight *2 > x) {
				answer = -1;
				break;
			}
			totaldist += d[i].weight*2;
			if(totaldist > x) {
				answer++;
				totaldist = d[i].weight*2;
			}
		}
		System.out.println(answer);
		
	}
	public static void Dijkstra(int start ) {
		d = new Edge[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			if(i == start) {
				d[i] = new Edge(i, 0);
			}else {
				d[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
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
