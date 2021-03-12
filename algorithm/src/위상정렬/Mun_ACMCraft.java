package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_ACMCraft {
	public static int n, m, find;
	public static int[] arr, pointed_cnt;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String l1 = br.readLine();
			n = Integer.parseInt(l1.split(" ")[0]);
			m = Integer.parseInt(l1.split(" ")[1]);
			arr = new int[n+1];
			pointed_cnt = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			al = new ArrayList[n+1];

			for(int i=1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				al[i] = new ArrayList<>();
			}

			for(int i=1; i<=m; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				al[v1].add(v2);
				pointed_cnt[v2]++;
			}
			find = Integer.parseInt(br.readLine());
			topol_sort();
		}
	}
	public static void topol_sort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[n+1];
		for(int i=1; i<=n ;i++) {
			if(pointed_cnt[i] == 0) {
				q.add(i);
				result[i] = arr[i];
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : al[cur]) {
				result[next] = Math.max(result[next], result[cur] + arr[next]);
				pointed_cnt[next]--;
				if(pointed_cnt[next] == 0) {
					q.add(next);
				}
			}

		}
		System.out.println(result[find]);
	}
}
