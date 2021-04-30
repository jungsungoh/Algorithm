package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_주몽 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		twopoint(arr,m,n);
	}
	public static void twopoint(int[] arr, int m, int n) {
		
		int start = 0, end = n-1;
		int cnt = 0;
		while(start<end) {
			int sum = arr[start] + arr[end];
			if(sum == m) {
				start++;
				end--;
				cnt++;
			}else if(sum > m) {
				end--;
			}else if(sum < m) {
				start++;
			}
		}
		System.out.println(cnt);
	}
}
