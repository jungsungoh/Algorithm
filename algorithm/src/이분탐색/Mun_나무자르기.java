package 이분탐색;

import java.util.Scanner;

public class Mun_나무자르기 {
	public static int n, m, result = 0;
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		n = sc.nextInt();
		m =sc.nextInt();

		arr = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		binarySearch();
		System.out.println(result);
	}
	public static void binarySearch() {

		int start = 0, end = 2000000000;
		while(start <= end) {
			int mid = (start+end)/2;
			if(check(mid)) {
				result = Math.max(mid,  result);
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
	}
	public static boolean check(int target) {

		long sum = 0;
		for(int i=0; i<n; i++) {
			if(arr[i]-target>= 0) {
				sum += (arr[i]-target);
			}
		}
		if(sum >= m ) {
			return true;
		}else {
			return false;
		}
	}
}
