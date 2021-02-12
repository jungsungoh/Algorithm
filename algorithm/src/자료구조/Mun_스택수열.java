package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Mun_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int pr = 1;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(true) {
				if(st.isEmpty() || (!st.isEmpty() && num >= st.peek())) {
					st.push(pr++);
				}
			}
		}
	}
}
