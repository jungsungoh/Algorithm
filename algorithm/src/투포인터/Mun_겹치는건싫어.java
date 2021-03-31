package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_겹치는건싫어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
	
		int[] arr = new int[n];
		int[] cnt = new int[100001];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int start =0, end = 0, result = 0;
		int max = 0;
		while(true) {
			if(end == n) break;
			else	if(cnt[arr[end]] >=k) {
				cnt[arr[start++]]--;
				result--;
			}else {
				result++;
				max = Math.max(result,max);
				cnt[arr[end++]]++;
			}
		}
		System.out.println(max);
	}
}
