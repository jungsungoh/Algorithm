package BFSNEW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun_숨바꼭질 {
	public static int[] visited;
	public static int n, k;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		visited = new int[200005];
		bfs();
		System.out.println(visited[k]-1);
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = 1;
		int dist = 2;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s =0; s<size; s++) {
				int next = q.poll();
				if(next == k) {
					return;
				}
				if(next*2 <= 100000 && visited[next*2] == 0) {
					q.add(next*2);
					visited[next*2] = dist;
				}
				if(next+1 <= 100000 && visited[next+1] == 0) {
					q.add(next+1);
					visited[next+1] = dist;
				}
				if(next-1 >= 0 && visited[next-1] == 0) {
					visited[next-1] = dist;
					q.add(next-1);
				}
			}dist++;
		}
	}
}
