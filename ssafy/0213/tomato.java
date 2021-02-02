import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int m, n,h;
	static int[][][] arr;
	static boolean[][][] visited;
	static int[] di = {0,0,1,-1,0,0};
	static int[] dj = {1,-1,0,0,0,0};
	static int[] dh = {0,0,0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		h = sc.nextInt();
		arr = new int[h+1][m+1][n+1];
		visited = new boolean[h+1][m+1][n+1];
		for(int k=1; k<=h; k++) {
			for(int i=1; i<=m; i++) {
				for(int j=1; j<=n;j++) {
					arr[k][i][j] = sc.nextInt();
				}
			}
		}
		Queue<point> q = new LinkedList<>();
		for(int k=1; k<=h; k++) {
			for(int i=1; i<=m; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[k][i][j] == 1) {
						q.add(new point(i,j,k));	
						visited[k][i][j] = true;
					}
				}
			}
		}
		int dist = 0;
		int flag = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				point num = q.poll();
				for(int k=0; k<6; k++) {
					int ni = num.x+di[k];
					int nj = num.y+dj[k];
					int nh = num.h +dh[k];
					if(ni>0 && ni<=m && nj>0 && nj<=n && nh>0 && nh<=h) {
						if(arr[nh][ni][nj] == 0 && !visited[nh][ni][nj]) {
							arr[nh][ni][nj] = 1;
							visited[nh][ni][nj] = true;
							q.add(new point(ni,nj,nh));
						}
					}
				}
			}

			dist++;
			
		}
		for(int k=1; k<=h; k++) {
			for(int i=1; i<=m; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[k][i][j] ==0) {
						flag = -1;
						break;
					}
				}
			}
		}
		if(flag!=0) {
			System.out.print(-1);
		}
		else {
			System.out.print(dist-1);
		}
		
	}
	static class point{
		int x;
		int y;
		int h;
		point(int x, int y, int h){
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
}

