package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_불켜기 {	
	public static boolean[] visited;
	public static int n,m,max;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		al = new ArrayList[n*n];
		for(int i=0; i<n*n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			
			
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			if((Math.abs(r1-r2) ==1 && c1==c2) || (r1==r2 && Math.abs(c1-c2)==1)) {
				al[r1*n+c1].add(r2*n+c2);
			}
		}
		visited = new boolean[n*n];
		for(int i=0; i<n*n; i++) {
			if(al[i].size() != 0 && !visited[i]) {
				max = Math.max(bfs(i), max);
				System.out.println("=======================");
			}
		}
		System.out.println(max);
	}
	public static int bfs(int start) {
		int cnt = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i=0; i<al[p].size(); i++) {
				int num = al[p].get(i);
				if(!visited[num]) {
					System.out.println(num);
					q.add(num);
					visited[num] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
