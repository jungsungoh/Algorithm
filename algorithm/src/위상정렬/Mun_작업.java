package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_작업 {
	public static int n;
	public static ArrayList<Integer>[] al;
	public static int[] pointed_cnt, each_time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		pointed_cnt = new int[n+1];
		each_time = new int[n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			each_time[i] = time;
			for(int j=0; j<num; j++) {
				int v2 = Integer.parseInt(st.nextToken());
				al[i].add(v2);
				pointed_cnt[v2]++;
			}
		}
		topol_sort();
	}
	public static void topol_sort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[n+1];
		for(int i=1; i<=n; i++) {
			result[i] = each_time[i];
			if(pointed_cnt[i] == 0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : al[cur]) {
				pointed_cnt[next]--;
				result[next] = Math.max(result[next], result[cur]+each_time[next]);
				if(pointed_cnt[next] == 0) {
					q.add(next);
				}
			}
		}
		int max = 0;
		for(int i=1; i<=n; i++) {
			max = Math.max(result[i], max);
		}
		System.out.println(max);
	}
}
