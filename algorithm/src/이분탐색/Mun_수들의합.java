package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mun_수들의합 {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int val = Integer.parseInt(st.nextToken());
			int uidx = upper_bound(val);
			int lidx = lower_bound(val);
			System.out.print((uidx-lidx) + " ");
		}
	}
	public static int lower_bound(int target) {
		int start = 0;
		int end = arr.length;
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[mid] >= target) end = mid;
			else start = mid+1;
		}
		return start;
	}
	
	public static int upper_bound(int target) {
		int start = 0;
		int end = arr.length;
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[mid] > target) end = mid;
			else start = mid+1;
		}
		return start;
	}
	
}
