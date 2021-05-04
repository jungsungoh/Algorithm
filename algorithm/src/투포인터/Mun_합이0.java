package 투포인터;

import java.util.Scanner;

public class Mun_합이0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		
	}
	public static void twopoint(int[] arr) {
		int n = arr.length;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			
			
			int start = 0, end = n-1;
			
			while(true) {
				
				if(start == i) {
					start++;
				}else if(end == i) {
					end--;
				}
			}
		}
	}
}
