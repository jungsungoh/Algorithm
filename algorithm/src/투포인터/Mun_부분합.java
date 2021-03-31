package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int s = Integer.parseInt(l1.split(" ")[1]);
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이
		// 투포인터
		// start =0, end = 0
		// end를 증가시키면서 합이 s이상되면 기록
		// start 증가시켜서 s이하될때까지 다시 s증가

		int start = 0, end = 0, length = Integer.MAX_VALUE;
		int sum = 0;
		while(true) {
			if(sum >= s){
				length = Math.min(length, end-start);
				sum-=arr[start++];
			}else if(end == n) break;
			else {
				sum+=arr[end++];
			}
		}
		if(length == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(length);
		}
	}
}
