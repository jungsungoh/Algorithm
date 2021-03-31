package Dp초심;

import java.util.Scanner;

public class Mun_가장큰증가부분수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] d = new int[n];
		d[0] = arr[0];
		int max = d[0];
		for(int i=0; i<n; i++) {
			d[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					d[i] = Math.max(d[i], d[j] + arr[i]);
					max = Math.max(d[i], max);
				}
			}
		}
		System.out.println(max);
	}
}
