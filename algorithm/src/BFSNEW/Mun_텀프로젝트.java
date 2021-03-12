package BFSNEW;

import java.io.IOException;
import java.util.Scanner;

public class Mun_텀프로젝트 {
	public static boolean[] visited, finished;
	public static int[] want;
	public static int n, cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int TC= sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			cnt = 0;
			int n = sc.nextInt();
			want = new int[n+1];
			visited= new boolean[n+1];
			finished = new boolean[n+1];
			for(int i=1; i<=n; i++) {
				want[i] = sc.nextInt();
			}
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			System.out.println(n-cnt);
		}
	}

	public static void dfs(int v) {
		visited[v] = true;

		int next = want[v];
		if(!visited[next])
			dfs(next);
		else if(!finished[next]) {
			for(int i=next; i != v; i = want[i]) {
				cnt++;
			}
			cnt++;
		}
		finished[v] = true;
	}
}
