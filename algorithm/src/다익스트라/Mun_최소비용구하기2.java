package 다익스트라;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Mun_최소비용구하기2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Edge>[] al = new ArrayList[n+1];
		
		for(int i=1; i<=n ;i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=1; i<=m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int value = sc.nextInt();
			al[from].add(new Edge(to, value));
		}
		boolean[] check = new boolean[n+1];
		int[] pre = new int[n+1];
		Edge[] d = new Edge[n+1];
		int start = sc.nextInt();
		int end = sc.nextInt();
		for(int i=1; i<=n; i++) {
			if(i == start) {
				d[i] = new Edge(i,0);
			}else {
				d[i] = new Edge(i, Integer.MAX_VALUE);
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(d[start]);
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(d[edge.nowV].weight != edge.weight) continue;
			for(Edge next : al[edge.nowV]) {
				if(!check[next.nowV] && d[next.nowV].weight > d[edge.nowV].weight + next.weight) {
					d[next.nowV].weight = d[edge.nowV].weight + next.weight;
					pq.add(d[next.nowV]);
					pre[next.nowV] = edge.nowV;
				}
			}
			check[edge.nowV] = true;
		}
		System.out.println(d[end].weight);
		
		Stack<Integer> st = new Stack<>();
		for(int i=end; i != start ; i = pre[i]) {
			st.push(i);
		}
		st.push(start);
		System.out.println(st.size());
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
	
	
	
	
	public static class Edge implements Comparable<Edge>{
		int nowV, weight; // 노드, 까지 가는 최소거리

		public Edge(int preV, int weight) {
			super();
			this.nowV = preV;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
		
	}
}
