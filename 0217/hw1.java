package per;

import java.util.Arrays;
import java.util.Scanner;

public class hw1 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[4];
		for(int i=0; i <4; i++) {
			arr[i] = sc.nextInt();
		}
		johnsonTrotter(4,0);
	}
	static void johnsonTrotter(int n, int k) {
		if(k == n) {
			for(int i=0; i<n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		else {
			for(int i=k; i<n; i++) {
				swap(k,i);
				johnsonTrotter(n,k+1);
				swap(k,i);
			}
		}
	}
	static void swap(int k, int i) {
		int tmp = arr[k];
		arr[k] = arr[i];
		arr[i] = tmp;
	}
}
