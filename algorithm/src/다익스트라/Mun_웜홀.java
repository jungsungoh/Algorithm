package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_웜홀 {
	public static int n, m, w;
	public static ArrayList<Edge>[] al, al2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1  = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		w = Integer.parseInt(l1.split(" ")[2]);
		
		
		al = new ArrayList[n+1];
		al2 = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
			al2[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al[v1].add(new Edge(v2,weight));
			al[v2].add(new Edge(v1, weight));
		}
		for(int i=0; i<w; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			al2[v1].add(new Edge(v2,weight));
		}
		dijkstra(1);
		
	}
	public static boolean dijkstra(int start) {
		Edge[] d = new Edge[n+1];
		int[] pre = new int[n+1];
		for(int i=1; i<=n; i++) {
			if(i == start) {
				d[i] = new Edge(i,0);
			}else {
				d[i] = new Edge(i,Integer.MAX_VALUE);
			}
		}
		Queue<Edge> q = new LinkedList<>();
		q.add(d[start]);
		while(!q.isEmpty()) {
			Edge edge = q.poll();
			
			if(d[edge.nowV].weight != edge.weight) continue;
			
			for(Edge next : al[edge.nowV]) {
				if(d[next.nowV].weight > d[edge.nowV].weight + next.weight) {
					d[next.nowV].weight = d[edge.nowV].weight + next.weight;
					pre[next.nowV] = edge.nowV;
					q.add(d[next.nowV]);
				}
			}
		}
		for(int i=1; i<=n; i++) {
			System.out.println(d[i].weight + " ");
		}
		boolean check = false;
		for(int i=1; i<=n; i++) {
			if(start == i) continue;
			else {
				
			}
		}
		return false;
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
