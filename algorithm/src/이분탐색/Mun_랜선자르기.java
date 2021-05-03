package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_랜선자르기 {
	public static int[] arr;
	public static int n, k, maxval;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt(); // 필요한 랜선 개수
		n = sc.nextInt(); // 이미 가지고 있는 랜선 개수
		
		
		arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		binarySearch();
		
		
	}
	public static void binarySearch() {
		
		long start = 0, end = Long.MAX_VALUE;
		long max = 0;
		while(start <= end) {
			long mid = (start+end)/2;
			if(check(mid)) {
				max = Math.max(max,  mid);
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		System.out.println(max);
	}
	
	public static boolean check(long target) {
		if(target == 0) return false;
		long cnt = 0;
		for(int i=0; i<k;i++) {
			cnt += (arr[i]/target);
		}
		if(cnt >= n) {
			return true;
		}else {
			return false;
		}
	}
}
