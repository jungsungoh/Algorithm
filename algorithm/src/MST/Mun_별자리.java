package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Mun_별자리 {
	public static boolean[] check;
	public static ArrayList<Edge>[] al;
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		point[] star = new point[n];
		for(int i=0; i<n; i++) {
			star[i] = new point(sc.nextDouble(), sc.nextDouble());
		}
		al = new ArrayList[n];
		for(int i=0; i< n; i++) {
			al[i] = new ArrayList<>();
		}
		check = new boolean[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i == j) continue;
				double weight2 = Math.pow(Math.abs(star[i].x - star[j].x), 2)+Math.pow(Math.abs(star[i].y-star[j].y),2);
				double weight = Math.sqrt(weight2);
				al[i].add(new Edge(j,weight));
				al[j].add(new Edge(i,weight));
			}
		}
		prim();
	}
	public static void prim() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		double result = 0;
		int cnt = 0;
		pq.add(new Edge(0,0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(check[edge.nowV]) continue;
			result+= edge.weight;
			check[edge.nowV]= true;
			cnt++;
			if(n==cnt) break;
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV]) {
					pq.add(next);
				}
			}
			
		}
		System.out.printf("%.2f",result);
	}
	public static class point{
		double x, y;

		public point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
		
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
}
