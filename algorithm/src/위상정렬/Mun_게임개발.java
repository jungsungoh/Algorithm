package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_게임개발 {
	public static int n;
	public static int[] pointed_cnt, time;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		pointed_cnt = new int[n+1];
		time = new int[n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) {
					break;
				}else {
					al[num].add(i);
					pointed_cnt[i]++;
				}
			}
		}
		topolsort();
		
	}
	public static void topolsort() {
		Queue<Integer> q = new LinkedList<>();
		int[] max_time = new int[n+1];
		for(int i=1; i<=n; i++) {
			if(pointed_cnt[i] == 0) {
				q.add(i);
				max_time[i] = time[i];
			}
		}
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for(Integer next : al[num]) {
				max_time[next] = Math.max(max_time[next], max_time[num] + time[next]);
				pointed_cnt[next]--;
				if(pointed_cnt[next] == 0) {
					q.add(next);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.println(max_time[i]);
		}
		
	}
}


// 5
//10 -1
//10 1 -1
//4 1 -1
//4 3 1 -1
//3 3 -1