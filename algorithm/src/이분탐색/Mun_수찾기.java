package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int j = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<j;i++) {
			int result = search(arr,Integer.parseInt(st.nextToken()));
			if(result == -1) System.out.println(0);
			else {
				System.out.println(1);
			}
		}
	}
	public static int search(int[] arr, int value) {
		
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(arr[mid] > value) end = mid-1;
			else if(arr[mid] < value)start = mid+1;
			else if(arr[mid] == value) return mid;
		}
		return -1;
	}
}
