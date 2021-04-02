package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_우주신과의교감 {
	public static int n, m, start = -1;
	public static node[] no;
	public static ArrayList<Edge>[] al;
	public static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		no = new node[n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			no[i] = new node(x,y);
		}
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				long val1 = no[i].x-no[j].x;
				long val2 = no[i].y-no[j].y;
				double weight = Math.sqrt(Math.pow(val1, 2) + Math.pow(val2, 2));
				if(start == -1) {
					start = i;
				}
				al[i].add(new Edge(j, weight));
				al[j].add(new Edge(i, weight));
			}
		}
		
		for(int i=1; i<=m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(new Edge(v2, 0));
			al[v2].add(new Edge(v1, 0));
		}
		System.out.printf("%.2f",mst());
	}
	public static double mst() {
		check = new boolean[n+1];
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(start,0));
		int cnt = 0;
		double result = 0;
		while(!q.isEmpty()) {
			Edge edge = q.poll();
			
			if(check[edge.nowV]) continue;
			check[edge.nowV] = true;
			cnt++;
			result += edge.weight;
			if(cnt == n) {
				break;
			}
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV]) {
					q.add(next);
				}
			}
		}
		return result;
		
	}
	public static class Edge implements Comparable<Edge>{
		int nowV;
		double weight;

		public Edge(int nowV,double weight) {
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
