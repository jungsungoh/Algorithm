package Dp초심;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Mun_가장긴증가하는부분수열2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] d = new int[n];
		d[0] = 1;
		int max = d[0];
		for(int i=0; i<n; i++) {
			d[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					d[i] = Math.max(d[i], d[j] + 1);
					max = Math.max(d[i], max);
				}
			}
		}
		int val = max;
		System.out.println(max);
		Stack<Integer> st = new Stack<>();
		for(int i= n-1; i>=0 ; i--) {
			if(val == d[i]) {
				st.add(arr[i]);
				val--;
			}
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
}
