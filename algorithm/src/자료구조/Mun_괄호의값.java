package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class Mun_괄호의값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> st = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ')') {
				while(!st.isEmpty()) {
					char ch = st.pop();
					if(ch == '(') {
						break;
					}
				}
			}
		}
		// stack에 (, [ 이거면 넣기, ),]나오면 (,[ 까지 지우고
		// 
		
	}
}
