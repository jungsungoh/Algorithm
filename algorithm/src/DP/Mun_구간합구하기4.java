package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] d = new int[100001];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			d[i] = d[i-1] + arr[i];
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			
			System.out.println(d[high] - d[low-1]);
		}
	}
}
