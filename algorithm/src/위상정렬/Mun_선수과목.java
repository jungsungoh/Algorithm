package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Mun_선수과목 {
	public static int n, m;
	public static int[] pre_cnt, result;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		pre_cnt = new int[n+1];
		al = new ArrayList[n+1];
		result = new int[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(v2); 
			pre_cnt[v2]++; // v2 가르키는놈들
		}
		topol_sort();
		for(int i=1; i<=n; i++) {
			System.out.print(result[i] + " ");
		}
	}
	public static void topol_sort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(pre_cnt[i] == 0) {
				q.add(i);
			}
		}
		int time = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s=0; s<size; s++) {
				int cur = q.poll();
				result[cur]= time;
				for(int next : al[cur]) {
					pre_cnt[next]--;
					if(pre_cnt[next] == 0) {
						q.add(next);
					}
				}
			}time++;
		}
	}
}
