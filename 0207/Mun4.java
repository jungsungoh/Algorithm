import java.util.Scanner;

public class Mun4 {
	static int[][] arr;
	static int[] cnt;
	static int n,m,r1,r2;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		r1 = sc.nextInt();
		r2 = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		cnt = new int[n+1];
		for(int i=0; i<m; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}
		dfs(r1);
		if(cnt[r2] == 0)
		{
			System.out.println(-1);
		}
		else {
			System.out.println(cnt[r2]);
		}
		
		
	}
	public static void dfs(int start) {
		visited[start] = true;
		
		for(int i=1; i<=n; i++)
		{
			if(arr[start][i] == 1 && !visited[i]) {
				cnt[i] = cnt[start]+1;
				dfs(i);
			}
		}
	}

}