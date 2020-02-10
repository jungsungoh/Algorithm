import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun1 {
	static int[][] map;
	static boolean[] visit;
	static int N, M, V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int v1= sc.nextInt();
			int v2 = sc.nextInt();
			map[v1][v2] = 1;
			map[v2][v1] = 1;
		}
		dfs(V);
		System.out.println("");
		bfs(V);
	}
	static void dfs(int now) {
		visit[now] = true;
		System.out.print(now+" ");
		for(int i=1; i<=N; i++) {
			if(map[now][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
	static void bfs(int now) {
		visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(now);
		while(!q.isEmpty()) {
			int num = q.poll();
			System.out.print(num + " ");
			visit[num] = true;
			for(int i=1; i<=N; i++)
			{
				if(map[num][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
	}
}