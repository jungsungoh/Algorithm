package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mun_영우는사기꾼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split( " ")[1]);
		int k = Integer.parseInt(l1.split(" ")[2]);
		
		ArrayList<Integer>[] al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		
		int[] pointed_cnt = new int[n+1];
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			al[v1].add(v2);
			pointed_cnt[v2]++;
		}
		
		int[] isconst = new int[n+1];
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int state = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(state == 1) {
				boolean flag = false;
				if(pointed_cnt[num] == 0) {
					if(isconst[num] == 0) {
						for(Integer next : al[num]) {
							pointed_cnt[next]--;
						}
					}
					isconst[num]++;
				}else {
					System.out.println("Lier!");
					return;
				}
			}else {
				if(isconst[num] > 0) {
					isconst[num]-=1;
					if(isconst[num] == 0) {
						for(Integer next : al[num]) {
							pointed_cnt[next]++;
						}
					}
				}else {
					System.out.println("Lier!");
					return;
				}
			}
		}
		System.out.println("King-God-Emperor");
		
	}
}
