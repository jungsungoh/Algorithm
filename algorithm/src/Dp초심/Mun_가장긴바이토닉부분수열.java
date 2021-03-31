package Dp초심;

import java.util.Scanner;

public class Mun_가장긴바이토닉부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ld = new int[n];
		ld[0] = 1;
		int[] rd = new int[n];
		rd[0] = 1;
		for(int i=0; i<n; i++) {
			ld[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					ld[i] = Math.max(ld[i], ld[j]+1);
				}
			}
		}
		for(int i=n-1; i>=0; i--) {
			rd[i] = 1;
			for(int j=n-1;j>i; j--) {
				if(arr[j] < arr[i]) {
					rd[i] = Math.max(rd[i], rd[j]+1);
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(rd[i]+ld[i], max);
		}
		System.out.println(max-1);
	}
}
