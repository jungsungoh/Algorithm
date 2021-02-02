import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	static boolean[][] visited;
	static int[][] arr,arr2;
	static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1][m+1];
		arr2 = new int[n+1][m+1];
		for(int i=1 ;i<=n; i++) {
			for(int j=1; j<=m; j++) {
				arr[i][j] = sc.nextInt();
				arr2[i][j] = arr[i][j];
			}
		}
		int year = 0;
		int num = bfs();
		if(num>=2) {
			System.out.println(year);
			return;
		}
		while(true) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(arr2[i][j] != 0) {
						for(int k=0; k<4; k++) {
							int ni = i+di[k];
							int nj = j+dj[k];
							if(ni>0 && ni<=n && nj>0 && nj<=m) {
								if(arr2[ni][nj] <= 0) {
									arr[i][j]--;
								}
							}
						}
					}
				}
			}
			year++;
			//System.out.println(year + "³âÀÌ Èê·¶½À´Ï´Ù.");
			//print();
			//System.out.println("=============");
			num = bfs();
			//System.out.println("num = " + num);
			if(num>=2) {
				break;
			}
			if(num==0) {
				year = 0;
				break;
			}
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m ; j++) {
					arr2[i][j] = arr[i][j];
				}
			}
		}
		System.out.println(year);
	}
	static int bfs() {
		int cnt =0;
		visited = new boolean[n+1][m+1];
		for(int i=1;i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(arr[i][j] >0 && visited[i][j] ==false) {
					//System.out.println("i = " + i + " j = " + j);
					Queue<point> q = new LinkedList<>();
					q.add(new point(i,j));
					visited[i][j] = true;
					while(!q.isEmpty()) {
						point p1 = q.poll();
						for(int k=0; k<4; k++) {
							int ni = p1.x + di[k];
							int nj = p1.y + dj[k];
							if(ni>0 && ni<=n && nj>0 && nj<=m) {
								if(arr[ni][nj] >0 && visited[ni][nj] == false) {
									q.add(new point(ni,nj));
									visited[ni][nj] = true;
								}
							}
						}
					}
					cnt++;
				}			
				
			}
		}
		return cnt;
		
	}
	static void print() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m ;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	static class point{
		int x;
		int y;
		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
