package online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mun_가르침 {
	static int n, m, max;
	static String[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		arr = new String[n];
		visited = new boolean[26];
		max = 0;
		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			arr[i] = l2.substring(4, l2.length() -4);
			//System.out.println(arr[i]);
		}
		visited['a'-'a'] = true;visited['n'-'a'] = true;visited['t'-'a'] = true;visited['i'-'a'] = true;visited['c'-'a'] = true;
		m -= 5;
		dfs(0,0);
		System.out.println(max);
	}
	static void dfs(int idx, int cnt) {
		if(cnt == m) {
			int check = 0;
			for(int i=0; i<n; i++) {
				int flag = 0;
				for(int j=0; j<arr[i].length();j++) {
					if(!visited[arr[i].charAt(j)-'a']) {
						flag = 1;
						break;
					}
				}
				if(flag == 0) {
					check++;
				}
			}
			max = Math.max(max, check);
			return;
		}
		for(int i= idx; i<26; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt+1);
				visited[i] = false;
			}
		}
	}
}
