package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_예싼 {
	public static int n;
	public static long max_budget;
	public static long[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new long[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		max_budget = sc.nextLong();
		binarySearch();
	}
	public static void binarySearch() {
		
		long start = 0, end = max_budget;
		long max = 0;
		while(start<= end) {
			long mid = (start+end)/2;
			if(check(mid)) {
				start = mid+1;
				max = Math.max(max, mid);
			}else {
				if(check2(mid)) {
					max = Math.max(max, mid);
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}
		System.out.println(max);
	}
	public static boolean check2(long mid) {
		long sum = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[i] <= mid) {
				sum+= arr[i];
			}else {
				sum+= mid;
			}
		}
		if(sum <= max_budget) {
			return true;
		}else {
			return false;
		}
		
	}
	public static boolean check(long mid) {
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum+= arr[i];
		}
		if(sum <= max_budget) {
			return true;
		}else {
			return false;
		}
		
	}
}
