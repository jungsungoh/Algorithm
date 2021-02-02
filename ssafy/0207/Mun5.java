import java.util.Scanner;

public class Mun5{
	private static int[] di = {-1,1,0,0};
	private static int[] dj = {0,0,-1,1};
	private static int n;
	private static int[][] arr;
	private static int cnt = 0;
	private static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][n+1];
	    visited = new boolean[n+1][n+1];
		int max = 0;
		for(int i=1; i<=n ;i++)
		{
			for(int j=1; j<=n; j++)
			{
				arr[i][j] = sc.nextInt();
				if(arr[i][j] > max)
				{
					max = arr[i][j];
				}
			}
		}
		
		int cnt_max = 0;
		for(int k=0; k<=max; k++) {
			cnt =0;
			for(int i=1; i<=n ;i++)
			{
				for(int j=1; j<=n; j++)
				{
					if(visited[i][j] == false && arr[i][j] >k)
					{
						dfs(i,j,k);
						cnt++;
					}
				}
			}
			for(int i=1; i<=n; i++)
			{
				for(int j=1; j<=n; j++)
				{
					visited[i][j] = false;
				}
			}
			if(cnt_max < cnt) {cnt_max = cnt;}
		}
		System.out.println(cnt_max);
		

	}
	public static void dfs(int si, int sj, int k)
	{
		visited[si][sj] = true;
		//System.out.println("si = " + si + " sj " + sj);
		int ni = si;
		int nj = sj;
		for(int p =0; p<4; p++)
		{
			ni = si+di[p];
			nj = sj+dj[p];
			if((ni >0 && ni <n+1) && (nj >0 && nj<n+1))
			{
				if(visited[ni][nj] == false && arr[ni][nj] >k) {
					dfs(ni,nj,k);
				}
			}

		}
	}
}