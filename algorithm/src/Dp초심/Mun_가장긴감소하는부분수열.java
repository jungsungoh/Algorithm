package Dp초심;

import java.util.Scanner;

public class Mun_가장긴감소하는부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]  = sc.nextInt();
		}
		int[] d = new int[n];
		d[0] = 1;
		int max = d[0];
		for(int i=0; i<n; i++) {
			d[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i]< arr[j]) {
					d[i] = Math.max(d[i], d[j]+1);
					max = Math.max(d[i], max);
				}
			}
		}
		System.out.println(max);
	}
}
