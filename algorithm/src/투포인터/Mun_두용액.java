package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_두용액 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int start =0, end = n-1;
		int result = Integer.MAX_VALUE, result1 = -1, result2 = -1;
		while(start != end) {
			System.out.println(arr[start] + " " + arr[end]);
			if(Math.abs(arr[start] + arr[end]) < result) {
				result = Math.abs(arr[start] + arr[end]);
				result1 = start; result2 = end;
			}
			
			if(Math.abs(arr[start+1] + arr[end]) <= Math.abs(arr[start] + arr[end-1])){
				start++;
			}else {
				end--;
			}
		}
		System.out.println(arr[result1] + " " + arr[result2]);
	}
}
