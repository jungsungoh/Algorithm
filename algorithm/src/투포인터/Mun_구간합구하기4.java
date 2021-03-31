package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m =Integer.parseInt(l1.split(" ")[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] check = new int[200001];
		int start =0, end = 0, len = 0;
		int max = 0;
		while(true) {
			if(end == n) break;
			else if(check[arr[end]] <m) {
				check[arr[end]]++;
				end++;
				len++;
				max = Math.max(len, max);
			}else if(check[arr[end]]>=m) {
				check[arr[start]]--;
				start++;
				len--;
			}
		}
		
		System.out.println(max);
	}
}
