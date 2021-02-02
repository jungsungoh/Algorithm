import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mun3 {
	static int n, cnt= 0;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<>();
		n= sc.nextInt();
		arr = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for(int i=1; i<=n;i++) {
			String s = sc.next();
			for(int j=1; j<=n; j++) {
				char ch = s.charAt(j-1);
				arr[i][j] = (int)(ch-48);
			}
		}
		for(int i=1 ;i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(visited[i][j] == false && arr[i][j] == 1) {
					cnt = 1;
					dfs(i,j);
					al.add(cnt);
				}
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(int q : al)
		{
			System.out.println(q);
		}
	}
	
	public static void dfs(int si, int sj){
		visited[si][sj] = true;
		
		for(int k=0; k<4; k++) {
			int ni = si+di[k];
			int nj = sj+dj[k];
			if((ni > 0 && ni< n+1) && (nj >0 && nj <n+1)) {
				if(visited[ni][nj] == false && arr[ni][nj] == 1) {
					cnt++;
					dfs(ni,nj);
				}
			}
		}
	}
}
