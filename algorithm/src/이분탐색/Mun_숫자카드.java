package 이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_숫자카드 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		for(int i=0; i<m; i++) {
			int flag = binarySearch(sc.nextInt(), arr);
			if(flag == -1) {
				System.out.print(0 + " ");
			}else {
				System.out.print(1 + " ");
			}
		}
	}
	public static int binarySearch(int target, int[] arr) {
		
		int start = 0, end = arr.length-1;
		
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(arr[mid] > target) {
				end = mid-1;
			}else if(arr[mid] < target){
				start = mid+1;
			}else if(arr[mid] ==target) {
				return mid;
			}
		}
		return -1;
		
		
		
	}
}
