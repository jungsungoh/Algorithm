package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mun_랜선자르기 {
	public static int n, find, max = 0;
	public static long answer = 0;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		find = Integer.parseInt(l1.split(" ")[1]);
		
		arr = new int[n];
		
		max = 0;
		for(int i=0; i<n; i++) {
			int length = Integer.parseInt(br.readLine());
			arr[i] = length;
			max = Math.max(length, max);
		}
		answer = binary_search();
		System.out.println(answer);
	}
	public static long binary_search() {
		long start = 1;
		long end = max;
		while(start <= end) {
			long count = 0;
			long mid = (start+end)/2;
			for(int i=0; i<arr.length; i++) {
				count += arr[i] / mid;
			}
			
			if(count >= find) {
				start = mid+1;
			}else {
				end = mid -1;
			}
		}
		return start;
	}
}
