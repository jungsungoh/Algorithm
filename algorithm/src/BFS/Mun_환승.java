package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_환승 {
	public static int[] visited;
	public static int n, k, m;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		k = Integer.parseInt(l1.split(" ")[1]);
		m = Integer.parseInt(l1.split(" ")[2]);
		
		al = new ArrayList[n+m+1];
		visited = new int[n+m+1];
		for(int i=0; i<n+m+1; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=n+1; i<m+n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++) {
				int next = Integer.parseInt(st.nextToken());
				al[i].add(next);
				al[next].add(i);
			}
		}
		Bfs();
		if(n !=1 && visited[n] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(visited[n]/2+1);
		}
		
	}
	public static void Bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == n) {
				return;
			}
			for(int next : al[now]) {
				if(visited[next] == 0) {
					visited[next] = visited[now]+1;
					q.add(next);
				}
			}
		}
	}
}
