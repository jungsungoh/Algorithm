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
		
		int start = 0, end = 0;
		int cnt = 0;
		while(true) {
			if(end >= n) break;
			if(arr[start] + arr[end] == m) {
				end++;
				cnt++;
			}else if(arr[start] + arr[end] > m) {
				start++;
			}else if(arr[start] + arr[end] < m) {
				end++;
			}
		}
		System.out.println(cnt);
	}
}
