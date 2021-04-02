package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_좋다 {
	public static int n;
	public static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			check(arr[i]);
		}
	}
	public static void check(int target) {
		
		int start =0, end = arr.length-1;
		int result1 = -1, result2= -1;
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[start] + arr[end] > target) {
				end = mid;
			}else if(arr[start] + arr[end] == target) {
				result1 = start; result2 = end;
				break;
			}else if(arr[start] + arr[end]  < target) {
				start = mid;
			}else if(start == mid) break;
		}
		System.out.println(result1 + " " + result2);
	}
}
