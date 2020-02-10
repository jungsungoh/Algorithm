import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun2 {
	static int[][] arr;
	static int n;
	static int m;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0 ; i<m; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}
		dfs(1);
		//bfs(1);
		for(int i=1; i<=n; i++)
		{
			if(visited[i] == true) {
				cnt++;
			}
		}
		System.out.println(cnt-1);
	}
	public static void dfs(int start)
	{
		visited[start] = true;
		
		for(int i=1; i<=n; i++)
		{
			if(arr[start][i] == 1 && !visited[i])
			{
				dfs(i);
			}
		}
		
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty())
		{
			int num = q.poll();
			System.out.println(num);
			visited[num] = true;
			for(int i=1; i<=n; i++) {
				if(arr[num][i] == 1 && !visited[i])
				{
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}