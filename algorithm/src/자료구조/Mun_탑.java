package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mun_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		Stack<point> st = new Stack<>();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=n-1; i>=0; i--) {
			if(!st.isEmpty() && st.peek().val <=arr[i]) {
				while(!st.isEmpty()) {
					int num = st.peek().val;
					if(num <= arr[i]) {
						point p = st.pop();
						result[p.idx]= i+1; 
					}else {
						break;
					}
				}
				st.push(new point(arr[i],i));
			}else {
				st.push(new point(arr[i],i));
			}
		}
		while(!st.isEmpty()) {
			point p = st.pop();
			result[p.idx]= 0; 
		}
		
		for(int i=0; i<result.length;i++) {
			System.out.print(result[i]+ " ");
		}
	}
	public static class point{
		int val, idx;

		public point(int val, int idx) {
			super();
			this.val = val;
			this.idx = idx;
		}
	}
}



// 6 9 5 7 6 4 3 4 8

