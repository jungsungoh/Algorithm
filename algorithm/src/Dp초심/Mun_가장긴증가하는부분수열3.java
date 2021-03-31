package Dp초심;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Mun_가장긴증가하는부분수열3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] idx = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> al =new ArrayList<>();
		al.add(Integer.MIN_VALUE);
		
		for(int i=0; i<n; i++) {
			if(al.get(al.size()-1) < arr[i]) {
				al.add(arr[i]);
				idx[i] = al.size()-1;
			}else {
				int start = 1;
				int end = al.size()-1;
				while(start < end) {
					int mid = (start+end)/2;
					if(al.get(mid) < arr[i] ) {
						start = mid+1;
					}else {
						end = mid;
					}
				}
				al.set(end, arr[i]);
				idx[i] = end;
			}
		}
		System.out.println(al.size() -1);
		
		Stack<Integer> st = new Stack<>();
		int index = al.size()-1;
		for(int i = n-1; i>=0 ; i--) {
			if(index == idx[i]) {
				st.add(arr[i]);
				index--;
			}
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
}
