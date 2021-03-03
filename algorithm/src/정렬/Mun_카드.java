package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mun_카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		int cnt = 0;
		long maxval = Long.MIN_VALUE;
		int maxcnt = 0;
		
		for(int i=0; i<n ; i++) {
			if(i==0 || arr[i-1] == arr[i]) cnt++;
			else {
				if(cnt > maxcnt) {
					maxcnt = cnt;
					maxval = arr[i-1];
				}
				cnt = 1;
			}
		}
		if(cnt > maxcnt) {
			maxval = arr[n-1];
		}
		System.out.println(maxval);
	}
}
