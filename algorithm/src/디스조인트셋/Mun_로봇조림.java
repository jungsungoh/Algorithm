package 디스조인트셋;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Mun_로봇조림 {
	public static int[] parents, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		parents = new int[1000001];
		cnt = new int[1000001];
		for(int i=0; i<parents.length; i++) {
			makeSet(i);
		}
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String com = st.nextToken();
			if(com.equals("I")) {
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				union(v1, v2);
			}else {
				int v1 = Integer.parseInt(st.nextToken());
				bw.append(String.valueOf(cnt[findSet(v1)]));
				bw.newLine();
			}
		}
		bw.flush();
		
		
	}
	public static void makeSet(int x) {
		parents[x] = x;
		cnt[x] = 1;
	}
	public static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		}
		return parents[x] = findSet(parents[x]);
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(px != py) {
			cnt[py] += cnt[px];
			cnt[px] = 0;
			parents[px] = py;
		}
	}
	
	
	
}
