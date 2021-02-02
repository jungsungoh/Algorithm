package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Mun_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			Stack<Character> st  = new Stack<>();
			for(int j=0; j<s.length(); j++) {
				if(!st.isEmpty() && st.peek() == '(' && s.charAt(j) == ')' ){
					st.pop();
				}else {
					st.push(s.charAt(j));
				}
			}
			if(st.size() != 0) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
		}
	}
}
