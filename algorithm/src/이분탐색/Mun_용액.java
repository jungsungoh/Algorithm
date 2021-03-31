package 이분탐색;

import java.util.Scanner;

public class Mun_용액 {
	public static int[] arr;
	public static int n ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(arr[i] >0) break;
			int idx = upper_bound(Math.abs(arr[i]));
			System.out.println(idx);
		}
	}
	public static int upper_bound(int target) {
		
		int start = 0;
		int end = arr.length;
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[mid] >=target) end = mid;
			else start = mid +1;
		}
		return start;
	}
}
